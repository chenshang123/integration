package team.sun.integration.protocol.tcp.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.sun.integration.protocol.hex.convert.pack.PackConvertService;
import team.sun.integration.protocol.hex.convert.unpack.UnpackConvertService;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import team.sun.integration.protocol.tcp.channel.ChannelHandlerContextMap;

/***
 * 服务端自定义业务处理handler
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {

    /**
     * 对每一个传入的消息都要调用；
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){

        ByteBuf buf = (ByteBuf) msg;
        byte[] in = new byte[buf.readableBytes()];
        buf.readBytes(in);
        HexStringCovert.bytesToBinaryString(in);
        System.out.println(HexStringCovert.bytesToBinaryString(in));
        System.out.println();
  /*      Map<String, Object> jsonMap = parsProfileConvertService.toMap(in);
        if(null != jsonMap && null != jsonMap.get("topic")){
            //更新缓存数据
            String topic = jsonMap.get("topic").toString();
            boolean isContainsKey = ChannelHandlerContextMap.map.containsKey(topic);
            if(!isContainsKey){
                ChannelHandlerContextMap.add(topic, ctx);
            }
            //解析报文数据，并发送http请求到服务器
            String jsonStr = packProfileConvertService.getPackMap(jsonMap);

            if(StringUtils.hasLength(jsonStr)){
                System.out.println(jsonStr);
            }
        }*/
    }


    /**
     * 通知ChannelInboundHandler最后一次对channelRead()的调用时当前批量读取中的的最后一条消息。
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
//        .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 在读取操作期间，有异常抛出时会调用。
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 客户端失去连接
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelInactive(ctx);
        ChannelHandlerContextMap.remove(ctx);
        System.out.println("服务端：客户端失去连接，已移除通道。");

    }

    /**
     * 客户端注册
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelRegistered(ctx);
        System.out.println("服务端：客户端注册。");

    }

}
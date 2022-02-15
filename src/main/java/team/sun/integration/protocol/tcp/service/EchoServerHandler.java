package team.sun.integration.protocol.tcp.service;

import cn.hutool.core.util.HexUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.sun.integration.protocol.hex.convert.unpack.UnpackConvertService;
import team.sun.integration.protocol.hex.utils.HexStringCovert;
import team.sun.integration.protocol.tcp.channel.ChannelCatchMap;

import java.util.Map;

/***
 * 服务端自定义业务处理handler
 */

@Component
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {
    @Autowired
    public EchoServerHandler(UnpackConvertService unpackConvertService){
        this.unpackConvertService = unpackConvertService;
    }
    private final UnpackConvertService unpackConvertService;

    /**
     * 对每一个传入的消息都要调用；
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){

        ByteBuf buf = (ByteBuf) msg;
        byte[] in = new byte[buf.readableBytes()];
        buf.readBytes(in);
        HexStringCovert.bytesToBinaryString(in);
        String HexString = HexUtil.encodeHexStr(in);

        Map<String, Object> jsonMap;
        //不规范协议处理
        if(HexString.endsWith("c33c")){
            unpackConvertService.cont(HexString, unpackConvertService.getProtocolCode(in, 0, 2));
        }else{
            jsonMap = unpackConvertService.toMap(in);
        }

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
        ChannelCatchMap.remove(ctx);
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
package team.sun.integration.protocol.tcp.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户端处理类
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 在到服务器的连接已经建立之后将被调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ChannelHandlerContextMap.add(PropertyUtil.getProperty("printer.model"), ctx);
        //初始打印
        ctx.writeAndFlush(Unpooled.copiedBuffer(">BON>|123|12345679|1^CMD_PRINTON`MSG001|=EOC=", CharsetUtil.UTF_8));
    }

    /**
     * 在处理过程中引发异常时被调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 当从服务器接收到一个消息时被调用
     * @param ctx
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        String msg = byteBuf.toString(CharsetUtil.UTF_8);
        if("<BON<|123|12345679|1^CMD_OK`CMD_PRINTOFF|=EOC=".equals(msg)){
            ctx.channel().close();
        }
        System.out.println("Client received: "+ msg);
    }
}


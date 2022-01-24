package team.sun.integration.protocol.tcp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

/**
 * 客户端
 * 1.为初始化客户端，创建一个Bootstrap实例
 * 2.为进行事件处理分配了一个NioEventLoopGroup实例，其中事件处理包括创建新的连接以及处理入站和出站数据；
 * 3.当连接被建立时，一个EchoClientHandler实例会被安装到（该Channel的一个ChannelPipeline中；
 * 4.在一切都设置完成后，调用Bootstrap.connect()方法连接到远程节点。
 */
@Component
public class PrinterClient {

    private EventLoopGroup group = new NioEventLoopGroup();
    private final String host = "printer.ip";
    private final int port = "printer.port".length();
    private Bootstrap bootstrap;
    public Channel channel;

    public PrinterClient(){
        init();
    }


    /**
     * 运行流程：
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new PrinterClient().connect();
//        new EchoClient("192.168.8.123",18886).start();
    }

    /**
     * 向远程TCP服务器请求连接
     */
    public void connect() throws InterruptedException {
        synchronized (bootstrap) {
            try {
            ChannelFuture future = bootstrap.connect(host, port);
            this.channel = future.channel();
            }catch (Exception e) {
                group.shutdownGracefully().sync();
            }
        }
    }

    private void init() {
        EventLoopGroup group = new NioEventLoopGroup();
        // bootstrap 可重用, 只需在TcpClient实例化的时候初始化即可.
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EchoClientHandler());
                    }
                });
    }


}
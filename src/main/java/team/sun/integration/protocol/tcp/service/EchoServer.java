package team.sun.integration.protocol.tcp.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * 服务端
 * 1.创建一个ServerBootstrap的实例引导和绑定服务器。
 * 2.创建并分配一个NioEventLoopGroup实例以进行事件的处理，比如接受连接以及读写数据。
 * 3.指定服务器绑定的本地的InetSocketAddress。
 * 4.使用一个EchoServerHandler的实例初始化每一个新的Channel。
 * 5.调用ServerBootstrap.bind()方法以绑定服务器。
 */
public class EchoServer {

    /**
     * NioEventLoop并不是一个纯粹的I/O线程，它除了负责I/O的读写之外
     * 创建了两个NioEventLoopGroup，
     * 它们实际是两个独立的Reactor线程池。
     * 一个用于接收客户端的TCP连接，
     * 另一个用于处理I/O相关的读写操作，或者执行系统Task、定时任务Task等。
     */
    private final EventLoopGroup bossGroup = new NioEventLoopGroup(1); //用于处理服务器端接收客户端连接
    private final EventLoopGroup workerGroup = new NioEventLoopGroup(2); //进行网络通信(读写)
    private Channel channel;


    /**
     * 启动服务
     */
    public ChannelFuture start(String hostname, int port){
        ChannelFuture f = null;
        try {
            //ServerBootstrap负责初始化netty服务器，并且开始监听端口的socket请求
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(hostname,port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel){
//                            为监听客户端read/write事件的Channel添加用户自定义的ChannelHandler
                            socketChannel.pipeline().addLast(new EchoServerHandler());

                        }
                    }).option(ChannelOption.SO_BACKLOG, 128) //设置TCP三次握手建立链接的缓冲区大小,超过缓冲区大小将无法建立链接.
                    .option(ChannelOption.SO_RCVBUF, 5 * 1024) //设置接受数据缓冲大小
                    .childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(5 * 1024))
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //保持连接
                    .childOption(ChannelOption.TCP_NODELAY, true);//禁用nagle算法

            f = b.bind().sync();
            channel = f.channel();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (f != null && f.isSuccess()) {
                System.out.println("Netty server listening " + hostname + " on port " + port + " and ready for connections...");
//                log.info("Netty server listening " + hostname + " on port " + port + " and ready for connections...");
            } else {
                System.out.println("Netty server start up Error!");
//                log.error("Netty server start up Error!");
            }
        }
        return f;
    }

    /**
     * 停止服务
     */
    public void destroy() {
//        log.info("Shutdown Netty Server...");
        System.out.println("Shutdown Netty Server...");
        if(channel != null) { channel.close();}
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
//        log.info("Shutdown Netty Server Success!");
    }

}


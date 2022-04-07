package team.sun.integration.protocol.tcp;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import team.sun.integration.protocol.tcp.service.EchoServer;

//@Component
public class NettyApplication implements CommandLineRunner {

    @Value("${netty.tcp.port}")
    private int port;

    @Value("${netty.tcp.url}")
    private String url;

    @Autowired
    public NettyApplication(EchoServer echoServer){
        this.echoServer = echoServer;
    }
    private final EchoServer echoServer;

    @Override
    public void run(String... args){
//        EchoServer echoServer = new EchoServer();
        ChannelFuture future = echoServer.start(url,port);
        Runtime.getRuntime().addShutdownHook(new Thread(echoServer::destroy));
        //服务端管道关闭的监听器并同步阻塞,直到channel关闭,线程才会往下执行,结束进程
        future.channel().closeFuture().syncUninterruptibly();
    }
}

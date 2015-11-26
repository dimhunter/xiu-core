package com.shen.netty.hello;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 1. Netty的http对象都是Netty自己封装的，不是标准的。
 * 先看http的服务器端。服务器的代码一般就是这样。
 * @author shenluguo
 *
 */
public class HttpDemoServer {
	
	private final int port;
    
	public static boolean isSSL;
 
    public HttpDemoServer(int port) {
        this.port = port;
    }
 
    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new HttpDemoServerInitializer());
 
            Channel ch = b.bind(port).sync().channel();
            System.out.println("HTTP Upload Server at port " + port + '.');
            System.out.println("Open your browser and navigate to http://localhost:" + port + '/');
 
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
 
    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        if (args.length > 1) {
            isSSL = true;
        }
        new HttpDemoServer(port).run();
    }
}

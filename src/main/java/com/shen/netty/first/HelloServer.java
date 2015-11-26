package com.shen.netty.first;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloServer {

	private static final int portNumber = 9991;
	
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			//Netty创建全部都是实现自AbstractBootstrap。客户端的是Bootstrap，服务端的则是ServerBootstrap。
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new HelloServerInitializer());

			// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功。
			ChannelFuture f = b.bind(portNumber).sync();
			System.out.println("started");
			// 应用程序会一直等待，直到channel关闭
			f.channel().closeFuture().sync();

			// 可以简写为
			/* b.bind(portNumber).sync().channel().closeFuture().sync(); */

		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
			System.out.println("over");
		}
	}
}

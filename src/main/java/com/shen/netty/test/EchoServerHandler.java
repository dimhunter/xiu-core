package com.shen.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by shenluguo on 2015/6/17.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory
			.getLogger(EchoServerHandler.class);

	public EchoServerHandler() {
		super();
	}

	private HttpRequest request;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
//		如果不在EchoServer中添加几个http的decoder，这里就是原生的butebuf。不会封装成httprequest等对象。
//		ByteBuf buffer = (ByteBuf)msg;
//		for (int i = 0; i < buffer.capacity(); i ++) {
//			byte b = buffer.getByte(i);
//			System.out.println((char) b);
//		}

		logger.debug("channelRead");
		if (msg instanceof HttpRequest) {
			request = (HttpRequest) msg;

			String uri = request.getUri();
			System.out.println("Uri:" + uri);
		}
		if (msg instanceof HttpContent) {
			HttpContent content = (HttpContent) msg;
			ByteBuf buf = content.content();
			System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
			buf.release();

			String res = "I am OK";
			FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
					OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
			response.headers().set(CONTENT_TYPE, "text/plain");
			response.headers().set(CONTENT_LENGTH,
					response.content().readableBytes());
			if (HttpHeaders.isKeepAlive(request)) {
				response.headers().set(CONNECTION,
						HttpHeaders.Values.KEEP_ALIVE);
			}
			ctx.write(response);
			ctx.flush();
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.debug("channelReadComplete");
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER) // flush掉所有写回的数据
				.addListener(ChannelFutureListener.CLOSE); // 当flush完成后关闭channel
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.debug("exceptionCaught");
		logger.error("", cause);
		ctx.close();
	}

	// public void channelRead(ChannelHandlerContext ctx, Object msg) {
	// System.out.println("server received data :" + msg);
	// ctx.write(msg);//写回数据，
	// }
	// public void channelReadComplete(ChannelHandlerContext ctx) {
	// ctx.writeAndFlush(Unpooled.EMPTY_BUFFER) //flush掉所有写回的数据
	// .addListener(ChannelFutureListener.CLOSE); //当flush完成后关闭channel
	// }
	// public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
	// cause.printStackTrace();//捕捉异常信息
	// ctx.close();//出现异常时关闭channel
	// }

}

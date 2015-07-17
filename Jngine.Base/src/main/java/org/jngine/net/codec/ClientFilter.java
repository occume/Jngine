package org.jngine.net.codec;

import org.jngine.Connector;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
public class ClientFilter extends ChannelInboundHandlerAdapter {
	
	private Connector connector;
	
	private ExceptionHandler exceptionHandler;

	public ClientFilter(Connector connector){
		this.connector = connector;
		exceptionHandler = new ExceptionHandler();
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SocketChannel channel = (SocketChannel) ctx.channel();
		String ip = channel.remoteAddress().getHostString();
		
		if(ip.equals("127.0.0.1")){
			channel.pipeline().addLast(exceptionHandler);
			channel.pipeline().addLast(new FirstDecoder());
			channel.pipeline().addLast(new FirstHandler(connector));
			channel.pipeline().remove(this);
			ctx.fireChannelActive();
		}
		else{
			System.out.println("invalid client");
			channel.close();
		}
	}

}

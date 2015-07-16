package org.jngine.net.codec;

import org.jngine.Connector;
import org.jngine.message.InMessage;
import org.jngine.message.Message;
import org.jngine.net.adapter.ChannelSession;
import org.jngine.net.adapter.RawMessage;
import org.jngine.net.packet.PbDecoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class FirstHandler extends SimpleChannelInboundHandler<RawMessage> {
	
	private Connector connector;
	
	public FirstHandler(Connector connector){
		this.connector = connector;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, RawMessage msg)
			throws Exception {
		dispatch(parse(msg));
	}
	
	private <T> void dispatch(Message<T> msg){
		connector.getEngine().dispatch(msg);
	}
	
	private <T> Message<T> parse(RawMessage msg){
		T t = PbDecoder.parse(1, msg.getData());
		return new InMessage<T>(msg.getId(), msg.getType(), t);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ChannelSession cs = new ChannelSession(ctx.channel());
		connector.getEngine()
				.getContext().getManager()
				.addSession(cs);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("inactive");
	}
}
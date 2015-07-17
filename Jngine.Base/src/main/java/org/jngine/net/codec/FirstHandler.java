package org.jngine.net.codec;

import org.jngine.Connector;
import org.jngine.bean.Login;
import org.jngine.message.InMessage;
import org.jngine.net.adapter.ChannelSession;
import org.jngine.net.adapter.RawMessage;
import org.jngine.net.packet.PbDecoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class FirstHandler extends SimpleChannelInboundHandler<RawMessage> {
	
	private Connector connector;
	private ChannelSession channelSession;
	
	public FirstHandler(Connector connector){
		this.connector = connector;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, RawMessage msg)
			throws Exception {
		dispatch(parse(msg));
	}
	
	private  void dispatch(InMessage msg){
		connector.getEngine().dispatch(msg);
	}
	
	private <T> InMessage parse(RawMessage msg){
//		T t = PbDecoder.parse(1, msg.getData());
		T t = null;
		try {
			t = PbDecoder.parse1(msg.getType(), msg.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
//				.parse(1, msg.getData());
		return new InMessage(channelSession.getSession(), msg.getId(), msg.getType(), t);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		channelSession = new ChannelSession(ctx.channel());
		connector.getEngine()
				.getContext().getManager()
				.addSession(channelSession);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("inactive");
	}
}
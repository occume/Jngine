package org.jngine.net.codec;

import org.jngine.Connector;
import org.jngine.Session;
import org.jngine.core.SessionImpl;
import org.jngine.message.InMessage;
import org.jngine.message.InMessageImpl;
import org.jngine.net.adapter.ChannelSender;
import org.jngine.net.adapter.RawMessage;
import org.jngine.net.adapter.ReplaceSessionable;
import org.jngine.net.adapter.Sendable;
import org.jngine.net.packet.PbDecoder;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class FirstHandler extends SimpleChannelInboundHandler<RawMessage> 
		implements ReplaceSessionable
{
	
	private Connector connector;
	private SessionImpl sessionImpl;
	
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
		return new InMessageImpl(connector.getEngine().getContext(), 
				sessionImpl.getFacade(), msg.getId(), msg.getType(), t).getFacade();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		sessionImpl = (SessionImpl) connector.getEngine()
				.getContext().getManager().createSession();
		sessionImpl.setSender(newSender(ctx.channel()));
		sessionImpl.setReplaceSessionable(this);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("inactive");
	}
	
	private Sendable newSender(Channel channel){
		return new ChannelSender(channel);
	}

	@Override
	public void replaceSession(Session session) {
		if(session instanceof SessionImpl){
			sessionImpl = (SessionImpl) session;
//			sessionImpl.setChannel(ctx.channel());
			sessionImpl.setReplaceSessionable(this);
		}
	}
}
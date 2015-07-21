package org.jngine.net.adapter;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;

public class ChannelSender implements Sendable {
	
	private Channel channel;
	
	public ChannelSender(Channel channel){
		this.channel = channel;
	}

	@Override
	public void send(Object msg) {
		channel.writeAndFlush(msg);
	}

	@Override
	public void sendAndClose(Object msg) {
		channel.writeAndFlush(msg).addListener(ChannelFutureListener.CLOSE);
	}
}

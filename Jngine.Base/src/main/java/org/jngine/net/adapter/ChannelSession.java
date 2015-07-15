package org.jngine.net.adapter;

import io.netty.channel.Channel;

public class ChannelSession {
	
	private Channel channel;

	public ChannelSession(Channel channel){
		this.channel = channel;
	}
	
	public Channel getChannel(){
		return channel;
	}
}

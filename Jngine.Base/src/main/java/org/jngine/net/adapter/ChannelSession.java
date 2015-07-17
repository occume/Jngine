package org.jngine.net.adapter;

import org.jngine.Session;

import io.netty.channel.Channel;

public class ChannelSession {
	
	private Session session;
	private Channel channel;

	public ChannelSession(Channel channel){
		this.channel = channel;
	}
	
	public Channel getChannel(){
		return channel;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public void sendMsg(Object msg){
		channel.writeAndFlush(msg);
	}
}

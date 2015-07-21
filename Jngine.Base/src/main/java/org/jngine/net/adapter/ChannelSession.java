package org.jngine.net.adapter;

import org.jngine.Session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;

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
	
	public void close(){
		session.disconnect();
		session = null;
		channel.close();
	}
	
	public void close(Object msg){
		session.disconnect();
		session = null;
		channel.writeAndFlush(msg).addListener(ChannelFutureListener.CLOSE);
	}
}

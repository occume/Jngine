package org.jngine.core;

import org.jngine.Session;
import org.jngine.net.adapter.ChannelSession;

public class StandardSession implements Session {

	private ChannelSession channelSession;
	
	public StandardSession(ChannelSession channelSession){
		this.channelSession = channelSession;
	}
	
	@Override
	public String getId() {
		return null;
	}

	@Override
	public void sendMsg(Object msg) {
		channelSession.sendMsg(msg);
	}
}
package org.jngine.core;

import org.jngine.Session;

public class SessionFacade implements Session {

	private Session impl;
	
	public SessionFacade(Session impl){
		this.impl = impl;
	}
	@Override
	public String getId() {
		return impl.getId();
	}

	@Override
	public void sendMsg(Object msg) {
		impl.sendMsg(msg);
	}

	@Override
	public void disconnect() {
		impl.disconnect();
	}

	@Override
	public void close() {
		impl.close();
	}

}

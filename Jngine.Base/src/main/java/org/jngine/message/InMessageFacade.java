package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class InMessageFacade implements InMessage {
	
	private InMessage msg;
	
	public InMessageFacade(InMessage msg){
		this.msg = msg;
	}

	@Override
	public int getId() {
		return msg.getId();
	}

	@Override
	public int getType() {
		return msg.getType();
	}

	@Override
	public <T> T getCandy() {
		return msg.getCandy();
	}

	@Override
	public Session getSession() {
		return msg.getSession();
	}

	@Override
	public Context getContext() {
		return msg.getContext();
	}

	@Override
	public void setSession(Session session) {
		msg.setSession(session);
	}

}

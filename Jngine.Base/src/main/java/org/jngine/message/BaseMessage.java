package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class BaseMessage implements Message {
	
	protected int id;
	protected int type;
	protected Object candy;
	protected Context context;
	protected Session session;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public <T> T getCandy() {
		return (T) candy;
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public Context getContext() {
		return context;
	}
}

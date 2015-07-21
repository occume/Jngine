package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class InMessageImpl extends BaseMessage implements InMessage{
	
	private InMessageFacade facade;
	
	public InMessageImpl(Context context, Session session, int id, int type, Object msg){
		this.context = context;
		this.session = session;
		this.id = id;
		this.type = type;
		this.candy = msg;
		facade = new InMessageFacade(this);
	}
	
	public InMessage getFacade(){
		return facade;
	}
	
	public int getId(){
		return id;
	}

	public int getType(){
		return type;
	}
	
	public <T> T getCandy(){
		return (T) candy;
	}

	@Override
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public Context getContext() {
		return context;
	}
	
	public void setContext(Context context){
		this.context = context;
	}
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", candy=" + candy + "]";
	}
}

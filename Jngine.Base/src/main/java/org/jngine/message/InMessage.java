package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class InMessage extends BaseMessage implements Message{
	
	private OutMessage out;
	
	public InMessage(Session session, int id, int type, Object msg){
		this.session = session;
		this.id = id;
		this.type = type;
		this.candy = msg;
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
	
	@Override
	public Context getContext() {
		return context;
	}
	
	public OutMessage getOut(){
		return out;
	}
	
	public void setOut(OutMessage out){
		this.out = out;
	}
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", candy=" + candy + "]";
	}
}

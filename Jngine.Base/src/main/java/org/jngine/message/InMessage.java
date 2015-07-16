package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class InMessage<T> implements Message<T>{

	private int id;
	private int type;
	private T candy;
	private Context context;
	private Session session;
	
	public InMessage(int id, int type, T msg){
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
	
	public T getCandy(){
		return candy;
	}

	@Override
	public Session getSession() {
		return session;
	}
	
	@Override
	public Context getContext() {
		return context;
	}
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", candy=" + candy + "]";
	}
}

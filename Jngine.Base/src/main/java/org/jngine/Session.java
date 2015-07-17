package org.jngine;

public interface Session {

	public String getId();
	
	public void sendMsg(Object msg);
}

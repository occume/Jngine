package org.jngine.net.adapter;

public interface Sendable {

	public void send(Object msg);
	
	public void sendAndClose(Object msg);
}

package org.jngine;

public interface Server extends Lifecycle{

	public void setPort(int port);
	
	public int getPort();
	
	public void setAddress(String address);
	
	public String getAddress();
	
	public void setProtocol();
	
	public void addListener(Listener listener);
}
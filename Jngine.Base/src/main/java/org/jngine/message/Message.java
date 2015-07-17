package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public interface Message{
	
	public int getId();

	public int getType();
	
	public <T> T getCandy();
	
	public Session getSession();
	
	public Context getContext();

}

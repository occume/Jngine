package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public interface Message<T> {

	public int getType();
	
	public T getCandy();
	
	public Session getSession();
	
	public Context getContext();
}

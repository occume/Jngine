package org.jngine;

import org.jngine.message.Message;

public interface Engine extends Lifecycle{

	public <T> void dispatch(Message<T> msg);
	
	public Context getContext();
}

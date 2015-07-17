package org.jngine;

import org.jngine.message.InMessage;

public interface Engine extends Lifecycle{

	public void dispatch(InMessage msg);
	
	public Context getContext();
}

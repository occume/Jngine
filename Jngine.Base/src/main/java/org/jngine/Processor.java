package org.jngine;

import org.jngine.message.Message;

public interface Processor{
	
	public <T> void process(Message<T> msg);
}

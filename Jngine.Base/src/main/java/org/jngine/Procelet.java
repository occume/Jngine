package org.jngine;

import org.jngine.message.InMessage;
import org.jngine.message.OutMessage;

public interface Procelet{
	
	public void process(InMessage in, OutMessage out);
	
	public int getType();
}

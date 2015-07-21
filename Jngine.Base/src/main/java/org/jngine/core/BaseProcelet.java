package org.jngine.core;

import org.jngine.Procelet;
import org.jngine.message.InMessage;
import org.jngine.message.OutMessage;
import org.jngine.net.packet.PbDecoder;

public abstract class BaseProcelet implements Procelet {
	
	public BaseProcelet(){
		PbDecoder.registerMsgBean(getType(), getMsgClass());
	}

	@Override
	public void process(InMessage in, OutMessage out) {
		
	}

	public abstract int getType();

	public abstract  Class<?> getMsgClass();
}

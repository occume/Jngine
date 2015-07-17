package org.jngine.core;

import org.jngine.Processor;
import org.jngine.anno.Module;
import org.jngine.bean.Login;
import org.jngine.message.InMessage;
import org.jngine.message.OutMessage;
import org.jngine.net.packet.PbDecoder;

@Module(type = 1)
public class SimpleProcessor implements Processor{
	
	public SimpleProcessor(){
//		PbDecoder.registerExtension(1, Game.login);
		PbDecoder.registerMsgBean(1, Login.class);
	}

	@Override
	public void process(InMessage in) {
		Login login = in.getCandy();
		OutMessage out = in.getOut();
		out.setStatu(200);
		out.setReason(200);
		System.out.println(login);
		System.out.println(in.getSession());
	}
}
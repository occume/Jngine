package org.jngine.core;

import org.jngine.Processor;
import org.jngine.anno.Module;
import org.jngine.message.Message;
import org.jngine.net.packet.Game;
import org.jngine.net.packet.PbDecoder;
import org.jngine.net.packet.Game.Login;

@Module(type = 1)
public class SimpleProcessor implements Processor{
	
	public SimpleProcessor(){
		PbDecoder.registerExtension(1, Game.login);
	}

	@SuppressWarnings("hiding")
	@Override
	public <Login> void process(Message<Login> msg) {
		
		Login login = msg.getCandy();
		System.out.println(login);
	}
}
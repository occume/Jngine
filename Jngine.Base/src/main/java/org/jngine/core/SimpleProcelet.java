package org.jngine.core;

import org.jngine.Context;
import org.jngine.Session;
import org.jngine.anno.Procelet;
import org.jngine.bean.Login;
import org.jngine.message.InMessage;
import org.jngine.message.OutMessage;

@Procelet(type = 1)
public class SimpleProcelet extends  BaseProcelet{
	
	public Class<Login> getMsgClass(){
		return Login.class;
	}

	public int getType() {
		return 1;
	}

	@Override
	public void process(InMessage in, OutMessage out) {
		Login login = in.getCandy();
		
		String name = login.getName();
		Context context = in.getContext();
		boolean success = true;
		
		if(!success){
			in.getSession().close();
			return;
		}
		
		if(!context.existSession(name)){
			out.setStatu(1);
			out.setReason(1);
			context.addSession(name, in.getSession());
			System.out.println("new user");
		}
		else{
			Session oldSession = context.getSession(name);
			context.relogin(oldSession, in.getSession());
			
			in.setSession(oldSession);
			out.setStatu(1);
			out.setReason(2);
			System.out.println("duplicate user");
		}
		
		System.out.println(login);
	}
}
package org.jngine.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jngine.Context;
import org.jngine.Engine;
import org.jngine.Procelet;
import org.jngine.message.InMessage;
import org.jngine.message.OutMessage;
import org.jngine.net.adapter.Broadcaster;
import org.jngine.util.Reflection;

public class SimpleEngine extends BaseLifecycle implements Engine {
	
	private Map<Integer, Procelet> mapping;
	
	private Context context;

	@Override
	public void init() {
		context = new StandarContext();
		context.init();
		
		mapping = new HashMap<Integer, Procelet>();
		scanProcessors();
	}
	
	@Override
	public void start() {
		super.start();
		context.start();
		System.out.println("engine started, scaned " + mapping.size() + " processors");
	}

	@SuppressWarnings("rawtypes")
	private void scanProcessors(){
		Set<Class> allClasses = Reflection.getAnnoClasses(org.jngine.anno.Procelet.class);
		for(Class<?> klass: allClasses){
			
			int type = klass.getAnnotation(org.jngine.anno.Procelet.class).type();
			try {
				mapping.put(type, (Procelet)klass.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void dispatch(InMessage in) {
		
		Procelet processor = mapping.get(in.getType());
		
		if(processor == null){
			System.out.println("invalid cmd");
			return;
		}
		
		OutMessage out = new OutMessage(in);
		
		processor.process(in, out);
		
		Broadcaster.send(out);
	}

	@Override
	public Context getContext() {
		return context;
	}

}

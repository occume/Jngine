package org.jngine.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jngine.Context;
import org.jngine.Engine;
import org.jngine.Processor;
import org.jngine.anno.Module;
import org.jngine.message.Message;
import org.jngine.util.Reflection;

public class SimpleEngine extends BaseLifecycle implements Engine {
	
	private Map<Integer, Processor> mapping;
	
	private Context context;

	@Override
	public void init() {
		context = new StandarContext();
		context.init();
		
		mapping = new HashMap<Integer, Processor>();
		scanProcessors();
	}
	
	@Override
	public void start() {
		super.start();
		System.out.println("engine started, scaned " + mapping.size() + " processors");
	}

	@SuppressWarnings("rawtypes")
	private void scanProcessors(){
		Set<Class> allClasses = Reflection.getAnnoClasses(Module.class);
		for(Class<?> klass: allClasses){
			
			int type = klass.getAnnotation(Module.class).type();
			try {
				mapping.put(type, (Processor)klass.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public <T> void dispatch(Message<T> msg) {
		
		Processor processor = mapping.get(msg.getType());
		
		if(processor == null){
			System.out.println("invalid cmd");
			return;
		}
		processor.process(msg);
	}

	@Override
	public Context getContext() {
		return context;
	}

}

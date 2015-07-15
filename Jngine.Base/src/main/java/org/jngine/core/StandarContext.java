package org.jngine.core;

import java.util.Collection;

import org.jngine.Context;
import org.jngine.Manager;
import org.jngine.Session;

public class StandarContext extends BaseLifecycle implements Context {
	
	private Manager manager;
	
	

	@Override
	public void init() {
		super.init();
		manager = new StandardManager();
	}

	@Override
	public Collection<Session> getAllSessions() {
		return manager.getAllSessions();
	}

	@Override
	public Manager getManager() {
		return manager;
	}
}

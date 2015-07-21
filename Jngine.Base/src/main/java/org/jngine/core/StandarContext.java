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
		manager.init();
	}

	@Override
	public void start() {
		super.start();
		manager.start();
	}

	@Override
	public Collection<Session> getAllSessions() {
		return manager.getAllSessions();
	}

	@Override
	public Manager getManager() {
		return manager;
	}

	@Override
	public boolean existSession(String name) {
		return manager.containSession(name);
	}

	@Override
	public Session getSession(String name) {
		return manager.getSession(name);
	}

	@Override
	public void addSession(String name, Session session) {
		manager.addSession(name, session);
	}

	@Override
	public void relogin(Session oldSession, Session newSession) {
		manager.relogin(oldSession, newSession);
	}
}

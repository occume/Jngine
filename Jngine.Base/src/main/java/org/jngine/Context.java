package org.jngine;

import java.util.Collection;

public interface Context extends Lifecycle{

	public Collection<Session> getAllSessions();
	
	public Manager getManager();
	
	public boolean existSession(String name);
	
	public Session getSession(String name);
	
	public void addSession(String name, Session session);
	
	public void relogin(Session oldSession, Session newSession);
}
package org.jngine;

import java.util.Collection;

public interface Manager extends Lifecycle{

	public Collection<Session> getAllSessions();
	
	public Session createSession();
	
	public void addSession(String name, Session session);
	
	public void removeSession(Session session);
	
	public boolean containSession(String name);
	
	public Session getSession(String name);
	
	public void relogin(Session oldSesssion, Session newSession);
}

package org.jngine;

import java.util.Collection;

import org.jngine.net.adapter.ChannelSession;

public interface Manager {

	public Collection<Session> getAllSessions();
	
	public Session createSession();
	
	public void addSession(ChannelSession session);
	
	public void removeSession(Session session);
}

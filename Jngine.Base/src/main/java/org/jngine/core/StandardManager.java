package org.jngine.core;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jngine.Manager;
import org.jngine.Session;
import org.jngine.net.adapter.ChannelSession;

public class StandardManager extends BaseLifecycle implements Manager {
	
	private Map<String, Session> sessions = new ConcurrentHashMap<>();

	public Session createSession(ChannelSession session) {
		return new StandardSession(session);
	}

	@Override
	public void addSession(ChannelSession session) {
		Session ss = createSession(session);
		session.setSession(ss);
		sessions.put("", ss);
	}

	@Override
	public void removeSession(Session session) {
		
	}

	@Override
	public Collection<Session> getAllSessions() {
		return sessions.values();
	}
}

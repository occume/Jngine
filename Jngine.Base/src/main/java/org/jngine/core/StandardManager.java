package org.jngine.core;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.jngine.Manager;
import org.jngine.Session;

import com.google.common.collect.Maps;

public class StandardManager extends BaseLifecycle implements Manager {
	
	private final Map<String, Session> sessions = Maps.newConcurrentMap();
	private final Map<String, SessionImpl> impls = Maps.newConcurrentMap();
	private AtomicInteger sessionCount = new AtomicInteger();
	
	private ScheduledExecutorService executor;

	public Session createSession() {
		SessionImpl impl = new SessionImpl(this);
		impl.setId(UUID.randomUUID().toString());
		impls.put(impl.getId(), impl);
		sessionCount.incrementAndGet();
		return impl;
	}

	@Override
	public void addSession(String name, Session session) {
		sessions.put(name, session);
	}

	@Override
	public Session getSession(String name) {
		return sessions.get(name);
	}

	@Override
	public void removeSession(Session session) {
		impls.remove(session.getId());
	}

	@Override
	public Collection<Session> getAllSessions() {
		return sessions.values();
	}

	@Override
	public boolean containSession(String name) {
		return sessions.containsKey(name);
	}

	@Override
	public void relogin(Session oldSesssion, Session newSession) {
		SessionImpl old = impls.get(oldSesssion.getId());
		SessionImpl fresh = impls.get(newSession.getId());
		old.resetChannel(fresh);
		
		fresh.close();
	}

	@Override
	public void init() {
		executor = Executors.newSingleThreadScheduledExecutor();
	}

	@Override
	public void start() {
		executor.scheduleAtFixedRate(new SessionCheckTask(), 0, 2, TimeUnit.SECONDS);
	}

	private class SessionCheckTask implements Runnable{
		@Override
		public void run() {
//			System.out.println("total created: " + sessionCount.get());
//			System.out.println("sessions.size: " + sessions.size());
//			System.out.println("impls.size: " + impls.size());
		}
	}
}

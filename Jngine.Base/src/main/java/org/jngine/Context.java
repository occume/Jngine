package org.jngine;

import java.util.Collection;

public interface Context extends Lifecycle{

	public Collection<Session> getAllSessions();
	
	public Manager getManager();
}
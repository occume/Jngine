package org.jngine.message;

import org.jngine.Session;

public interface InMessage extends Message {

	public void setSession(Session session);
}

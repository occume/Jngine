package org.jngine.core;

import org.jngine.Manager;
import org.jngine.Session;
import org.jngine.message.Messages;
import org.jngine.net.adapter.ReplaceSessionable;
import org.jngine.net.adapter.Sendable;

public class SessionImpl implements Session {

	private String id;
	private Manager manager;
	private Sendable sender;
	private SessionFacade facade;
	private ReplaceSessionable handler;
	
	public SessionImpl(Manager manager){
		this.manager = manager;
		facade = new SessionFacade(this);
	}

	public Session getFacade(){
		return facade;
	}
	
	public void setReplaceSessionable(ReplaceSessionable handler){
		this.handler = handler;
	}
	
	public ReplaceSessionable getReplaceSessionable(){
		return this.handler;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}

	@Override
	public void sendMsg(Object msg) {
		sender.send(msg);
	}
	
	/**
	 * 1. close prev session
	 * 2. change sender to new
	 * 3. change session of handler to old
	 * @param newSession
	 */
	public void resetChannel(SessionImpl newSession) {
		
		sender.sendAndClose(Messages.repeatLoginOut());
		
		setSender(newSession.getSender());
		newSession.getReplaceSessionable().replaceSession(this);
	}
	
	public void setSender(Sendable sender){
		this.sender = sender;
	}
	
	public Sendable getSender(){
		return this.sender;
	}

	@Override
	public void close() {
		manager.removeSession(this);
		handler = null;
		sender = null;
	}

	@Override
	public void disconnect() {
		
	}
}
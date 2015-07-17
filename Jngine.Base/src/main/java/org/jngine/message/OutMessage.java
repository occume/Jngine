package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class OutMessage extends BaseMessage implements Message{
	
	private InMessage in;
	private int	statu;
	private int reason;
	
	public OutMessage(InMessage in){
		in.setOut(this);
		this.in = in;
	}

	@Override
	public int getId() {
		return in.getId();
	}
	
	@Override
	public int getType() {
		return in.getType();
	}

	@Override
	public Session getSession() {
		return in.getSession();
	}

	@Override
	public Context getContext() {
		return in.getContext();
	}

	@Override
	public <T> T getCandy() {
		return null;
	}
	
	public <T> void setCandy(T candy){
		this.candy = candy;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public int getReason() {
		return reason;
	}

	public void setReason(int reason) {
		this.reason = reason;
	}
	
}

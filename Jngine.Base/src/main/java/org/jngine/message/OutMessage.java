package org.jngine.message;

import org.jngine.Context;
import org.jngine.Session;

public class OutMessage<T> implements Message<T> {

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getCandy() {
		// TODO Auto-generated method stub
		return null;
	}

}

package org.jngine.core;

import java.util.ArrayList;
import java.util.List;

import org.jngine.Connector;
import org.jngine.Engine;
import org.jngine.Listener;
import org.jngine.Server;
import org.jngine.net.NettyConnector;

public class SimpleServer implements Server {
	
	private Connector connector;
	
	private Engine engine;
	
	private List<Listener> listeners;
	
	public SimpleServer(){
		init();
	}

	@Override
	public void init() {
		connector = new NettyConnector();
		engine = new SimpleEngine();
		connector.setEngine(engine);
		
		listeners = new ArrayList<>(10);
		
		connector.init();
		engine.init();
	}

	@Override
	public void start() {
		connector.start();
		engine.start();
		
		for(Listener listener: listeners){
			listener.onStart();
		}
		
		System.out.println("server started");
	}

	@Override
	public void stop() {
		
	}

	@Override
	public void setPort(int port) {
		
	}

	@Override
	public int getPort() {
		return 0;
	}

	@Override
	public void setAddress(String address) {
		
	}

	@Override
	public String getAddress() {
		return null;
	}

	@Override
	public void setProtocol() {
		
	}

	@Override
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

}

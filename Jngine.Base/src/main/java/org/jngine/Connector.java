package org.jngine;

public interface Connector extends Lifecycle{

	public void setEngine(Engine engine);
	
	public Engine getEngine();
}

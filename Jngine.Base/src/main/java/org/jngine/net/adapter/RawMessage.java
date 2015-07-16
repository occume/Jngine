package org.jngine.net.adapter;

public class RawMessage {
	
	private int id;
	private int type;
	private byte[] data;
	
	public RawMessage(int id, int type, byte[] data){
		this.id = id;
		this.type = type;
		this.data = data;
	}

	public int getId(){
		return id;
	}
	
	public int getType(){
		return type;
	}
	
	public byte[] getData(){
		return data;
	}
	
	@Override
	public String toString() {
		return "RawMessage [type=" + type + ", msg=" + data + "]";
	}
}

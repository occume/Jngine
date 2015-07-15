package org.jngine.net.adapter;

public class RawMessage {
	
	private int type;
	private byte[] data;
	
	public RawMessage(int type, byte[] data){
		this.type = type;
		this.data = data;
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

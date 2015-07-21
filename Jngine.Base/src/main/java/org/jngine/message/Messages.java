package org.jngine.message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Messages {
	
	public static ByteBuf protocolHead(int statu, int reason){
		return makeMessage(statu, reason, 0, null);
	}

	public static ByteBuf repeatLoginOut(){
		return protocolHead(0, 2);
	}
	
	public static ByteBuf makeMessage(int statu, int reason, int msgId, byte[] data){
		ByteBuf msg = Unpooled.buffer(16);
		int msgLen = 0;
		
		if(data != null && data.length > 0){
			msgLen = data.length;
		}
		
		msg .writeInt(18 + msgLen)
			.writeByte(Protocol.major()) 	// major
			.writeByte(Protocol.minor()) 	// minor
			.writeInt (msgId)  				// id
			.writeByte(statu)				// statuCode
			.writeByte(reason)				// reason
			.writeByte(1) 					// verify
			.writeInt (msgLen) 				// length
			.writeByte(0)					// backup
			;
		
		if(msgLen > 0){
			msg.writeBytes(data);			// data
		}
		
		return msg;
	}
}

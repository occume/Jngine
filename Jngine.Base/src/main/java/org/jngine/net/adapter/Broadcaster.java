package org.jngine.net.adapter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import org.jngine.message.OutMessage;

public class Broadcaster {

	public static void send(OutMessage msg){
		ByteBuf outMsg = Unpooled.buffer(12);
		outMsg .writeByte(0) // major
			.writeByte(1) // minor
			.writeInt(1)  // id
			.writeInt(msg.getStatu())
			.writeInt(msg.getReason())
			.writeByte(1) // verify
			.writeInt(0) //length
			.writeByte(1)
			;
		
		msg.getSession().sendMsg(outMsg);
	}
}
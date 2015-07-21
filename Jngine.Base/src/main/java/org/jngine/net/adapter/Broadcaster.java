package org.jngine.net.adapter;

import io.netty.buffer.ByteBuf;

import org.jngine.message.Messages;
import org.jngine.message.OutMessage;

public class Broadcaster {

	public static void send(OutMessage msg){
		int statu = msg.getStatu();
		int reason = msg.getReason();
		int msgId = msg.getId();
		byte[] data = msg.getCandy();
		
		ByteBuf outMsg = Messages.makeMessage(statu, reason, msgId, data);
		msg.getSession().sendMsg(outMsg);
	}
}
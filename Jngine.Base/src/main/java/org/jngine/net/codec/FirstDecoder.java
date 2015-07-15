package org.jngine.net.codec;

import java.util.List;

import org.jngine.net.adapter.RawMessage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class FirstDecoder extends ByteToMessageDecoder {
	
	private enum Pos{HEAD, BODY};
	
	private Pos pos = Pos.HEAD;
	
	private int len;
	private int major;
	private int minor;
	private int msgId;
	private int verify;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		
		if(pos == Pos.HEAD){
			/**
			 * check message head
			 */
			if(in.readableBytes() < 11) return;

			major 	= in.readByte();
			minor 	= in.readByte();
			msgId 	= in.readInt();
			verify 	= in.readByte();
			len 	= in.readInt();
			
			pos = Pos.BODY;
		}
		/**
		 * check message body
		 */
		else{
			if(in.readableBytes() < len) return;

			byte[] body = new byte[len];
			int type = in.readByte();
			in.readBytes(body);

			out.add(new RawMessage(type, body));
			pos = Pos.HEAD;
		}
	}
	
	public static void main(String...strings){
		ByteBuf msg = Unpooled.buffer(20);
		msg .writeByte(0)
			.writeByte(1)
			.writeInt(1)
			.writeByte(1)
			.writeInt(9)
			.writeByte(1)
			.writeBytes("message01".getBytes());
		
		ByteBuf buf = msg.slice(11, 9);
		System.out.println(buf.readByte());
		System.out.println(msg.readerIndex());
	}

}

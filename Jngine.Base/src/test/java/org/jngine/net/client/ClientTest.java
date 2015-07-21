package org.jngine.net.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import org.d3.std.Generator;
import org.d3.std.Printer;
import org.jngine.bean.Login;
import org.jngine.net.packet.Game;
import org.jngine.net.packet.PbDecoder;
import org.jngine.net.packet.Game.Packet;
import org.jngine.net.serialize.Person;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage.GeneratedExtension;
import com.google.protobuf.InvalidProtocolBufferException;

public class ClientTest {
	
	public static void send() throws InterruptedException{
		try {
			byte[] payload = getStuffPacket();
			ByteBuf msg = Unpooled.buffer(12 + payload.length);
			msg .writeByte(0) // major
				.writeByte(1) // minor
				.writeInt(1)  // id
				.writeByte(1) // verify
				.writeInt(payload.length) //length
				.writeByte(1)
				.writeBytes(payload);
			Printer.printByteArray(msg.array());
			Socket conn = new Socket("localhost", 28256);
			
			conn.getOutputStream().write(msg.array());
//			conn.getOutputStream().close();
			
			while(true){
				byte[] recvBuf = new byte[128];
				int readed = conn.getInputStream().read(recvBuf);
				if(readed == -1) break;
				handleResonse(recvBuf);
			}
			
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Thread.sleep(3000000);
	}
	
	private static void handleResonse(byte[] recvBuf){
		ByteBuf msg = Unpooled.wrappedBuffer(recvBuf);
		int tlen = msg.readInt();
		int major = msg.readByte();
		int minor = msg.readByte();
		int msgId = msg.readInt();
		int statu = msg.readByte();
		int reason = msg.readByte();
		int verify = msg.readByte();
		int len = msg.readInt();
		
		System.out.println("statu: " + statu);
		System.out.println("reason: " + reason);
		System.out.println("len: " + len);
	}
	
	public static byte[] getStuffPacket(){
		Schema<Login> schema = RuntimeSchema.getSchema(Login.class);
		
		Login login = new Login();
		login.setName("abc");
		login.setPassword("123");
		
		LinkedBuffer buffer = LinkedBuffer.allocate(1024);
		
		byte[] data = ProtobufIOUtil.toByteArray(login, schema, buffer);
		return data;
	}
	
//	public static byte[] getPacket(){
		
//		Login login = Game.Login.newBuilder()
//				.setUser("jd")
//				.setPswd("123456")
//				.build();
//		
//		Packet.Builder pktBuilder = Game.Packet.newBuilder();
//		Packet pkt = pktBuilder.setCmdId(1)
//			.setExtension(Game.login, login)
//			.build();

//		System.out.println(pkt.getExtension(Game.login));
//		return pkt.toByteArray();
//	}
	
	public static void parse() throws InvalidProtocolBufferException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		byte[] data = getPacket();
//		
//		ExtensionRegistry registry = ExtensionRegistry.newInstance();
//		registry.add(Game.login);
//		
//		Class klass = PbDecoder.class.getClassLoader().loadClass("org.jngine.net.packet.Game$Packet");
//		Method[] methods = klass.getMethods();
//		Method method = klass.getMethod("parseFrom", byte[].class, ExtensionRegistryLite.class);
////		method.invoke(obj, args)
//		Packet pkt = Packet.parseFrom(data, registry);
//		Object obj = method.invoke(klass, data, registry);
//		System.out.println(obj.getClass());
//		method = obj.getClass().getMethod("getExtension", GeneratedExtension.class);
//		System.out.println(method);
//		obj = method.invoke(obj, Game.login);
//		System.out.println(obj);
//		Login login  = pkt.getExtension(Game.login);
//		System.out.println("user: " + login.getUser());
	}	
	
	public static void main(String[] args) throws Exception {
		send();
//		getPacket();
//		parse();
	}
}

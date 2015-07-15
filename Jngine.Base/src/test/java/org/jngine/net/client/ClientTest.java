package org.jngine.net.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import org.d3.std.Generator;
import org.d3.std.Printer;
import org.jngine.net.packet.Game;
import org.jngine.net.packet.PbDecoder;
import org.jngine.net.packet.Game.Login;
import org.jngine.net.packet.Game.Packet;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage.GeneratedExtension;
import com.google.protobuf.InvalidProtocolBufferException;

public class ClientTest {
	
	public static void send() throws InterruptedException{
		try {
			byte[] payload = getPacket();
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
			
//			byte[] buf = Generator.byteArray(1024);
			conn.getOutputStream().write(msg.array());
			conn.getOutputStream().close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
	}
	
	public static byte[] getPacket(){
//		System.out.println(Game.LOGIN_FIELD_NUMBER);
//		System.out.println(Game.login);
		
		Login login = Game.Login.newBuilder()
				.setUser("jd")
				.setPswd("123456")
				.build();
		
		Packet.Builder pktBuilder = Game.Packet.newBuilder();
		Packet pkt = pktBuilder.setCmdId(1)
			.setExtension(Game.login, login)
			.build();
//		pktBuilder.
		
//		System.out.println(pkt.getExtension(Game.login));
		return pkt.toByteArray();
	}
	
	public static void parse() throws InvalidProtocolBufferException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		byte[] data = getPacket();
		
		ExtensionRegistry registry = ExtensionRegistry.newInstance();
		registry.add(Game.login);
		
		Class klass = PbDecoder.class.getClassLoader().loadClass("org.jngine.net.packet.Game$Packet");
		Method[] methods = klass.getMethods();
		Method method = klass.getMethod("parseFrom", byte[].class, ExtensionRegistryLite.class);
//		method.invoke(obj, args)
		Packet pkt = Packet.parseFrom(data, registry);
		Object obj = method.invoke(klass, data, registry);
		System.out.println(obj.getClass());
		method = obj.getClass().getMethod("getExtension", GeneratedExtension.class);
		System.out.println(method);
		obj = method.invoke(obj, Game.login);
		System.out.println(obj);
		Login login  = pkt.getExtension(Game.login);
		System.out.println("user: " + login.getUser());
	}	
	
	public static void main(String[] args) throws Exception {
		send();
//		getPacket();
//		parse();
	}
}

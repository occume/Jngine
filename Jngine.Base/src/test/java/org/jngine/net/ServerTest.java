package org.jngine.net;

import org.jngine.Listener;
import org.jngine.Server;
import org.jngine.core.SimpleServer;
import org.jngine.net.packet.PbDecoder;

public class ServerTest {

	public static void main(String[] args) {
		Server server = new SimpleServer();
		server.addListener(new ServerListener());
		server.start();
	}
	
	static class ServerListener implements Listener{
		@Override
		public void onStart() {
			System.out.println("add a listener, set super packet name");
			PbDecoder.setSuperPacketName("org.jngine.net.packet.Game$Packet");
		}
	}
}

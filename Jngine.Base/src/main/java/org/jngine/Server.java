package org.jngine;
/**
 * we implement 
 * 
 * Server server = new SimpleServer();
 * 
 * <br/>
 * 
 * because now we use Protobuf as the default mechanism of serialize message
 * before launcher the server,
 * you need to tell server the class name of your Protobuf class,
 * for instance:
 * 
 * <code>
 * server.addListener(new Listener(){
 *		@Override
 *		public void onStart() {
 *			PbDecoder.setSuperPacketName("org.jngine.net.packet.Game$Packet");
 *		}
 * });
 * </code>
 * and then, you can launcher the server:
 * 
 * server.start();
 * 
 * @author d_jin
 *
 */
public interface Server extends Lifecycle{

	public void setPort(int port);
	
	public int getPort();
	
	public void setAddress(String address);
	
	public String getAddress();
	
	public void setProtocol();
	
	public void addListener(Listener listener);
}
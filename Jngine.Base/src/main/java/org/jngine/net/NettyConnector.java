package org.jngine.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.jngine.Connector;
import org.jngine.Engine;
import org.jngine.net.codec.ClientFilter;

public class NettyConnector implements Connector {
	
	private static final int DEFAULT_PORT = 28256;
	
	private Engine engine;

	private ServerBootstrap bootstrap;
	
	private EventLoopGroup boss = new NioEventLoopGroup();
	
	private EventLoopGroup worker = new NioEventLoopGroup();
	
	private ClientFilter clientFilter = new ClientFilter(this);
	
	private int port;
	
	@Override
	public void init() {
		if(port <= 0){
			port = DEFAULT_PORT;
		}
		
		bootstrap = new ServerBootstrap();
		bootstrap
		.group(boss, worker)
		.channel(NioServerSocketChannel.class)
		.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
		.childOption(ChannelOption.TCP_NODELAY, true)
		.childHandler(getInitializer())
		;
	}
	
	private ChannelInitializer<SocketChannel> getInitializer(){
		return new ChannelInitializer<SocketChannel>(){
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(clientFilter);
			}
		};
	}

	@Override
	public void start() {
		try {
			bootstrap.bind(port).sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("connector started, port: " + port);
	}

	@Override
	public void stop() {
		
	}

	public void setPort(int port){
		this.port = port;
	}

	@Override
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public Engine getEngine() {
		return engine;
	}
}

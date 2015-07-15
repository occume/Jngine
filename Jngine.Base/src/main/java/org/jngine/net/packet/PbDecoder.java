package org.jngine.net.packet;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage.GeneratedExtension;
import com.google.protobuf.Message;

@SuppressWarnings("rawtypes")
public class PbDecoder {
	
	private static Map<Integer, ExtensionRegistry> registries = new HashMap<>();
	private static Map<Integer, GeneratedExtension<?, ?>> extensions = new HashMap<>();
	private static String superPacketName;
	private static Class superPacketClass;
	private static Method parseFrom;
	private static Method getExtension;
	
	public static void setSuperPacketName(String name){
		superPacketName = name;
	}
	
	public static <T> void registerExtension(int type, GeneratedExtension<?, T> extension){
		ExtensionRegistry registry = ExtensionRegistry.newInstance();
		registry.add(extension);
		registries.put(type, registry);
		extensions.put(type, extension);
	}

	@SuppressWarnings({ "unchecked"})
	public static <D extends Message, T> T parse(int type, byte[] data){
		
		ExtensionRegistry registry = registries.get(type);
		GeneratedExtension<D , T> extension = (GeneratedExtension<D, T>) extensions.get(type);
		
		T ret = null;
		
		try {
			if(superPacketClass == null){
				superPacketClass = PbDecoder.class.getClassLoader().loadClass(superPacketName);
				parseFrom = superPacketClass.getMethod("parseFrom", byte[].class, ExtensionRegistryLite.class);
			}
			
			Object obj = parseFrom.invoke(superPacketClass, data, registry);
			
			if(getExtension == null){
				getExtension = obj.getClass().getMethod("getExtension", GeneratedExtension.class);
			}
			ret = (T) getExtension.invoke(obj, extension);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (T) ret;
	}
	
}

package org.jngine.message;

/**
 * explanation of protocol 1.0
 * 
 *  an integrity message must contain a head, like as:
 *  
 *  byte major
 *  byte manor
 *  int  msgId
 *  byte 
 * 
 * 
 * 
 * @author d_jin
 *
 */
public class Protocol {

	private static int major = 1;
	private static int minor = 0;
	
	public static int major(){
		return major;
	}
	
	public static int minor(){
		return minor;
	}
}

package org.jngine.util;

import java.util.Date;

public class Stat {
	
	private Date serverStartDate;

	private static class Holder{ 
		static Stat stat = new Stat();
	}
	
	private Stat(){}
	
	public static Stat instance(){
		return Holder.stat;
	}

	public Date getServerStartDate() {
		return serverStartDate;
	}

	public void setServerStartDate(Date serverStartDate) {
		this.serverStartDate = serverStartDate;
	}
}
package util;

import java.util.Date;

public class MyCl {

		
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
		public MyCl(String name, Date date) {
			this.name = name;
			this.date =date;
		}
		private String name;
		private Date date;
		
		
	
	
}

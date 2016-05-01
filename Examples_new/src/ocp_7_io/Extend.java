package ocp_7_io;

import java.io.Serializable;


public class Extend extends Base implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5742161504144207959L;
	private String name ="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private static String statParam ="";
	public static String getStatParam() {
		return statParam;
	}
	public static void setStatParam(String statParam) {
		Extend.statParam = statParam;
	}
	
	
}

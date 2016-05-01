package ocp_exam.io_cap7;

import java.io.Serializable;

public class Ser implements Serializable {

	private String a="a";
	private transient String b="b";
	private static transient String c="b";
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public static String getC() {
		return c;
	}
	public static void setC(String c) {
		Ser.c = c;
	}
}

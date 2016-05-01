package string.format;


public class StringFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String par1 ="par1";
		String par2 ="par2";
		//%n newline platform independent
		// \n valid only on unix systems
		// http://stackoverflow.com/questions/1883345/whats-up-with-javas-n-in-printf
		//By using %n in your format string, you tell Java to use the value returned by System.getProperty("line.separator"), which is the line separator for the current system.
		
		System.out.println(String.format("FAILED sending mml Command: %s%nCause: %s", par1, par2));
		
		System.out.println("platform separator:"+System.getProperty("line.separator"));
		

	}

}

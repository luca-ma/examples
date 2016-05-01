package start;

public class StartC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hook hook = new Hook();
	    System.out.println( "Running Main Application..." );
	    Runtime.getRuntime().addShutdownHook( hook );
	    System.out.println( "Exiting." );

	}
	
	private static class Hook extends Thread {
	    public void run() {
	      System.out.println( "Running Clean Up..." );
	    }
	}

}

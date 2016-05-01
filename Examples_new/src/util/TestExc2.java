package util;

public class TestExc2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
		
		Integer.valueOf("pippo");
		}  catch(Exception e) {
         System.out.println("Errore nella esecuzione dei comandi ");
         throw e;
		}finally{
			 System.out.println("Finally  nella esecuzione dei comandi ");
		       
			int ee =0;
	
}


		
	}

}

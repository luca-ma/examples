package exceptions;

public class TestCheckUncheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassExceptions clInst = new ClassExceptions();
		
		clInst.uncheckExc(1);
		clInst.uncheckExc2(1);
		
		try { //you must catch or propagate exception
			clInst.checkExc(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

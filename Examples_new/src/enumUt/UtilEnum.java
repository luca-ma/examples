package enumUt;

public class UtilEnum {
	
	public static enum OPERATION_RESULT{
		UNK,		//not specified
		OK, 				//t2t process correctly terminated;
			//t2t process NOT correctly terminated
		KO_SESSION_BROKEN,  	//SESSION NOT OPENED
		KO_SEND_FILE_ABORT,		//sendFile() method aborted
		KO_FILE_TRANSFER_ABORT	//File transfer failed
	}
	
	public static OPERATION_RESULT opRes = OPERATION_RESULT.OK;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		if(opRes.equals(OPERATION_RESULT.OK)) {
			System.out.println("ok equals");
		}
		
		if(opRes== OPERATION_RESULT.OK) {
			System.out.println("ok ==");
		}

		OPERATION_RESULT[] values = OPERATION_RESULT.values();
	}

}

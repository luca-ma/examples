package exceptions;

/**
 * 
 * @author 
 * example class with two methods that 
 * throws an Exception subclass (checked)
 * and
 *
 */
public class ClassExceptions  {

	/**
	 * method throw a runtimeExc (unckecked)
	 */
	public void uncheckExc (Integer param) {
		if(param.equals(0)) {
			throw  new NumberFormatException();
		}
	}
	/**
	 * method throw a runtimeExc (unckecked)
	 * it's not necessary throws NumberFormatException
	 */
	public void uncheckExc2 (Integer param)throws  NumberFormatException{
		if(param.equals(0)) {
			throw  new NumberFormatException();
		}
	}
	 /** method throw a Exc (ckecked)--> you must throws Exception
	 * @throws Exception 
	 */
	public void checkExc (Integer param) throws Exception{
		if(param.equals(0)) {
			throw  new Exception();
		}
	}
}

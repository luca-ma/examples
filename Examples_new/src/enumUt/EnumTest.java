package enumUt;

import java.io.Serializable;
 /**
  * test java num1 Ulixe
  * @author luca
  *
  */
public enum EnumTest implements Serializable, Runnable {
	Elemento1, Elemento2;

	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Esecuzione nell’enumerazione");
 	}

 	public static void main(String[] args) {
		new Thread(EnumTest.Elemento2).start();
 	}
 
}

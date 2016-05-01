package test.ulixe;
import java.io.Serializable;
 /**
  * test java num1 Ulixe
  * @author luca
  *Spuntare le affermazioni corrette:
A.	Errore alla riga 03, un’enumerazione non può implementare un ’interfaccia
B.	Errore di compilazione alla riga 17, metodo main dichiarato all’interno di una enumerazione
C.	Errore di compilazione alla riga 18
D.	Il codice compila correttamente


risposta corretta D

-> enum può implementare interfacce 
http://stackoverflow.com/questions/2709593/why-would-an-enum-implement-an-interface
-->enum può avere metodo main 
http://www.xyzws.com/Javafaq/what-can-or-can-not-for-the-java-enum-type-when-you-use-it/136
-->la riga 18 compila correttamente

-.> il programma funziona correttamente

  *
  */
public enum EnumTest implements Serializable, Runnable { //03
	Elemento1, Elemento2;

	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Esecuzione nell’enumerazione");
 	}

 	public static void main(String[] args) {//17
		new Thread(EnumTest.Elemento2).start();//18
 	}
 
}
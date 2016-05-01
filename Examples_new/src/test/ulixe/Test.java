package test.ulixe;

/**
 * test java num2 Ulixe
 * @author luca
 * 
 * Spuntare le affermazioni corrette:
A.	Il codice compila ed esegue correttamente
B.	Il codice genera un errore in fase di compilazione
C.	Il codice lancia un’eccezione di tipo NullPointerException
D.	Il codice lancia un’eccezione di tipo ExceptionInInitializerError

risposta esatta C

-  il codice compila correttamente ma lancia una null pointer
per far funzionare correttamente inizializzare l'array con new  int[1]
 * 
 */

public class Test {
	static int[] i;// = new  int[1];

	static { i[0]=11; }
	public static void main(String[] args) { 
	
		
		
	/* codice */ }
}

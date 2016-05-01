package test.ulixe;

/**
 * java ulixe test num 5
 * 
 * I frammenti di codice che, inseriti alla riga 13, consentono di rendere compilabile il frammento di codice sopra riportato
A.	public int compare(Complesso nc1, Complesso nc2) { //codice }
B.	public int compareTo(Object o) { //codice }
C.	public int compareTo(Complesso nc) { //codice }
D.	public int compare(Objet o1, Object o2) { //logic here }

risposta esatta C
 * @author luca
 *
 */

public class Complesso implements Comparable<Complesso> {
	private int reale, immaginaria;

	public Complesso (int r, int i) {
		reale = r;
		immaginaria = i;
	}
	public void sommaNumero(Complesso nc) {
		this.reale += nc.reale;
		this.immaginaria += nc.immaginaria;
	}
	// SEGNAPOSTO 13
	@Override
	public int compareTo(Complesso arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

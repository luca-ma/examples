package ocp_11_exam.concurrency.structures.semaphore;

import java.util.concurrent.Semaphore;

public class ATMRoom {
	public static void main(String []args) {
		// assume that only two ATM machines are available in the ATM room
		Semaphore machines = new Semaphore(2);
		// list of people waiting to access the machine
		new Person(machines, "Mickey");
		new Person(machines, "Donald");
		new Person(machines, "Tom");
		new Person(machines, "Jerry");
		new Person(machines, "Casper");
		}
		
}

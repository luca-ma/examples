package ocp_11_exam.concurrency;

class Order implements Runnable {
	String name;
	Order(String name) {this.name = name;}
	public void run() {
		System.out.println(name);
	}
}


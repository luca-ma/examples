package ocp_exam.concurrency_cap11;

class Order implements Runnable {
	String name;
	Order(String name) {this.name = name;}
	public void run() {
		System.out.println(name);
	}
}


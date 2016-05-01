package ocp_exam.threads_cap10;

public class Bees {
public static void main(String[] args) {
try {
new Bees().go();
} catch (Exception e ) {
	e.printStackTrace();
System.out.println("thrown to main");
}
}
synchronized void go() throws InterruptedException {
Thread t1 = new Thread();
t1.start();
System.out.print("1 ");
t1.wait(5000);
System.out.print("2 ");
}
}

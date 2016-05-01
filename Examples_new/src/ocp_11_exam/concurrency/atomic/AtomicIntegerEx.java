package ocp_11_exam.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {

	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger();
		ai.incrementAndGet();
		

	}

}

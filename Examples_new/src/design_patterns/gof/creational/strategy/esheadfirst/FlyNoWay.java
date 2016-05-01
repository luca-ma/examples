package design_patterns.gof.creational.strategy.esheadfirst;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}


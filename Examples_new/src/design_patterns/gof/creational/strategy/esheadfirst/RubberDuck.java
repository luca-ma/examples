package design_patterns.gof.creational.strategy.esheadfirst;

public class RubberDuck extends Duck {
	 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
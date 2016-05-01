package design_patterns.gof.creational.strategy.esheadfirst;

public class DuckTest{
	 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		RubberDuck	rubberDuckie = new RubberDuck();
		//DecoyDuck	decoy = new DecoyDuck();
 
		//ModelDuck	model = new ModelDuck();

		mallard.performQuack();
		mallard.performFly();
		mallard.swim();
		mallard.display();
		
		rubberDuckie.performQuack();
		rubberDuckie.performFly();
		rubberDuckie.swim();
		rubberDuckie.display();
		
	}
}


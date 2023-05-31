package riccardogulin.u5d3.entities.toppings;

import riccardogulin.u5d3.entities.Consummation;

public class OnionTopping extends ToppingDecorator {

	public OnionTopping(Consummation c) {
		super(c);
		this.name = "Cipolla";
		this.price = 1.00;
		this.calories = 100;
	}
}

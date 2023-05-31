package riccardogulin.u5d3.entities.drinks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import riccardogulin.u5d3.entities.Consummation;

@AllArgsConstructor
@Getter
@Setter
public abstract class Drink extends Consummation {
	double size;

	public String toString() {
		return this.getName() + " " + this.getSize() + ", prezzo: " + this.getPrice() + "€, calorie:"
				+ this.getCalories();
	}
}

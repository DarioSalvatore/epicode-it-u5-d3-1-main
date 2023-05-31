package riccardogulin.u5d3.entities.merchandise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import riccardogulin.u5d3.entities.Product;

@Getter
@Setter
@AllArgsConstructor
public class Gadget extends Product {
	String type;
}

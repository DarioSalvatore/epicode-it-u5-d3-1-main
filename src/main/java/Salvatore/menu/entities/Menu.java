package Salvatore.menu.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class Menu {
	private List<Product> menuEntries = new ArrayList<>();

	public void print() {
		log.info("******************* MENU ****************");
		this.menuEntries.forEach(prod -> log.info(prod.toString()));
	}
}

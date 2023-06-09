package Salvatore.menu.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Salvatore.menu.entities.Consummation;
import Salvatore.menu.entities.Menu;
import Salvatore.menu.entities.Ordine;
import Salvatore.menu.entities.Tavolo;
import Salvatore.menu.entities.drinks.Coke;
import Salvatore.menu.entities.drinks.Lemonade;
import Salvatore.menu.entities.pizzas.Pizza;
import Salvatore.menu.entities.toppings.HamTopping;
import Salvatore.menu.entities.toppings.OnionTopping;

@Configuration
public class MenuConfig {
	@Bean
	Menu getMenu() {
		Menu menu = new Menu();

		menu.getMenuEntries().add(getMargherita());
		menu.getMenuEntries().add(getPizzaProsciutto());
		menu.getMenuEntries().add(getPizzaCipolla());
		menu.getMenuEntries().add(getPizzaProsciuttoCipolla());
		menu.getMenuEntries().add(getCoke());
		menu.getMenuEntries().add(getLemonade());

		return menu;
	}

	@Bean
	Consummation getMargherita() {
		return new Pizza();
	}

	@Bean
	Consummation getPizzaProsciutto() {
		return new HamTopping(new Pizza());
	}

	@Bean
	Consummation getPizzaCipolla() {
		return new OnionTopping(new Pizza());
	}

	@Bean
	Consummation getPizzaProsciuttoCipolla() {
		return new HamTopping(new OnionTopping(new Pizza()));
	}

	@Bean
	Consummation getCoke() {
		return new Coke(0.5);
	}

	@Bean
	Consummation getLemonade() {
		return new Lemonade(0.5);
	}

	@Bean
	@Scope("prototype")
	public Ordine ordine() {
		return new Ordine();
	}

	@Bean
	@Scope("prototype")
	public Tavolo tavolo(Integer numero, Integer postiAsedere, Boolean tavoloLibero) {
		return new Tavolo(numero, postiAsedere, tavoloLibero);
	}

}

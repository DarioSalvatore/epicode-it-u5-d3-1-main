package Salvatore.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import Salvatore.menu.entities.Consummation;
import Salvatore.menu.entities.Menu;
import Salvatore.menu.entities.Ordine;
import Salvatore.menu.entities.Product;
import Salvatore.menu.entities.Tavolo;
import Salvatore.menu.entities.drinks.Coke;
import Salvatore.menu.entities.drinks.Drink;
import Salvatore.menu.entities.drinks.Lemonade;
import Salvatore.menu.entities.pizzas.Pizza;
import Salvatore.menu.entities.toppings.HamTopping;
import Salvatore.menu.entities.toppings.OnionTopping;

@Component
public class MenuRunner implements CommandLineRunner {

	@Autowired
	private AnnotationConfigApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		Menu menu = ctx.getBean(Menu.class);
		Tavolo tavolo = new Tavolo(1, 5, false);
		double costoCoperto = 2;
		Ordine ordine = creaOrdine(tavolo, 3, costoCoperto);
		valorizzaOrdine(ordine);
		stampaOrdine(ordine);

		menu.print();

		ctx.close();

	}

	public Ordine creaOrdine(Tavolo tavolo, Integer numeroCoperti, Double costoCoperto) {
		Ordine ordine = ctx.getBean(Ordine.class);
		ordine.setTavolo(tavolo);
		ordine.setNumeroCoperti(numeroCoperti);
		ordine.setNumeroOrdine(1);
		ordine.setCostoCoperto(costoCoperto);
		return ordine;
	}

	public void stampaOrdine(Ordine ordine) {
		System.out.println("** ORDINE **");
		System.out.println("Numero ordine: " + ordine.getNumeroOrdine());
		System.out.println("Numero coperti: " + ordine.getNumeroCoperti());
		System.out.println("Numero Tavolo: " + ordine.getTavolo().getNumero());
		System.out.println("Stato ordine: " + ordine.getStato());
		System.out.println();
		for (Product item : ordine.getComanda().keySet()) {
			System.out.println(item.getName() + " - Quantità: " + ordine.getComanda().get(item));
		}
		System.out.println();
		System.out.println("Totale €: " + ordine.getTotale());
	}

	private void valorizzaOrdine(Ordine ordine) {
		for (int i = 0; i < 3; i++) {
			Pizza pizza = ctx.getBean(Pizza.class);
			ordine.aggiungiProdotto(pizza);
		}

		Consummation pizza = ctx.getBean(Pizza.class);
		pizza = new HamTopping(pizza);
		ordine.aggiungiProdotto(pizza);

		pizza = ctx.getBean(Pizza.class);
		pizza = new OnionTopping(pizza);
		ordine.aggiungiProdotto(pizza);

		pizza = ctx.getBean(Pizza.class);
		pizza = new HamTopping(new OnionTopping(pizza));
		ordine.aggiungiProdotto(pizza);

		Drink drink = ctx.getBean(Coke.class);
		ordine.aggiungiProdotto(drink);

		drink = ctx.getBean(Lemonade.class);
		ordine.aggiungiProdotto(drink);
	}

}

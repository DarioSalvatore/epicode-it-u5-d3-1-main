package Salvatore.menu.entities;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ordine {

	private int numeroOrdine;
	private Tavolo tavolo;
	private Map<Product, Integer> comanda = new HashMap<>();
	private StatoOrdine stato = StatoOrdine.INCORSO;

	private int numeroCoperti = 1;
	private double costoCoperto;
//	private double conto;

	public Integer aggiungiProdotto(Product p) {
		if (!comanda.containsKey(p)) {
			comanda.put(p, 1);
		} else {
			comanda.put(p, comanda.get(p) + 1);
		}
		return comanda.get(p);
	}

	public Integer remuoviProdotto(Product p) {
		if (comanda.containsKey(p)) {
			int currentNumber = comanda.get(p);
			if (currentNumber == 1) {
				comanda.remove(p);
				return 0;

			} else {
				comanda.put(p, comanda.get(p) - 1);
				return comanda.get(p);
			}
		} else
			return 0;

	}

	public double getTotale() {
		double totale = 0;
		for (Product p : comanda.keySet()) {
			totale += (p.getPrice() * comanda.get(p));
		}
		totale += numeroCoperti + getCostoCoperto();
		return totale;
	}
}

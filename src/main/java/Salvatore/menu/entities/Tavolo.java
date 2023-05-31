package Salvatore.menu.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Tavolo {

	private int numero;
	private int postiAsedere;
	private boolean tavoloLibero = true;

	public boolean getTavoloLibero() {
		return tavoloLibero;
	}

	public void setTavoloLibero(boolean tavoloLibero) {
		this.tavoloLibero = tavoloLibero;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getPostiAsedere() {
		return postiAsedere;
	}
}

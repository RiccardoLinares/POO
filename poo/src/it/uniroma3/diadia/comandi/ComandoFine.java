package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	/**
	 * esecuzione del comando.
	 */

	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}

	public void setParametro(String parametro) {	
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "fine";
	}
	
}

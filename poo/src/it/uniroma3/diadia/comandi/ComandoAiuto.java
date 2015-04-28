package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private static String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "guarda", "fine"};

	/**
	 * esecuzione del comando.
	 */
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	public void setParametro(String parametro) {		
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "aiuto";
	}
	
}

package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella il comando aiuto
 * che permette di conoscere le azioni che il giocatore può compiere
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 * @see Comando, Partita
 */
public class ComandoAiuto implements Comando {
	
	private static String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "guarda", "fine"};

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	@Override
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

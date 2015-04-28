package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa interfaccia modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * 
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 */

public interface Comando{
	/**
	 * Il comando da eseguire
	 * @param partita
	 */
	public void esegui(Partita partita);
	
	/**
	 * Il parametro del comando
	 * @param parametro
	 */
	public void setParametro(String parametro);
	
	/**
	 * Restituisce il parametro del comando
	 * @return parametro
	 */
	public String getParametro();
	
	/**
	 * Restituisce il nome del comando
	 * @return nome del comando
	 */
	public String getNome();
}

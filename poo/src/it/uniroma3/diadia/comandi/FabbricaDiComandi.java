package it.uniroma3.diadia.comandi;

/**
 * Questa interfaccia modella una fabbrica di comandi
 * che permette di costruire i comandi che il giocatore vuole eseguire
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 * @see Comando
 */
public interface FabbricaDiComandi {
	/**
	 * Costruisce il comando da eseguire
	 * @param istruzione
	 * 		l'istruzione da eseguire
	 * @return Comando, il comando da eseguire
	 */
	public Comando costruisciComando(String istruzione);
} 
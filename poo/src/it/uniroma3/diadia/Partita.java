package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares  e la collaborazione di Mauro Iemboli)
 * @see Labirinto, Giocatore
 * @version 0.2
 */

public class Partita {
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	/**
	 * Inizializza il labirinto e il giocatore
	 */
	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.finita = false;
	}    

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || !this.giocatoreIsVivo();
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Restituisce il labirinto in cui si trova il giocatore.
	 * @return il labirinto
	 */
	public Labirinto getLabirinto(){
		return this.labirinto;
	}
	
	/**
	 * Modifica il labirinto in cui si trova il giocatore.
	 * @param labirinto il nuovo labirinto
	 */
	public void setLabirinto(Labirinto labirinto){
		this.labirinto = labirinto;
	}

	/**
	 * Restituisce il giocatore della partita.
	 * @return il giocatore
	 */
	public Giocatore getGiocatore(){
		return this.giocatore;
	}

	/**
	 * Modifica il giocatore della partita in corso.
	 * @param giocatore il nuovo giocatore della partita
	 */
	public void setGiocatore(Giocatore giocatore){
		this.giocatore = giocatore;
	}


	public boolean giocatoreIsVivo() {
		boolean verificato = true;
		if(this.getGiocatore().getCfu() < 0){
			verificato = false;
		}
		return verificato;
	}
}

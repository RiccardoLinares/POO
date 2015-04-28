package it.uniroma3.diadia.giocatore;


/**
 * Classe che gestisce il Giocatore e i suoi cfu
 * @author Riccardo Linares, Mauro Iemboli
 * @version 0.3
 * @see Borsa
 */
public class Giocatore {

	private int cfu;
	private static int CFU_INIZIALI = 20;
	private Borsa borsa;
	
	public Giocatore(){
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/**
	 * Restituisce i cfu del giocatore.
	 * @return i cfu del giocatore
	 */
	public int getCfu() {
		return this.cfu;
	}

	/**
	 * Modifica i cfu del giocatore
	 * @param cfu inserire i cfu del giocatore
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	/**
	 * Restituisce la borsa del giocatore.
	 * @return la borsa del giocatore
	 */
	public Borsa getBorsa(){
		return this.borsa;
	}
	
	/**
	 * Modifica la borsa del giocatore
	 * @param borsa la borsa del giocatore
	 */
	public void setBorsa(Borsa borsa){
		this.borsa = borsa;
	}
}

package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe che gestisce la borsa del giocatore.
 * Una borsa ha un peso massimo.
 * Il peso varia in base al numero di oggetti all'interno della borsa.
 * È possibile aggiungere o rimuove gli oggetti nella borsa.
 * 
 * @author Riccardo Linares, con la collaborazione di Mauro Iemboli
 *
 */
public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	/**
	 * La borsa del giocatore con peso di default.
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	/**
	 * La borsa del giocatore
	 * @param pesoMax
	 * 		il peso massimo della borsa del giocatore
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	/**
	 * Aggiunge un attrezzo all'interno della borsa del giocatore.
	 * @param attrezzo
	 * @return true se l'attrezzo è stato aggiunto, false se l'attrezzo non è stato aggiunto
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Restituisce il peso della borsa.
	 * @return peso della borsa
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Restituisce un attrezzo cercato.
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return l'attrezzo cercato
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	
	/**
	 * Restituisce il peso della borsa.
	 * @return il peso della borsa
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	/**
	 * Controlla se la borsa è vuota.
	 * @return true se la borsa è vuota, false se è presente qualche attrezzo all'interno
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Controlla se l'attezzo è presente nella borsa.
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return true se l'attrezzo è presente, false se l'attrezzo non è nella borsa
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Rimuove un attrezzo presente nella borsa.
	 * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
	 * @return l'attrezzo rimosso 
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
	
		if(hasAttrezzo(nomeAttrezzo)){
			for(int i=0; i<this.numeroAttrezzi; i++){
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)){
					a = this.attrezzi[i];
					this.attrezzi[i] = null;
				}
			}
		}
		sortAttrezzi();
		return a;
	}
	
	/**
	 * Riordina gli attrezzi nella borsa del giocatore.
	 */
	public void sortAttrezzi(){
		int j = 0;
		for(int i=0; i<this.numeroAttrezzi; i++){
			Attrezzo attrezzo = attrezzi[i];
			if(attrezzo != null){
				attrezzi[j] = attrezzo;
				j++;
			}
		}
		this.numeroAttrezzi = j;
	}
	
	/**
	 * Restituisce una descrizione letterale della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		for (int i= 0; i<this.numeroAttrezzi; i++)
			s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
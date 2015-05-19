package it.uniroma3.diadia.giocatore;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

/**
 * Classe che gestisce la borsa del giocatore.
 * Una borsa ha un peso massimo.
 * Il peso varia in base al numero di oggetti all'interno della borsa.
 * È possibile aggiungere o rimuove gli oggetti nella borsa.
 * 
 * @author Riccardo Linares, Mauro Iemboli
 * @version 0.3
 */
public class Borsa{
	private Map<String, Attrezzo> attrezzi ;
	private int pesoMax;
	public final static int DEFAULT_PESO_MAX = 10;

	/**
	 * La borsa del giocatore
	 */
	public Borsa() {
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.pesoMax = DEFAULT_PESO_MAX;
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
	}


	/**
	 * Aggiunge un attrezzo all'interno della borsa del giocatore.
	 * @param attrezzo
	 * @return true se l'attrezzo è stato aggiunto, false se l'attrezzo non è stato aggiunto
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) { 
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax() || this.attrezzi.containsKey(attrezzo)){ 
			return false; 
		}
		else{
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}

	}  

	/**
	 * Restituisce la massima capacità della borsa
	 * @return pesoMax
	 */
	public int getPesoMax(){
		return this.pesoMax;
	}

	/**
	 * Restituisce il peso della borsa.
	 * @return peso della borsa
	 */
	public int getPeso() {
		int pesoTotale = 0;
		Iterator<Attrezzo> iteratore =this.attrezzi.values().iterator();
		while (iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			pesoTotale += a.getPeso();
		}
		return pesoTotale;
	}

	/**
	 * Restituisce un attrezzo cercato.
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return l'attrezzo cercato
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =this.attrezzi.values().iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}


	/**
	 * Controlla se la borsa è vuota.
	 * @return true se la borsa è vuota, false se è presente qualche attrezzo all'interno
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/**
	 * Controlla se l'attezzo è presente nella borsa.
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return true se l'attrezzo è presente, false se l'attrezzo non è nella borsa
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = this.getAttrezzo(nomeAttrezzo);
		return this.attrezzi.values().contains(attrezzo);
	}

	/**
	 * Rimuove un attrezzo presente nella borsa.
	 * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
	 * @return attrezzo, l'attrezzo rimosso 
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) { 
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =this.attrezzi.values().iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
	}

	
	/**
	 * Restituisce una stringa che descrive il contenuto della borsa
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for(Attrezzo attrezzo: this.attrezzi.values())
				s.append(attrezzo.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	

	/**
	 * Restituisce una lista che ha gli attrezzi ordinati per peso
	 * @return attrezziOrdinatiPerPeso
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziPerPeso = new ArrayList<>();
		attrezziPerPeso.addAll(this.attrezzi.values());
		ComparatorePerPeso comp = new ComparatorePerPeso();
		Collections.sort(attrezziPerPeso, comp);
		return attrezziPerPeso;
	}
	
	/**
	 * Restituisce una lista che ha gli attrezzi ordinati per nome
	 * @return attrezziOrdinatiPerNome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerNome() {
		List<Attrezzo> attrezziPerNome = new ArrayList<>();
		attrezziPerNome.addAll(this.attrezzi.values());
		Collections.sort(attrezziPerNome);
		return attrezziPerNome;
	}
	
	/**
	 * Restituisce una mappa che ha gli attrezzi
	 * raggruppati per peso
	 * @return contenutoRaggruppatoPerPeso
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		
		Set<Attrezzo> tmp;
		Map<Integer, Set<Attrezzo>> ContenutoRaggruppatoPerPeso = new HashMap<Integer, Set<Attrezzo>>();
		for(Attrezzo attrezzo: this.attrezzi.values()) {
			if(ContenutoRaggruppatoPerPeso.containsKey(attrezzo.getPeso())) {
				tmp = ContenutoRaggruppatoPerPeso.get(attrezzo.getPeso());
				tmp.add(attrezzo);
			}
			else {
				tmp = new HashSet<>();
				tmp.add(attrezzo);
				ContenutoRaggruppatoPerPeso.put(attrezzo.getPeso(), tmp);
			}
		}
		return ContenutoRaggruppatoPerPeso;
	}
	
	public String ContenutoOrdinatoPerNomeToString() {
		return this.getContenutoOrdinatoPerNome().toString();
	}
	
	public String ContenutoOrdinatoPerPesoToString() {
		return this.getContenutoOrdinatoPerPeso().toString();
	}
	
	public String ContenutoRaggruppatoPerPesoToString() {
		return this.getContenutoRaggruppatoPerPeso().toString();
	}

}
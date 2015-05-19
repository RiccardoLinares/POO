package it.uniroma3.diadia.ambienti;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @see Attrezzo
 * @version 0.3
 */

public class Stanza {

	private String descrizione;
	protected Map<String, Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param descrizione il nome della stanza
	 */
	public Stanza(String descrizione){
		this.descrizione = descrizione;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<String, Attrezzo>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione,Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione,stanzaAdiacente);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.descrizione;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return 
	 * @return 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}

	/**
	 * Aggiunge un attrezzo alla stanza.
	 * 
	 * @param attrezzo
	 * 		l'attrezzo da aggiungere
	 * @return false se l'attrezzo non viene aggiunto, true altrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		final String ATTREZZO_GIA_PRESENTE = "L'attrezzo è già presente nella stanza";
		if(this.attrezzi.containsKey(attrezzo.getNome())) {
			System.out.println(ATTREZZO_GIA_PRESENTE);
			return false;
		}
		else {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return stringa la descrizione su stringa
	 */
	@Override
	public String toString() {
		String s = new String();
		s += this.getNome();
		s += "\nUscite:";
		Iterator<String> iteratore = this.stanzeAdiacenti.keySet().iterator();
		while(iteratore.hasNext()){		
				s += " " + iteratore.next();
		}
		s += "\nAttrezzi nella stanza: ";
		Iterator<Attrezzo> iteratore2 = this.attrezzi.values().iterator();
		while(iteratore2.hasNext()){
			s += iteratore2.next().toString()+" ";
		}

		return s;
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @param nomeAttrezzo attrezzo da verificare
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	
	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo attrezzo da ottenere
	 * @return l'attrezzo presente nella stanza, null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		this.attrezzi.remove(nomeAttrezzo);
		if(!this.attrezzi.containsKey(nomeAttrezzo)){
			return true;
		}
		return false;
	}


	/**
	 * Restituisce le direzioni in cui possibile muoversi.
	 * @return le direzioni delle stanze
	 */
	public ArrayList<String> getDirezioni() {
		ArrayList<String> direzioni = null;
		Iterator<String> i = this.stanzeAdiacenti.keySet().iterator();
	    while(i.hasNext())
	    	direzioni.add(i.next());
	    return direzioni;
	}

	/**
	 * Restituisce il numero delle stanze adiacenti
	 * @return int numeroStanzeAdiacenti, il numero delle stanze adiacenti
	 */
	public int getNumeroStanzeAdiacenti() {
		return this.stanzeAdiacenti.size();
	}

	/**
	 * Restituisce una lista contenente le stanze adiacenti
	 * @return stanzeAdiacenti, le stanze adiacenti.
	 */
	public ArrayList<Stanza> getStanzeAdiacenti() {
		ArrayList<Stanza> direzioni = null;
		Iterator<Stanza> i = this.stanzeAdiacenti.values().iterator();
	   	while(i.hasNext())
	    	direzioni.add(i.next());
	    return direzioni;
	}

	/**
	 * Modifica le stanze adiacenti
	 * @param stanzeAdiacenti
	 * 		le stanze adiacenti.
	 */
	public void setStanzeAdiacenti(Map<String, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}
}
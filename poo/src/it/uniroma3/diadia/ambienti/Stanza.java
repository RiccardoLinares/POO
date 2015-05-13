package it.uniroma3.diadia.ambienti;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;




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
	protected List<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param descrizione il nome della stanza
	 */
	public Stanza(String descrizione){
		this.descrizione = descrizione;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new ArrayList<>();
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
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return 
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return attrezzi.add(attrezzo);
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/   
    public String toString(){
    	String s = new String();
    	s += this.descrizione;
    	s += "\nUscite: ";
    	for (String stanza : this.stanzeAdiacenti.keySet()){
    		if(stanza != null)
    			s += " " + stanza;
    	}
    	s += "\nAttrezzi nella stanza: ";
    	Iterator<Attrezzo> i = this.attrezzi.iterator();
    	while(i.hasNext()){
    			s += i.next().getNome() + " ";
    	}    	
    	return s;
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		while(i.hasNext()) {
				if (i.next().getNome().equals(nomeAttrezzo))
					trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		while(i.hasNext()) {
				if (i.next().getNome().equals(nomeAttrezzo))
					return i.next();
		}
		return null;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {	 
		for(Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo.getNome().equals(nomeAttrezzo)){
				return this.attrezzi.remove(attrezzo);
			}
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
	 * Modifica l'array delle stanze adiacenti
	 * @param stanzeAdiacenti
	 * 		le stanze adiacenti.
	 */
	public void setStanzeAdiacenti(Map<String, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

}
package it.uniroma3.diadia.ambienti;

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
	private static final int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;
	private String nome;
    protected Attrezzo[] attrezzi; //TODO controlla se lasciare PROTECTED o meno!!!
    protected int numeroAttrezzi; //TODO controlla 
    private Stanza[] stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
	private String[] direzioni;
	

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.setNumeroStanzeAdiacenti(0);
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.setStanzeAdiacenti(new Stanza[NUMERO_MASSIMO_DIREZIONI]);
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
    	for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) {
        		this.getStanzeAdiacenti()[i] = stanza;
        		aggiornato = true;
        	}
    	if (!aggiornato)
    		if (this.getNumeroStanzeAdiacenti() < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni[getNumeroStanzeAdiacenti()] = direzione;
    			this.getStanzeAdiacenti()[getNumeroStanzeAdiacenti()] = stanza;
    		    this.setNumeroStanzeAdiacenti(this.getNumeroStanzeAdiacenti() + 1);
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		for(int i=0; i<this.getNumeroStanzeAdiacenti(); i++)
        	if (this.direzioni[i].equals(direzione))
        		stanza = this.getStanzeAdiacenti()[i];
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
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
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	String s = new String();
    	s += this.nome;
    	s += "\nUscite: ";
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			s += " " + direzione;
    	s += "\nAttrezzi nella stanza: ";
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo != null)
    			s += attrezzo.toString()+" ";
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
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null){
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
			}
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
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null){
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
			}
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {	 
		Attrezzo attrezzo = null;		 
		Attrezzo[] nuoviAttrezzi = new Attrezzo[10];
		int j = 0;
		
		for(int i=0; i<this.numeroAttrezzi; i++){
			if(this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo))
				attrezzo = this.attrezzi[i];
			else {
				nuoviAttrezzi[j] = this.attrezzi[i];
				j++;
			}
		}
		this.attrezzi = nuoviAttrezzi;
		this.numeroAttrezzi--;
		if (attrezzo != null) 
			return true;
		else
			return false;
	}


	/**
	 * Restituisce le direzioni in cui possibile muoversi.
	 * @return le direzioni delle stanze
	 */
	public String[] getDirezioni() {
		String[] direzioni = new String[this.getNumeroStanzeAdiacenti()];
	    for(int i=0; i<this.getNumeroStanzeAdiacenti(); i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

	/**
	 * Restituisce il numero delle stanze adiacenti
	 * @return int numeroStanzeAdiacenti, il numero delle stanze adiacenti
	 */
	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	/**
	 * Modifica il numero delle stanze adiacenti
	 * @param numeroStanzeAdiacenti
	 * 			il numero delle stanze adiacenti.
	 */
	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	/**
	 * Restituisce un array contenente le stanze adiacenti
	 * @return Stanza[] stanzeAdiacenti, le stanze adiacenti.
	 */
	public Stanza[] getStanzeAdiacenti() {
		return stanzeAdiacenti;
	}

	/**
	 * Modifica l'array delle stanze adiacenti
	 * @param stanzeAdiacenti
	 * 		le stanze adiacenti.
	 */
	public void setStanzeAdiacenti(Stanza[] stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

}
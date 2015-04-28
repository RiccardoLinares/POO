package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe che crea e gestisce il Labirinto con le relative stanze
 * 
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @see Stanza
 * @version 0.3
 */
public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;


	/**
	 * Inizializza il labirinto con le relative stanze e collegamenti
	 */
	public Labirinto(){
		init();
	}
   
	/**
	 * Crea le stanze ed i collegamenti del labirinto
	 */
	private void init() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	Attrezzo matita = new Attrezzo("matita", 2);
    	Attrezzo chiave = new Attrezzo("chiave", 2); //TODO cancellare attrezzo, (serve per provare stanzaBloccata)
    	Attrezzo mattone = new Attrezzo("mattone", 9);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaBuia aulaVideo = new StanzaBuia("Aula Video", "lanterna");
		StanzaMagica laboratorioChimica = new StanzaMagica("Laboratorio Chimica");
	    StanzaBloccata ripostiglio = new StanzaBloccata("Ripostiglio", "chiave","nord");
	    Stanza secretLab = new Stanza("Laboratorio segreto"); //TODO cancellare dopo
	    
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("nord", aulaVideo);
		laboratorio.impostaStanzaAdiacente("sud", laboratorioChimica);
		aulaVideo.impostaStanzaAdiacente("sud", laboratorio);
		aulaVideo.impostaStanzaAdiacente("nord", ripostiglio);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		ripostiglio.impostaStanzaAdiacente("nord", secretLab);
		
        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(matita);
		atrio.addAttrezzo(lanterna); //TODO cancellare questo attrezzo dopo aver corretto tutto il resto (serve per provare stanza magica)
		atrio.addAttrezzo(chiave); //TODO cancellare dopo
		atrio.addAttrezzo(mattone); //TODO
		
		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }
    
	/**
	 * Restituisce la stanza vincente.
	 * @return stanzaVincente la stanza vincente
	 */
    public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
    
    /**
     * Modifica la stanza vincente.
     * @param stanzaVincente
     * 		la stanza vincente.
     */
    public void setStanzaVincente(Stanza stanzaVincente){
    	 this.stanzaVincente = stanzaVincente;
    }

    /**
     * Modifica la stanza in cui si trova il giocatore.
     * @param stanzaCorrente
     * 		 la stanza in cui si trova il giocatore
     */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	/**
	 * Restituisce la stanza in cui si trova il giocatore.
	 * @return  la stanza in cui si trova il giocatore
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}

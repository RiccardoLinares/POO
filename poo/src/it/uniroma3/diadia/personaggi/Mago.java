package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, "+
    "con una mia magica azione, troverai un nuovo oggetto " +
	"per il tuo bel borsone!";
	
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho più nulla...";
	
	private Attrezzo attrezzo;
	
	/**
	 * Costruttore della classe Mago
	 */
    public Mago(String nome, String presentazione, Attrezzo attrezzo){
    	super(nome, presentazione);
    	this.attrezzo = attrezzo;
    }

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		if(attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			this.attrezzo = null;
			messaggio = MESSAGGIO_DONO;
		}else {
			messaggio = MESSAGGIO_SCUSE;
		}
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		int pesoDimezzato = attrezzo.getPeso()/2;
			attrezzo = new Attrezzo(attrezzo.getNome(), pesoDimezzato);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			return "Per la barba di Merlino. sei davvero gentile per essere un sempliciotto!"+
		"Grazie, ma non ne ho bisogno! SIM SALA BIM!";	
	
	}
    
}

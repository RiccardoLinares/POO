package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci implements Comando {
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire...";
	
	private String messaggio;
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			System.out.println(this.messaggio);
		}else
			System.out.println(MESSAGGIO_CON_CHI);
		}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public void setParametro(String parametro){
		}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "interagisci";
	}
	}
	
	

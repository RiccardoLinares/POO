package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando{

	private String nomeAttrezzo;

	/**
	 * esecuzione del comando.
	 */
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
			System.out.println("Cosa vuoi raccogliere?");
		else { 
			Attrezzo attrezzoDaPrendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			//controlla se l'attrezzo è presente nella stanza
			if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo))	{
				//mette l'attrezzo nella borsa e lo rimuove dalla stanza
				if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere))  {
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
					System.out.println("Hai raccolto l'oggetto "+ nomeAttrezzo +"");
				}
				else 
					System.out.println("Non puoi raccogliere l'oggetto!");

			} else 
				System.out.println("L'oggetto che vuoi raccogliere non è in questa stanza!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "prendi";
	}
	
}

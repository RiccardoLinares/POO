package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella il comando prendi
 * che permette di prendere un oggetto della stanza e metterlo nella borsa del giocatore
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 * @see Comando, Partita
 */

public class ComandoPrendi implements Comando{

	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo != null){
			if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){

				Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				
				if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo) &&
						partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)){
					System.out.println("Attrezzo " + attrezzo.getNome() + " preso");
				}
				else{
					System.out.println("Errore! Attrezzo " + attrezzo.getNome() + " non preso!");
				}
			}
			else
				System.out.println("Attrezzo non trovato!");
		}
		else
			System.out.println("Quale attrezzo vuoi prendere?");
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

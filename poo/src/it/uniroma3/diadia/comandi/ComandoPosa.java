package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{

	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo != null){
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)){

				Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);

				if(partita.getLabirinto().getStanzaCorrente().getClass().equals("StanzaMagica")){
					System.out.println("StanzaMagica");
				}//TODO
				
				if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo) &&
						!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)){
					System.out.println("Attrezzo " + attrezzo.toString() + " posato nella stanza");
				}
				else
					System.out.println("Errore! Attrezzo " + attrezzo.getNome() + " non posato!");
			}
			else
				System.out.println("Attrezzo non trovato!");
		}
		else
			System.out.println("Quale attrezzo vuoi posare?");
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
		return "posa";
	}
}

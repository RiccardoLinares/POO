package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala implements Comando {
	private static final String MESSAGGIO_A_CHI = "A chi dovrei fare un regalo...?";
	private String messaggio;
	private String nomeAttrezzo;


	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		Attrezzo attrezzoRegalato = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(attrezzoRegalato!=null){
			if(personaggio!=null) {
				this.messaggio = personaggio.riceviRegalo(attrezzoRegalato, partita);
				System.out.println(this.messaggio);	
			}else{
				System.out.println(MESSAGGIO_A_CHI);
			}
		}else{
			System.out.println("Cosa vuoi regalare?");
		}
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "regala";
	}

}

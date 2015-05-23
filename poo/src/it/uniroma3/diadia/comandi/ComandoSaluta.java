package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


public class ComandoSaluta implements Comando {
	private static final String MESSAGGIO_A_CHI = "Chi dovrei salutare???...";
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			if(!personaggio.haSalutato()) {
				personaggio.haSalutato();
				System.out.println("Ti sei presentato con successo!");
			}
			else
				System.out.println("Ti sei già presentato con questo personaggio");
			}
			else
				System.out.println(MESSAGGIO_A_CHI);	
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "saluta";
	}

}

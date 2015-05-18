package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella il comando guarda
 * che permette di conoscere la descrizione della stanza
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 * @see Comando, Partita
 */
public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione() + "\n" + partita.getGiocatore().getBorsa().toString());
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
		return "guarda";
	}

}

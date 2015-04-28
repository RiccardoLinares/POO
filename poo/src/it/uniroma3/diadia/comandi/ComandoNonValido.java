package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella un comando non valido
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 * @see Comando, Partita
 */
public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non valido");
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
		return null;
	}

}

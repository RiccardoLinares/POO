package it.uniroma3.diadia.comandi;

import java.util.Scanner;

/**
 * Questa classe modella una fabbrica di comandi semplice
 * che permette di costruire i comandi che il giocatore vuole eseguire.
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @version 0.3
 * @see Comando, FabbricaDiComandi
 */
public class FabbricaDiComandiSemplice implements FabbricaDiComandi {
	
	private Scanner scannerDiParole;

	public Comando costruisciComando(String istruzione) { 

		scannerDiParole = new Scanner(istruzione); 

		String nomeComando = null; 

		String parametro = null; 

		Comando comando = null; 

		if (scannerDiParole.hasNext())

			nomeComando = scannerDiParole.next(); // prima parola: nome del comando 

		if (scannerDiParole.hasNext())

			parametro = scannerDiParole.next();// seconda parola: eventuale parametro 

		if (nomeComando == null) 

			comando = new ComandoNonValido();

		else if (nomeComando.equals("vai"))

			comando = new ComandoVai(); 

		else if (nomeComando.equals("prendi"))

			comando = new ComandoPrendi();

		else if (nomeComando.equals("posa"))

			comando = new ComandoPosa();

		else if (nomeComando.equals("aiuto"))

			comando = new ComandoAiuto();

		else if (nomeComando.equals("fine"))

			comando = new ComandoFine();

		else if (nomeComando.equals("guarda"))

			comando = new ComandoGuarda();

		else comando = new ComandoNonValido(); 

		comando.setParametro(parametro); 

		return comando; 

	} 

}

package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per la correttezza dei metodi
 * @author Mauro Iemboli, con la collaborazione di Riccardo Linares
 *
 */
public class PartitaTest {
	private Partita prova;
    private Stanza atrio;
    private Stanza biblioteca;
    private Labirinto labirinto;
    private Giocatore playerOne;

    @Before
    public void setUp() throws Exception {
    	prova = new Partita();
	    labirinto = new Labirinto();
	    playerOne = new Giocatore();
	    atrio = new Stanza("Atrio"); //stanza corrente
	    biblioteca = new Stanza("Biblioteca"); //stanza vincente
	    playerOne.setCfu(0);//condizione per la quale finisce la partita
	    labirinto.setStanzaCorrente(atrio);
	    prova.setGiocatore(playerOne);
	    prova.setLabirinto(labirinto);
	    prova.setFinita();
}

	

	@Test
	public void testVinta() {
		assertEquals(biblioteca.getNome(), labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testIsFinita() {
		assertTrue(this.prova.isFinita());
	}

	@Test
	public void testGetLabirinto() {
		assertEquals(labirinto, prova.getLabirinto());
	}

	@Test
	public void testGetGiocatore() {
		assertEquals(playerOne, prova.getGiocatore());
	}

	

}

package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per la correttezza dei metodi
 * @author Mauro Iemboli, con la collaborazione di Riccardo Linares
 *
 */
public class GiocatoreTest {
	private Giocatore playerOne;
	private Borsa borsa;
	private int cfu;

	@Before
	public void setUp() throws Exception {
		this.cfu=20;
		borsa = new Borsa();
		playerOne = new Giocatore();
		playerOne.setCfu(cfu);
		playerOne.setBorsa(borsa);
		
	}

	@Test
	public void testGetCfu() {
		assertEquals(cfu, playerOne.getCfu());
	}

	@Test
	public void testGetBorsa() {
		assertEquals(borsa, playerOne.getBorsa());
    }


}

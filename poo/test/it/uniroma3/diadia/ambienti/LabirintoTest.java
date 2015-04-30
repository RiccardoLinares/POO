package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per la correttezza dei metodi
 * @author Mauro Iemboli, con la collaborazione di Riccardo Linares
 *
 */
public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza atrio;
	private Stanza biblioteca;
	

	@Before
	public void setUp() throws Exception {
		labirinto = new Labirinto();
		atrio = new Stanza("Atrio"); //Stanza Corrente
		biblioteca = new Stanza("Biblioteca"); //Stanza Vincente
		labirinto.setStanzaCorrente(atrio);
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(biblioteca.getNome(), labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals(atrio.getNome(), labirinto.getStanzaCorrente().getNome());
	}
	
	

}

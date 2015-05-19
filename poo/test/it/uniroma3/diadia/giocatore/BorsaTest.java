package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per la correttezza dei metodi
 * @author Mauro Iemboli, con la collaborazione di Riccardo Linares
 *
 */
public class BorsaTest {
	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Borsa borsaDaSvuotare;
	private Attrezzo spazzolino;
	private Attrezzo telefono;
	private Attrezzo cianfrusaglia;
	
	@Before
	public void setUp() throws Exception {
		borsaPiena = new Borsa();
		spazzolino = new Attrezzo("Spazzolino", 1);
		telefono = new Attrezzo("Telefono", 2);
		cianfrusaglia = new Attrezzo("Cianfrusaglia", 7);
		borsaPiena.addAttrezzo(spazzolino);
		borsaPiena.addAttrezzo(telefono);
		borsaVuota = new Borsa();
		borsaDaSvuotare = new Borsa();
		borsaDaSvuotare.addAttrezzo(cianfrusaglia);
		borsaDaSvuotare.removeAttrezzo("Cianfrusaglia");
	}

	@Test
	public void testAddAttrezzo() {
		assertEquals(spazzolino.getNome(), borsaPiena.getAttrezzo("Spazzolino").getNome());
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, borsaPiena.getPesoMax());
	}

	@Test
	public void testGetAttrezzo() {
	    assertEquals(spazzolino, borsaPiena.getAttrezzo("Spazzolino"));
	}

	@Test
	public void testGetPeso() {
		assertEquals(3, borsaPiena.getPeso());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(borsaVuota.isEmpty());
	}

	@Test
	public void testHasAttrezzo() {
		assertTrue(borsaPiena.hasAttrezzo("Spazzolino"));
	}

	@Test
	public void testRemoveAttrezzo() {
		assertTrue(borsaDaSvuotare.isEmpty());
	}

}

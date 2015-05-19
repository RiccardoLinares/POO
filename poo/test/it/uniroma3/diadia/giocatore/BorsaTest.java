package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.*;

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
	private Attrezzo spada;
	
	@Before
	public void setUp() throws Exception {
		borsaPiena = new Borsa();
		spazzolino = new Attrezzo("Spazzolino", 1);
		telefono = new Attrezzo("Telefono", 2);
		spada = new Attrezzo("Spada", 2);
		cianfrusaglia = new Attrezzo("Cianfrusaglia", 7);
		borsaPiena.addAttrezzo(spada);
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
		assertEquals(5, borsaPiena.getPeso());
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
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		List<Attrezzo> aspettativa = new ArrayList<Attrezzo>();
		aspettativa.add(spazzolino);
		aspettativa.add(spada);
		aspettativa.add(telefono);
		assertEquals(aspettativa, borsaPiena.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		List<Attrezzo> aspettativa = new ArrayList<Attrezzo>();
		aspettativa.add(spada);
		aspettativa.add(spazzolino);
		aspettativa.add(telefono);
		assertEquals(aspettativa, borsaPiena.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> tmp = new HashSet<Attrezzo>();
		Set<Attrezzo> tmp1 = new HashSet<Attrezzo>();
		tmp1.add(spazzolino);
		tmp.add(spada);
		tmp.add(telefono);
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		mappa.put(2, tmp);
		mappa.put(1, tmp1);
		assertEquals(mappa, borsaPiena.getContenutoRaggruppatoPerPeso());		
	}
}

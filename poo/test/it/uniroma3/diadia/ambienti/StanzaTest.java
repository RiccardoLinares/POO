package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per la correttezza dei metodi
 * @author Mauro Iemboli, con la collaborazione di Riccardo Linares
 *
 */
public class StanzaTest {
	private Stanza atrio;
	private Stanza aulaN11;
	private Attrezzo screwdriver;
	private Attrezzo fez;
	private Attrezzo h2o;
	
	@Before
	public void setUp(){
		atrio = new Stanza("Atrio");
		aulaN11 = new Stanza("Aula N11");
		screwdriver = new Attrezzo("Sonic Screwdriver", 2);
		fez = new Attrezzo("Fez",1);
		h2o = new Attrezzo("Acqua", 1);
		atrio.impostaStanzaAdiacente("nord", aulaN11);
		aulaN11.addAttrezzo(screwdriver);
		atrio.addAttrezzo(h2o);
		atrio.addAttrezzo(fez);	
		atrio.removeAttrezzo(fez.toString());

		
	}
		
	@Test
	public void test_impostaStanzaAdiacente() {
		assertEquals(aulaN11.getNome(), atrio.getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	public void test_addAttrezzo() {
		assertEquals(screwdriver.getNome(), aulaN11.getAttrezzo("Sonic Screwdriver").getNome());
	}
	
	@Test
	public void test_hasAttrezzo() {
		assertTrue(aulaN11.hasAttrezzo("Sonic Screwdriver"));
	}
	
	@Test
    public void test_removeAttrezzo() {
		assertFalse(atrio.hasAttrezzo("Fez"));
	}
	
}

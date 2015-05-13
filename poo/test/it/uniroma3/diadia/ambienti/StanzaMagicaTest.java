package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	private Attrezzo spada, ago, laccio;
	private StanzaMagica bagno;
	
 

	@Before
	public void setUp() throws Exception {
		this.bagno = new StanzaMagica("Bagno Magico");
		this.spada = new Attrezzo("Spada", 3);
		this.ago = new Attrezzo("Ago", 1);
		this.laccio = new Attrezzo("Laccio", 2);
		this.bagno.addAttrezzo(spada);
		this.bagno.addAttrezzo(ago);
		this.bagno.addAttrezzo(laccio);
	}

	@Test
	public void testAddAttrezzo() {
		assertEquals(spada, this.bagno.getAttrezzo("Spada"));
		
	}
    
}

package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	private Stanza cortile;
	private Stanza n11;
	private Stanza laboratorio;
	private Attrezzo chiave;

	@Before
	public void setUp() throws Exception {
		this.laboratorio = new StanzaBloccata("Laboratorio", "chiave", "est");
		this.cortile= new Stanza("Cortile");
		this.n11 = new Stanza("n11");
		this.chiave = new Attrezzo ("Chiave", 2);
		laboratorio.impostaStanzaAdiacente("est", cortile);
		laboratorio.impostaStanzaAdiacente("ovest", n11);
		
	}

	@Test
	public void testGetStanzaAdiacente_NonBloccata() {
		assertEquals(n11, laboratorio.getStanzaAdiacente("ovest"));
	}
	
	public void testGetStanzaAdiacente_Bloccata() {
		assertEquals(cortile, laboratorio.getStanzaAdiacente("est"));
	}
	
	public void testGetStanzaAdiacente_ConChiave() {
		laboratorio.addAttrezzo(chiave);
		assertEquals(cortile, laboratorio.getStanzaAdiacente("est"));
	}

}

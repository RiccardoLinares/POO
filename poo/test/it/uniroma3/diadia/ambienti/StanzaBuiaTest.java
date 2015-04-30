package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	private StanzaBuia grotta;
	private Attrezzo lanterna;

	@Before
	public void setUp() throws Exception {
		this.grotta = new StanzaBuia("Grotta", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 2);
		}

	@Test
	public void testGetDescrizione_Buia() {
		assertEquals("Qui c'è buio pesto", grotta.getDescrizione());
	}

	@Test
	public void testStanzaBuia_NonBuia() {
		grotta.addAttrezzo(lanterna);
		assertEquals("la stanza e' illuminata da lanterna", grotta.getDescrizione());
	}

}

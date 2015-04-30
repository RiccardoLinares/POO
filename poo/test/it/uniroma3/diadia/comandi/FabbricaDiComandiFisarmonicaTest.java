package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fabbricaComandi;
	private Labirinto labirinto;
	private Stanza stanza;
	private Attrezzo attrezzo;
	

	@Before
	public void setUp() throws Exception {
		this.fabbricaComandi = new FabbricaDiComandiFisarmonica();
		this.labirinto = new Labirinto();
		this.stanza = new Stanza("stanza");
		this.attrezzo = new Attrezzo("attrezzo", 1);
		
		this.labirinto.setStanzaCorrente(stanza);
		this.stanza.addAttrezzo(attrezzo);
	}
	
	@Test
	public void getNomeTest() {
	    assertEquals("guarda", this.fabbricaComandi.costruisciComando("guarda").getNome());
	}
	
	@Test
	public void getParametroTest() {
	    assertEquals(null, this.fabbricaComandi.costruisciComando("guarda").getParametro());
	}
	
	/* PRENDI */
	@Test
	public void getNome_PrendiTest() {
	    assertEquals("prendi", this.fabbricaComandi.costruisciComando("prendi attrezzo").getNome());
	}
	
	@Test
	public void getParametro_PrendiTest() {
	    assertEquals("attrezzo", this.fabbricaComandi.costruisciComando("prendi attrezzo").getParametro());
	}
}

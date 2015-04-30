package it.uniroma3.diadia.attrezzi;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test per la correttezza dei metodi
 * @author Mauro Iemboli, con la collaborazione di Riccardo Linares
 *
 */
public class AttrezzoTest {
private Attrezzo osso;
private Attrezzo lanterna;
	@Before
	public void setUp(){
		osso = new Attrezzo("osso", 2);
		lanterna = new Attrezzo("lanterna",3);
		
	}

	@Test
	public void testGetNome() {
		assertEquals("osso", this.osso.getNome());		
		assertEquals("lanterna", this.lanterna.getNome());
	}
	
	@Test
	public void testGetPeso() {
		assertEquals(2, this.osso.getPeso());
		assertEquals(3, this.lanterna.getPeso());
	}
	
	@Test
	public void testToString() {
		assertEquals("osso (2kg)", this.osso.toString());
		assertEquals("lanterna (3kg)", this.lanterna.toString());
	}

}

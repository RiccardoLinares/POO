package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiSempliceTest {
	private FabbricaDiComandiSemplice fabbricaComandi;
	private ComandoAiuto aiuto;
	private ComandoFine fine;
	private ComandoGuarda guarda;
	private ComandoPosa posa;
	private ComandoPrendi prendi;
	private ComandoVai vai;
	private ComandoNonValido nonValido;

	@Before
	public void setUp() throws Exception {
		this.fabbricaComandi = new FabbricaDiComandiSemplice();
		this.aiuto = new ComandoAiuto();
		this.fine = new ComandoFine();
		this.guarda = new ComandoGuarda();
		this.posa = new ComandoPosa();
		this.prendi = new ComandoPrendi();
		this.vai = new ComandoVai();
		this.nonValido = new ComandoNonValido();
	}

	@Test
	public void testCostruisciComando_Aiuto() {
		assertSame(this.aiuto, fabbricaComandi.costruisciComando("aiuto"));
	}
	
	@Test
	public void testCostruisciComando_NonValido() {
        assertSame(this.nonValido, fabbricaComandi.costruisciComando(null));
	}
	
	@Test
	public void testCostruisciComando_Fine() {
		assertSame(this.fine, fabbricaComandi.costruisciComando("fine"));
	}

	

}

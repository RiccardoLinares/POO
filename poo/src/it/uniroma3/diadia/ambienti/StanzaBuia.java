package it.uniroma3.diadia.ambienti;

/**
 * Classe StanzaBuia - una stanza in un gioco di ruolo.
 * È una particolare stanza in cui vi è un buio pesto.
 * Per illuminare la stanza è necessario posare nella stanza un oggetto specifico.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @see Stanza
 * @version 0.3
*/

public class StanzaBuia extends Stanza {
	private String attrezzoIllumina;

	/**
	 * La stanza buia
	 * @param nome
	 * 		il nome della stanza
	 * @param attrezzoIllumina
	 * 		l'attrezzo che illumina la stanza
	 */
	public StanzaBuia(String nome, String attrezzoIllumina) {
		super(nome);
		this.attrezzoIllumina = attrezzoIllumina;
	}
	
	@Override
    public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzoIllumina)){
			return"Qui c'è buio pesto";
		}
		else{
			return"la stanza e' illuminata da " + this.attrezzoIllumina;
		}
	}
}
	
	

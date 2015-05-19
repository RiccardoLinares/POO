package it.uniroma3.diadia.ambienti;

/**
 * Classe StanzaBloccata - una stanza in un gioco di ruolo.
 * È una particolare stanza in cui una o più direzioni sono bloccate.
 * Per sbloccare è necessario posare nella stanza un oggetto che funge da chiave.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @see Stanza
 * @version 0.3
*/

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoChiave;

	/**
	 * Stanza con direzione bloccata
	 * @param nome
	 * 		il nome della stanza
	 * @param attrezzoChiave
	 * 		l'attrezzo che sblocca la direzione
	 * @param direzioneBloccata
	 * 		la direzione bloccata
	 */
	public StanzaBloccata(String nome, String attrezzoChiave, String direzioneBloccata) {
		super(nome);
		this.attrezzoChiave = attrezzoChiave;
		this.setDirezioneBloccata(direzioneBloccata);
	}

	@Override
	public Stanza getStanzaAdiacente (String direzione) {
		if ((direzione.equals(direzioneBloccata)) && !(this.hasAttrezzo(attrezzoChiave))) { 
			System.out.println ("La porta è bloccata!");
			return this;
		} 
		else{
			return super.getStanzaAdiacente(direzione);
		}
	}

	/**
	 * Restituisce la direzione bloccata
	 * @return String direzioneBloccata, la direzione bloccata
	 */
	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	/**
	 * Modifica la direzione bloccata
	 * @param direzioneBloccata
	 * 		la direzione bloccata
	 */		
	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}
}

package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoChiave;

	public StanzaBloccata(String nome, String attrezzoChiave, String direzioneBloccata) {
		super(nome);
		this.attrezzoChiave = attrezzoChiave;
		this.setDirezioneBloccata(direzioneBloccata);
		//TODO controllare cosa fare!
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

	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}
}

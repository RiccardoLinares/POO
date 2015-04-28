package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoIllumina;

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
	
	

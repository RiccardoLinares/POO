package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaMagica - una stanza in un gioco di ruolo.
 * Dopo un certo numero di attrezzi (la soglia magica) posati nella stanza, la stanza inizia a comportarsi magicamente.
 * Quando la stanza si comporta magicamente ogni attrezzo posato viene raddopiato di peso e il nome viene invertito
 * (es. chiave (2kg) diventa evaihc (4kg) )
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes, con delle modifiche apportate da Riccardo Linares e Mauro Iemboli)
 * @see Stanza
 * @version 0.3
*/
class StanzaMagicaProtected extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = 3;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	/**
	 * La stanza magica con la soglia magica di default
	 * @param nome
	 * 		il nome della stanza magica
	 */
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	/**
	 * La stanza magica
	 * @param nome
	 * 		il nome della stanza magica
	 * @param soglia
	 * 		il numero di attrezzi da posare per avere un comportamento magico
	 */
	public StanzaMagicaProtected(String nome, int soglia) {

		super(nome);

		this.contatoreAttrezziPosati = 0;

		this.sogliaMagica = soglia;

	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {

		this.contatoreAttrezziPosati++;

		if (this.contatoreAttrezziPosati > this.sogliaMagica) 
			attrezzo = this.modificaAttrezzo(attrezzo);

		return this.attrezzi.add(attrezzo);
	}

	/**
	 * Modifica l'attrezzo raddoppiandone il peso e invertendone l'ordine delle lettere
	 * @param attrezzo
	 * 		l'attrezzo da modificare
	 * @return attrezzo, l'attrezzo modificato
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);

		return attrezzo;

	}

}
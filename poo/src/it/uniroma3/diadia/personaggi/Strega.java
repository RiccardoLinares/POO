/**
Se si interagisce con una strega questa ci trasferisce
in una stanza tra quelle adiacenti.
Se non l'abbiamo salutata ci trasferisce in quella adiacente con meno attrezzi
Se l'abbiamo salutata in quella con più attrezzi
 * 
 */
package it.uniroma3.diadia.personaggi;

import java.util.*;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Mauro
 *
 */
public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_HA_SALUTATO = "Brutto screanzato! "+
    "Prima di agire dovresti salutare una signorina affascinante come me!" +
	"Per punizione verrai ora magicamente teletrasportato nella stanza con meno attrezzi!" +
    "PUF";
	private static final String MESSAGGIO_NON_HA_SALUTATO = "Ma ciao splendore!" +
    "Io sono la strega Beatrice la Telesportatrice, e oggi è il tuo giorno fortunato"+
	"Verrai ora magicamente teletrasportato nella stanza adiacente con più attrezzi, SMACK" +
    "PUF";
	
	/**
	 * Costruttore della classe strega
	 */
	public Strega(String nome, String presentazione){
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		ArrayList<Stanza> stanze = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();

		Stanza max = Collections.max(stanze);
		Stanza min = Collections.min(stanze);

		String messaggio;

		if(!haSalutato()){
			partita.getLabirinto().setStanzaCorrente(min);
			messaggio = MESSAGGIO_NON_HA_SALUTATO;
		}else{
			partita.getLabirinto().setStanzaCorrente(max);
			messaggio = MESSAGGIO_HA_SALUTATO;
		}
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo.getNome());
		return  "Ma che gentile, grazie! AHAHAHAHAHAHAAHAHAH!";
	}

}

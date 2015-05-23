/**E' una classe che estende la classe AbstractPersonaggio
 * quando onteragiamo con un cane, questi morde
 * togliendoci CFU!
 * A meno che non gli diamo qualcosa da mangiare
 * 
 */
package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Mauro
 *
 */
public class Cane extends AbstractPersonaggio{
	private Attrezzo attrezzoDaRegalare;
	private Attrezzo attrezzoDato;
	
	/**
	 * 
	 * @param nome
	 * @param presentazione
	 */
	public Cane(String nome, String presentazione, Attrezzo attrezzoDaRegalare, Attrezzo attrezzoDato) {
		super(nome, presentazione);
		this.attrezzoDaRegalare = attrezzoDaRegalare;
		this.attrezzoDato = attrezzoDato;
		}
	
	public String agisci(Partita partita) {
		String messaggio;
		messaggio = "Il cane è affamato e ti ha morso!!";
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-2);
		if(partita.giocatoreIsVivo()){
			System.out.println("Hai " + partita.getGiocatore().getCfu() + " cfu");
		}
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String messaggio;
		if(attrezzo!=null){
			if(attrezzoDaRegalare.equals(attrezzo)){
				messaggio = "Sembra che" + attrezzo.getNome() + "piaccia davvero tanto al cane!";
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaRegalare.getNome());
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDato);
				System.out.println("Il cane ha lasciato cadere a terra" +attrezzoDato.getNome());
			}else{
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
				messaggio = "Il cane non sembra apprezzare" + attrezzo.getNome() +
						"Prova con qualcos'altro!";
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			}
		}
		else{
			messaggio = "Non hai nulla da regalare!";
		}
		return messaggio;
	}

}

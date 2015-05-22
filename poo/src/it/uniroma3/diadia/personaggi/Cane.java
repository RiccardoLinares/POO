/**E' una classe che estende la classe AbstractPersonaggio
 * quando onteragiamo con un cane, questi morde
 * togliendoci CFU!
 * A meno che non gli diamo qualcosa da mangiare
 * 
 */
package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.*;

/**
 * @author Mauro
 *
 */
public class Cane extends AbstractPersonaggio{
	private String attrezzoDaMangiare;
	
	/**
	 * 
	 * @param nome
	 * @param presentazione
	 * @param attrezzoDaMangiare 
	 */
	public Cane(String nome, String presentazione, String AttrezzoDaMangiare, String attrezzoDaMangiare) {
		super(nome, presentazione);
		this.attrezzoDaMangiare = attrezzoDaMangiare;
	}
	
	public String agisci(Partita partita) {
		String messaggio;
		if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzoDaMangiare)) {
			messaggio = "Il cane è affamato e ti ha morso!!";
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			if(partita.giocatoreIsVivo()){
				System.out.println("Hai " + partita.getGiocatore().getCfu() + " cfu");
			}
        }else{
        	messaggio = "Il cane sta mangiando" +this.attrezzoDaMangiare +"non sembra essere pericoloso.";
        }
		return messaggio;
	}

}

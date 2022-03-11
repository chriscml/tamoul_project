package tamoul_package;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> deck = new ArrayList<>();
	ArrayList<Card> discard = new ArrayList<>();
	int nombre_aleatoire = 0, nombre_aleatoire_anc = 0, max = 52, min = 0;

	public Deck() {
		for (SuitEnum suit : SuitEnum.values()) {
			for (RankEnum rank : RankEnum.values()) {
				deck.add(new Card(rank, suit));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Card> getDiscard() {
		return discard;
	}

	public void distrib(Menu menu) {
		/*
		 * for (int i = 0; i < 4; i++) { do { nombre_aleatoire = min + (int)
		 * (Math.random() * ((max - min) + 1)); } while (nombre_aleatoire ==
		 * nombre_aleatoire_anc); nombre_aleatoire_anc = nombre_aleatoire; max--;
		 * player.deck_player.add(new Card(getDeck().get(nombre_aleatoire).getRank(),
		 * getDeck().get(nombre_aleatoire).getSuit())); deck.remove(nombre_aleatoire);
		 * System.out.println(player.deck_player.get(i).getRank() + " " +
		 * player.deck_player.get(i).getSuit()); } System.out.println(max + "\n");
		 */

		int cpt = 0;
		// shuffle();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < menu.getNbOfPlayers(); j++) {
				menu.players.get(j).deck_player.add(deck.get(51 - cpt));
				// deck.remove(cpt);
				System.out.println(
						"player" + (j + 1) + " carte" + cpt + " : " + menu.players.get(j).deck_player.get(i).getRank()
								+ " " + menu.players.get(j).deck_player.get(i).getSuit());
				cpt = cpt + 1;
			}
			System.out.println("\n ------------------------ \n");
		}

		/*
		 * for (int i = 0; i < (4 * menu.getNbOfPlayers()); i++) { deck.remove(i); }
		 */
	}

	public void drawCard(Deck paquet) {
		int i = 0;
		paquet.getDiscard().add(paquet.getDeck().get(getDeck().size() - 1));
		System.out.println(paquet.getDiscard().get(i).getRank() + " " + paquet.getDiscard().get(i).getSuit());
	}

}
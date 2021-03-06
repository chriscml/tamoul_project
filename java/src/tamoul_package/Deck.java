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

	public void distrib(ArrayList<Player> players) {
		int cpt = 0;
		// shuffle();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < Game.getNbOfPlayers(); j++) {
				players.get(j).deck_player.add(deck.get(51 - cpt));
				deck.remove(51 - cpt);
				/*
				 * System.out.println( "player" + (j + 1) + " carte" + cpt + " : " +
				 * menu.players.get(j).deck_player.get(i).getRank() + " " +
				 * menu.players.get(j).deck_player.get(i).getSuit());
				 */
				cpt = cpt + 1;
			}
			// System.out.println("\n ------------------------ \n");
		}
	}
}
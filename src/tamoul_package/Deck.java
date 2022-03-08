package tamoul_package;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> deck = new ArrayList<>();

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

	public void distrib(Player player) {
		int nombre_aleatoire = 0, nombre_aleatoire_anc = 0, max = 51;
		for (int i = 0; i < 4; i++) {
			do {
				nombre_aleatoire = 0 + (int) (Math.random() * ((max - 0) + 1));
			} while (nombre_aleatoire == nombre_aleatoire_anc);
			nombre_aleatoire_anc = nombre_aleatoire;
			max--;
			player.deck_player.add(
					new Card(getDeck().get(nombre_aleatoire).getRank(), getDeck().get(nombre_aleatoire).getSuit()));
			deck.remove(nombre_aleatoire);
			System.out.println(player.deck_player.get(i).getRank() + " " + player.deck_player.get(i).getSuit());
		}

	}

}
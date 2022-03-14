package tamoul_package;

import java.util.Scanner;

public class Turn {

	public void firstMoove(Deck paquet, Player player) {

		int choice = 0, card_to_exchange = 0;
		Card temp, temp2;
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch (choice) {
		case 0:
			System.out.println("you chose to draw a card");
			drawCard(paquet);
			break;
		case 1:
			System.out.println("you chose to exchange with the discard, what card ?");
			card_to_exchange = sc.nextInt();
			temp = paquet.getDiscard().get(paquet.getDiscard().size() - 1); // retiens la carte de la pioce
			temp2 = player.deck_player.get(card_to_exchange); // retiens la carte à echangé
			paquet.getDiscard().remove(paquet.getDiscard().get(paquet.getDiscard().size() - 1)); // enleve la carte de
																									// la pioche
			player.deck_player.remove(card_to_exchange); // enleve la carte du joueur
			player.deck_player.add(card_to_exchange, temp); // mets la carte de la pioche a la place de la carte du
															// joueur
			paquet.getDiscard().add(temp2); // mets la carte du joueur sur la pioche
			break;
		}
	}

	public void drawCard(Deck paquet) {
		paquet.getDiscard().add(paquet.getDeck().get(paquet.getDeck().size() - 1));
		paquet.getDeck().remove(paquet.getDeck().size() - 1);
	}

	public void sevenHeight(Deck paquet) {
	}

	public void nineTen(Deck paquet) {
	}

	public void jackQueen(Deck paquet) {
	}

	public void kingBlack(Deck paquet) {
	}

}

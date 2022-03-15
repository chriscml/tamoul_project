package tamoul_package;

import java.util.Scanner;

public class Turn {

	public void firstMoove(Deck paquet, Player player) {

		int choice = 0, card_to_exchange = 0;
		Card temp,temp2;
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch (choice) {
		case 0:
			System.out.println("you chose to draw a card");
			drawCard(paquet);
			break;
		case 1:
			System.out.println("you chose to exchange with the discard, what card ?");
			/*card_to_exchange = sc.nextInt();
			temp = paquet.getDiscard().get(paquet.getDiscard().size() - 1);
			temp2
			paquet.getDiscard().remove(paquet.getDiscard().get(paquet.getDiscard().size() - 1));
			paquet.getDiscard().add(player.deck_player.get(card_to_exchange));
			player.deck_player.add(card_to_exchange,temp);
			break;*/
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

package tamoul_package;

import java.util.Scanner;

public class Turn {
	
	private static final int SCORE_MIN_TO_TAMOUL = 5;
	
	public boolean firstMoove(Deck paquet, Player player, boolean already_last_turn) {
		boolean last_turn=false;
		int choice = 0, card_to_exchange = 0;
		Card temp, temp2;
		Scanner sc = new Scanner(System.in);
		System.out.println("choose your moove : \n 0 : draw a card \n 1 : exchange card with the discard");
		if(player.getScoreGame() <= SCORE_MIN_TO_TAMOUL && already_last_turn==false)
		{
			System.out.println(" 2 : tamoul");
		}
		choice = sc.nextInt();
		switch (choice) {
		case 0:
			System.out.println("you chose to draw a card");
			drawCard(paquet);
			if(already_last_turn == true)
			{
				last_turn=true;
			}
			else
			{
				last_turn = false;
			}
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
			if(already_last_turn == true)
			{
				last_turn=true;
			}
			else
			{
				last_turn = false;
			}
			break;
		case 2:
			System.out.println("Last turn !!");
			last_turn = true;
			break;
		}
		return last_turn;
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

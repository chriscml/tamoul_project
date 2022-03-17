package tamoul_package;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Turn {

	private static final int SCORE_MIN_TO_TAMOUL = 5;

	public boolean firstMove(Deck paquet, Player player, boolean already_last_turn, int turn_count) {
		boolean last_turn = false;
		int choice = 0, card_to_exchange = 0;
		Card temp, temp2;
		Scanner sc = new Scanner(System.in);
		System.out.println("choose your move : ");
		System.out.println(" 0 : draw a card");
		if (turn_count == 0) {

		} else {
			System.out.println(" 1 : exchange card with the discard");
		}
		try {
			do {
				choice = sc.nextInt();
				if (choice != 0 && choice != 1 && choice != 2) {
					System.out.println("le nombre rentree est incorrecte");
				}
			} while (choice != 0 && choice != 1 && choice != 2);
		} catch (InputMismatchException e) {
			System.out.println("le nombre rentree est incorrecte");
			firstMove(paquet, player, already_last_turn, turn_count);
		} catch (Exception e) {
			System.out.println("le nombre rentree est incorrecte");
			firstMove(paquet, player, already_last_turn, turn_count);
		}

		switch (choice) {
		case 0:
			System.out.println("you chose to draw a card");
			drawCard(paquet);
			if (already_last_turn == true) {
				last_turn = true;
			} else {
				last_turn = false;
			}
			last_turn = secondMove(paquet, player, already_last_turn, turn_count);
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
			if (already_last_turn == true) {
				last_turn = true;
			} else {
				last_turn = false;
			}
			break;

		}
		return last_turn;
	}

	public boolean secondMove(Deck paquet, Player player, boolean already_last_turn, int turn_count) {
		boolean last_turn = false;
		int choice = 0;
		Scanner sc = new Scanner(System.in);

		if (isAsset(paquet) == true) {
			System.out.println("do you want to use the card asset ?");
			System.out.println("0 : YES");
			System.out.println("1 : NO");
			try {
				do {
					choice = sc.nextInt();
					if (choice != 0 && choice != 1) {
						System.out.println("le nombre rentree est incorrecte");
					}
				} while (choice != 0 && choice != 1);
			} catch (InputMismatchException e) {
				System.out.println("le nombre rentree est incorrecte");
				secondMove(paquet, player, already_last_turn, turn_count);
			} catch (Exception e) {
				System.out.println("le nombre rentree est incorrecte");
				secondMove(paquet, player, already_last_turn, turn_count);
			}

			switch (choice) {
			case 0:
				// faire une fonction atout en fonction de la carte qui a été pioché+
				break;
			case 1:
				// ne rien faire
				break;
			}
		}

		System.out.println("choose your move");
		System.out.println(" 0 : exchange the draw with one of your card");
		if (turn_count == 0) {
		} else {
			if (player.getScoreGame() <= SCORE_MIN_TO_TAMOUL && already_last_turn == false) {
				System.out.println(" 1 : tamoul");
			}
		}
		System.out.println(" 2 : do nothing");
		try {
			do {
				choice = sc.nextInt();
				if (choice != 0 && choice != 1 && choice != 2) {
					System.out.println("le nombre rentree est incorrecte");
				}
			} while (choice != 0 && choice != 1 && choice != 2);
		} catch (InputMismatchException e) {
			System.out.println("le nombre rentree est incorrecte");
			secondMove(paquet, player, already_last_turn, turn_count);
		} catch (Exception e) {
			System.out.println("le nombre rentree est incorrecte");
			secondMove(paquet, player, already_last_turn, turn_count);
		}

		switch (choice) {
		case 0:
			System.out.println("select the card you want to exchange !");
			if (already_last_turn == true) {
				last_turn = true;
			} else {
				last_turn = false;
			}
			break;
		case 1:
			System.out.println("Last turn !!");
			last_turn = true;
			break;
		case 2:
			System.out.println("nothing to do");
			if (already_last_turn == true) {
				last_turn = true;
			} else {
				last_turn = false;
			}
			break;
		}

		return last_turn;
	}

	public void drawCard(Deck paquet) {
		paquet.getDiscard().add(paquet.getDeck().get(paquet.getDeck().size() - 1));
		paquet.getDeck().remove(paquet.getDeck().size() - 1);
	}

	public boolean isAsset(Deck paquet) {
		boolean ret = false;
		Card test;
		test = paquet.getDiscard().get(paquet.getDiscard().size() - 1);
		if (test.getRank().getOrdre() > 6) {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
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

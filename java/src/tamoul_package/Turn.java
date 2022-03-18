package tamoul_package;

import java.util.ArrayList;
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
					System.out.println("The number is not correct");
				}
			} while (choice != 0 && choice != 1 && choice != 2);
		} catch (InputMismatchException e) {
			System.out.println("The number is not correct");
			firstMove(paquet, player, already_last_turn, turn_count);
		} catch (Exception e) {
			System.out.println("The number is not correct");
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
						System.out.println("The number is not correct");
					}
				} while (choice != 0 && choice != 1);
			} catch (InputMismatchException e) {
				System.out.println("The number is not correct");
				secondMove(paquet, player, already_last_turn, turn_count);
			} catch (Exception e) {
				System.out.println("The number is not correct");
				secondMove(paquet, player, already_last_turn, turn_count);
			}

			switch (choice) {
			case 0:
				asset(paquet, Game.players);
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
					System.out.println("The number is not correct");
				}
			} while (choice != 0 && choice != 1 && choice != 2);
		} catch (InputMismatchException e) {
			System.out.println("The number is not correct");
			secondMove(paquet, player, already_last_turn, turn_count);
		} catch (Exception e) {
			System.out.println("The number is not correct");
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

	public void sevenHeight(Deck paquet,ArrayList<Player> players) {
		int choice_card = 0;
		System.out.println("what card do you want to see ? (enter a number)");
		
	}

	public void nineTen(Deck paquet,ArrayList<Player> players) {
		int choice_id_player = 0;
		int choice_card = 0;
		System.out.println("what player do you want to spie ? (enter his id)");
		choice_id_player = enterIdPlayer(players,Game.getCurrent_player());
		System.out.println("what card do you want to see ? (enter a number)");
		choice_card=enterNumberCard();
		System.out.println("the card " + choice_card + " of "+ players.get(choice_id_player).getUsername() + " is "+ players.get(choice_id_player).deck_player.get(choice_card).getRank()+" " +players.get(choice_id_player).deck_player.get(choice_card).getSuit() );
	}

	public void jackQueen(Deck paquet,ArrayList<Player> players) {
	}

	public void kingBlack(Deck paquet,ArrayList<Player> players) {
	}
	
	public int enterIdPlayer(ArrayList<Player> players,int current)
	{
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		try {
			do {
				choice = sc.nextInt();
				//ameliorer pour tester le nombre max de joueur rentree au debut avec getnbplayer
				if ((choice != 0 && choice!=1 && choice!=2 && choice!=3 && choice!=4) || (choice == current )) {
					System.out.println("the number is incorrect");
				}
			} while ((choice != 0 && choice!=1  && choice!=2 && choice!=3 && choice!=4) || choice == current);
		} catch (InputMismatchException e) {
			System.out.println("the number is incorrect");
			enterIdPlayer(players,current);
		} catch (Exception e) {
			System.out.println("the number is incorrect");
			enterIdPlayer(players,current);
		}
		return choice;
   }

	public int enterNumberCard()
	{
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		try {
			do {
				choice = sc.nextInt();
				if (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
					System.out.println("the name does not exist");
				}
			} while ( choice != 0 && choice != 1 && choice != 2 && choice != 3);
		} catch (InputMismatchException e) {
			System.out.println("The number is not correct");
			enterNumberCard();
		} catch (Exception e) {
			System.out.println("The number is not correct");
			enterNumberCard();
		}
		return choice;
	}
	
	public void asset (Deck paquet,ArrayList<Player> players )
	{
		Card last_draw;
		last_draw = paquet.getDiscard().get(paquet.getDiscard().size() - 1);
		if(last_draw.getRank().getOrdre() == 7 ||last_draw.getRank().getOrdre() == 8)
		{
			sevenHeight(paquet,players);
		}
		if(last_draw.getRank().getOrdre() == 9 ||last_draw.getRank().getOrdre() == 10)
		{
			nineTen(paquet, players);
		}
		if(last_draw.getRank().getOrdre() == 11 ||last_draw.getRank().getOrdre() == 12)
		{
			jackQueen(paquet, players);
		}
		if(last_draw.getRank().getOrdre() == 13 && (last_draw.getSuit().getOrdre() == 1 || last_draw.getSuit().getOrdre() == 4))
		{
			kingBlack(paquet, players);
		}
	}
	
}

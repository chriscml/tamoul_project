package tamoul_package;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	static int round = 0;
	static boolean play_again = true;
	static int nb_of_players;
	private static int current_player;
	static ArrayList<Player> players = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// chooseMenu();
		chooseNumberOfPlayers();
		do {
			play();
			System.out.println(" \n ------------END----------\n do you want to play again ?");
			play_again = sc.nextBoolean();
			round++;
		} while (play_again == true);
		System.out.println("See you soon :)");

	}

	private static void play() {
		Turn turn = new Turn();
		Deck paquet = new Deck();
		boolean end = false;
		boolean last_turn = false;
		int last_turn_count = 0;
		int turn_count = 0;
		// simu -----------------------------------------
		players.get(0).setUsername("chris");
		players.get(1).setUsername("bob");
		// players.get(2).setUsername("pap");
		// players.get(3).setUsername("mam");

		players.get(0).setScoreGame(2);
		players.get(1).setScoreGame(5);
		// players.get(2).setScoreGame(10);
		// players.get(3).setScoreGame(5);
		// simu -----------------------------------------

		paquet.distrib(players);
		System.out.println("\n--------distribution---------\n");
		for (int i = 0; i < 9; i++) // simuler une pioche
		{
			turn.drawCard(paquet);
		}
		System.out.println("\n ------------Remember your cards----------- \n");
		showDeckPlayerAll(players); // af : montrer les deux premieres cartes
		System.out.println("\n ------------ Start Playing------------ \n");
		setCurrent_player(firstPlay(round));
		last_turn_count = nb_of_players;
		do {
			System.out.println("\n it's " + players.get(getCurrent_player()).getUsername() + "'s turns \n");
			pointsCalculation();// pour savoir si le joueur a le droit de tamoul
			players.get(0).setScoreGame(2);
			players.get(1).setScoreGame(5);
			last_turn = turn.firstMove(paquet, players.get(getCurrent_player()), last_turn, turn_count);
			pointsCalculation();// pour calculer le nombre de points de chaque joueur après le coup
			showDeckPlayerAll(players);

			for (int i = 0; i < paquet.getDiscard().size(); i++) {
				System.out.println(paquet.getDiscard().get(i).getRank() + " " + paquet.getDiscard().get(i).getSuit());
			}

			for (int i = 0; i < getNbOfPlayers(); i++) {
				System.out.println(players.get(i).getUsername() + " : " + players.get(i).getScoreGame() + " points ");
			}

			if (last_turn == true) // test si c'est le dernier tour pour jouer encore 1 seul cycle
			{
				if (getCurrent_player() == (nb_of_players - 1)) {
					setCurrent_player(0);
				} else {
					setCurrent_player(getCurrent_player() + 1);
				}
				last_turn_count--;
				if (last_turn_count == 0) // si le dernier joueur a joué, c'est la fin de la manche
				{
					end = true;
				}
			} else {
				if (getCurrent_player() == (nb_of_players - 1)) {
					setCurrent_player(0);
				} else {
					setCurrent_player(getCurrent_player() + 1);
				}
			}
			turn_count++;
		} while (end == false);

		for (int i = 0; i < nb_of_players; i++) {
			players.get(i).setScoreAll(players.get(i).getScoreGame() + players.get(i).getScoreAll());
		}
		System.out.println("TOTAL OF POINT : \n ");
		for (int i = 0; i < getNbOfPlayers(); i++) {
			System.out.println(players.get(i).getUsername() + " : " + players.get(i).getScoreAll() + " points ");
		}
	}

	static int firstPlay(int round) {

		int random = 0, score_max = 0;
		int ret = 0;
		if (round == 0) {
			Random r = new Random();
			random = r.nextInt(getNbOfPlayers());
			ret = random;
		} else {
			for (int i = 0; i < getNbOfPlayers(); i++) {
				if (players.get(i).getScoreAll() > score_max) {
					ret = i;
					score_max = players.get(i).getScoreAll();
				}
			}
		}
		return ret;
	}

	public static int chooseNumberPlayer() {
		Scanner sc = new Scanner(System.in);
		int nb_player = 0;

		try {
			do {
				System.out.println("Choose number of player : ");
				nb_player = sc.nextInt();
				if (nb_player > 5) {
					System.out.println("too many players the number of player max is 5");
				}
				if (nb_player < 2) {
					System.out.println("You can't play alone, find friends");
				}
			} while ((nb_player < 2) | (nb_player > 5));
			System.out.println("Let's play with " + nb_player + " players");
		} catch (InputMismatchException e) {
			System.out.println("le nombre rentree est incorrecte");
			return chooseNumberPlayer();
		} catch (Exception e) {
			System.out.println("le nombre rentree est incorrecte");
			return chooseNumberPlayer();
		}
		return nb_player;
	}

	public static int getNbOfPlayers() {
		return nb_of_players;
	}

	public static void chooseNumberOfPlayers() {
		nb_of_players = chooseNumberPlayer();
		for (int i = 0; i < nb_of_players; i++) {
			players.add(new Player(null));
			players.get(i).setId(i);
			System.out.println("new slot");
		}
		System.out.println("\n");
	}

	public static void showDeckPlayer(ArrayList<Player> players) {
		for (int i = 0; i < Game.getNbOfPlayers(); i++) {
			System.out.println("deck of player : " + i + "\n");
			System.out.println(/*
								 * "--------------------------- |\n" +
								 * players.get(i).deck_player.get(0).getRank() + " " + players.get(i).
								 * deck_player.get(0).getSuit() + "   " +
								 * players.get(i).deck_player.get(1).getRank() + " " +
								 * players.get(i).deck_player.get(1).getSuit() +
								 * "  \n                           \n" +
								 */ players.get(i).deck_player.get(2).getRank() + " "
					+ players.get(i).deck_player.get(2).getSuit() + "   " + players.get(i).deck_player.get(3).getRank()
					+ " " + players.get(i).deck_player.get(3).getSuit() + " \n" + "--------------------------- |\n");
		}
	}

	public static void showDeckPlayerAll(ArrayList<Player> players) {
		for (int i = 0; i < Game.getNbOfPlayers(); i++) {
			System.out.println("deck of player : " + i + "\n");
			System.out.println("--------------------------- |\n" + players.get(i).deck_player.get(0).getRank() + " "
					+ players.get(i).deck_player.get(0).getSuit() + "   " + players.get(i).deck_player.get(1).getRank()
					+ " " + players.get(i).deck_player.get(1).getSuit() + "  \n                           \n"
					+ players.get(i).deck_player.get(2).getRank() + " " + players.get(i).deck_player.get(2).getSuit()
					+ "   " + players.get(i).deck_player.get(3).getRank() + " "
					+ players.get(i).deck_player.get(3).getSuit() + " \n" + "--------------------------- |\n");

		}
	}

	public static void pointsCalculation() {

		int deck_point = 0;
		for (int i = 0; i < nb_of_players; i++) // recuperer les points de chaque carte du deck du joueur
		{
			for (int j = 0; j < 4; j++) // recuperer les points de chaque carte du deck du joueur
			{
				if ((players.get(i).deck_player.get(j).getRank().getOrdre() == 13)
						&& (players.get(i).deck_player.get(j).getSuit().getOrdre() == 2
								|| players.get(i).deck_player.get(j).getSuit().getOrdre() == 2)) {

				} else {
					deck_point = players.get(i).deck_player.get(j).getRank().getOrdre() + deck_point;
				}
			}
			players.get(i).setScoreGame(deck_point);
			deck_point = 0;
		}
	}

	public static int getCurrent_player() {
		return current_player;
	}

	public static void setCurrent_player(int current_player) {
		Game.current_player = current_player;
	}

}

package tamoul_package;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	static int round = 0;
	static boolean play_again = true;
	static int nb_of_players;
	static ArrayList<Player> players = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// chooseMenu();
		chooseNumberOfPlayers();
		do {
			play();
			System.out.println("do you want to play again ?");
			play_again = sc.nextBoolean();
			round += 1;
		} while (play_again == true);
		System.out.println("See you soon :)");

	}

	private static void play() {
		Turn turn = new Turn();
		Deck paquet = new Deck();
		// simu -----------------------------------------
		players.get(0).setUsername("chris");
		players.get(1).setUsername("val");
		// players.get(2).setUsername("pap");
		// players.get(3).setUsername("mam");

		players.get(0).setScoreGame(30);
		players.get(1).setScoreGame(20);
		// players.get(2).setScoreGame(10);
		// players.get(3).setScoreGame(5);
		// simu -----------------------------------------

		paquet.distrib(players);
		System.out.println("\n--------distribution---------\n");
		turn.drawCard(paquet);
		turn.drawCard(paquet);
		turn.drawCard(paquet);
		turn.drawCard(paquet);
		System.out.println("\n ------------Remember your cards----------- \n");
		showDeckPlayerAll(players); // af : montrer les deux premieres cartes
		System.out.println("\n ------------ Start Playing------------ \n");
		System.out.println("first player to play: " + firstPlay(round).getUsername() + "\n");
		System.out.println("choose your moove : \n 0 : draw a card \n 1 : exchange card with the discard");
		turn.firstMoove(paquet, firstPlay(round));
		showDeckPlayerAll(players);
		for (int i = 0; i < paquet.getDiscard().size(); i++) {
			System.out.println(paquet.getDiscard().get(i).getRank() + " " + paquet.getDiscard().get(i).getSuit());
		}
		players.get(0).setScoreAll(players.get(0).getScoreGame() + players.get(0).getScoreAll());
		players.get(1).setScoreAll(players.get(1).getScoreGame() + players.get(1).getScoreAll());
		// players.get(2).setScoreAll(players.get(2).getScoreGame() +
		// players.get(2).getScoreAll());
		// players.get(3).setScoreAll(players.get(3).getScoreGame() +
		// players.get(3).getScoreAll());
		for (int i = 0; i < getNbOfPlayers(); i++) {
			System.out.println(players.get(i).getUsername() + " : " + players.get(i).getScoreAll() + " points ");
		}

	}

	static Player firstPlay(int round) {
		int random = 0, score_max = 0;
		Player ret = null;
		if (round == 0) {
			Random r = new Random();
			random = r.nextInt(nb_of_players);
			ret = players.get(random);
		} else {
			for (int i = 0; i < nb_of_players; i++) {
				if (players.get(i).getScoreGame() > score_max) {
					ret = players.get(i);
					score_max = players.get(i).getScoreGame();
				}
			}
		}
		return ret;
	}

	public static String chooseMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose menu : ");
		System.out.println("p to play");
		System.out.println("q to see the rules");
		String input;
		do {
			input = sc.nextLine();
			switch (input) {
			case "p":
				System.out.println("PLAY");
				break;
			case "q":
				System.out.println("RULES");
				break;
			}
		} while (input != "p");

		return input;
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
}

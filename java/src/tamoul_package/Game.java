package tamoul_package;

import java.util.Random;
import java.util.Scanner;

public class Game {

	static int round = 0;
	static boolean play_again = true;

	public static void main(String[] args) {
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);

		// paquet.distrib(menu);
		/*
		 * menu.players.get(0).showDeckPlayer(); menu.players.get(1).showDeckPlayer();
		 * menu.players.get(2).showDeckPlayer(); menu.players.get(3).showDeckPlayer();
		 */

		menu.players.get(0).setUsername("chris");
		menu.players.get(1).setUsername("clara");
		menu.players.get(2).setUsername("pap");
		menu.players.get(3).setUsername("mam");

		menu.players.get(0).setScoreGame(30);
		menu.players.get(1).setScoreGame(20);
		menu.players.get(0).setScoreGame(10);
		menu.players.get(1).setScoreGame(5);

		do {
			play(menu);
			System.out.println("do you want to play again ?");
			play_again = sc.nextBoolean();
			round += 1;
		} while (play_again == true);
		System.out.println("See you soon :)");
		/*
		 * for (int i = 0; i < paquet.getDeck().size(); i++) {
		 * System.out.println(paquet.getDeck().get(i).getRank() + " " +
		 * paquet.getDeck().get(i).getSuit()); }
		 * System.out.println("\n-_-_-_-__-_-_-_-_-_-_-_-_-__-_-_-_-\n");
		 * 
		 * turn.drawCard(paquet); turn.drawCard(paquet);
		 * 
		 * for (int i = 0; i < paquet.getDiscard().size(); i++) {
		 * System.out.println(paquet.getDiscard().get(i).getRank() + " " +
		 * paquet.getDiscard().get(i).getSuit()); }
		 * System.out.println("\n-_-_-_-__-_-_-_-_-_-_-_-_-__-_-_-_-\n");
		 */
	}

	static Player firstPlay(int round, Menu menu) {
		int random = 0, score_max = 0;
		Player ret = null;
		if (round == 0) {
			Random r = new Random();
			random = r.nextInt(menu.getNbOfPlayers());
			ret = menu.players.get(random);
		} else {
			for (int i = 0; i < menu.getNbOfPlayers(); i++) {
				if (menu.players.get(i).getScoreGame() > score_max) {
					ret = menu.players.get(i);
					score_max = menu.players.get(i).getScoreGame();
				}
			}
		}
		return ret;
	}

	private static void play(Menu menu) {
		int choice = 0;
		Turn turn = new Turn();
		Deck paquet = new Deck();
		paquet.distrib(menu);
		System.out.println("\n ------------ Start ------------ \n");
		System.out.println("first player to play: " + firstPlay(round, menu).getUsername() + "\n");
		System.out.println("choose your moove : \n 0 : draw a card \n 1 : exchange card with the discard");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch (choice) {
		case 0:
			System.out.println("you chose to draw a card");
			turn.drawCard(paquet);
			break;
		case 1:
			System.out.println("you chose to exchange with the discard");
			System.out.println("1");
			break;
		}
	}
}

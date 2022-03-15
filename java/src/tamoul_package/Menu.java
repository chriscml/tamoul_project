package tamoul_package;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	ArrayList<Player> players = new ArrayList<>();
	int nb_of_players = 0;

	public Menu() {
		nb_of_players = chooseNumberPlayer();
		for (int i = 0; i < nb_of_players; i++) {
			players.add(new Player(null));
			System.out.println("new slot");
		}
		System.out.println("\n");
	}

	public String chooseMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose menu : ");
		System.out.println("p to play");
		System.out.println("q to quit");
		String input = sc.nextLine();

		switch (input) {
		case "p":
			System.out.println("PLAY");
			break;
		case "q":
			System.out.println("QUIT");
			break;
		}
		return input;
	}

	public int chooseNumberPlayer() {
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

	public int getNbOfPlayers() {
		return nb_of_players;
	}
}

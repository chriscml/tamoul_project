package tamoul_package;

import java.util.ArrayList;

public class Player {
	private String username;
	private int score_game, score_all;
	ArrayList<Card> deck_player = new ArrayList<>();

	public Player(String username) {
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScoreGame() {
		return score_game;
	}

	public void setScoreGame(int score) {
		this.score_game = score;
	}

	public int getScore_all() {
		return score_all;
	}

	public void setScore_all(int score_all) {
		this.score_all = score_all;
	}

	public void showDeckPlayer() {
		System.out.println("deck of player : \n");
		System.out.println("--------------------------- |\n" + deck_player.get(0).getRank() + " "
				+ deck_player.get(0).getSuit() + "   " + deck_player.get(1).getRank() + " "
				+ deck_player.get(1).getSuit() + "  \n                           \n" + deck_player.get(2).getRank()
				+ " " + deck_player.get(2).getSuit() + "   " + deck_player.get(3).getRank() + " "
				+ deck_player.get(3).getSuit() + " \n" + "--------------------------- |\n");
	}

}
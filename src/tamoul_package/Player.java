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

	public int getScoreAll() {
		return score_all;
	}

	public void setScoreAll(int score_all) {
		this.score_all = score_all;
	}

}
package tamoul_package;

import java.util.ArrayList;

public class Player {
	private String username;
	int turn;
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

}
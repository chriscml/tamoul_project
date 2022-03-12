package tamoul_package;

public class Turn {

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

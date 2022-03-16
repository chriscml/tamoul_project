package tamoul_package;

public class Card {
	private RankEnum rank;
	private SuitEnum suit;

	public Card(RankEnum rank, SuitEnum suit) {
		this.setRank(rank);
		this.setSuit(suit);
	}

	public RankEnum getRank() {
		return rank;
	}

	public void setRank(RankEnum rank) {
		this.rank = rank;
	}

	public SuitEnum getSuit() {
		return suit;
	}

	public void setSuit(SuitEnum suit) {
		this.suit = suit;
	}
}
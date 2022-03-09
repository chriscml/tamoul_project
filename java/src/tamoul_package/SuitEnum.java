package tamoul_package;

public enum SuitEnum {
	CLUBS(1), HEARTS(2), DIAMONDS(3), SPADES(4);

	private int ordre;

	SuitEnum(int ordre) {
		this.ordre = ordre;
	}

	public int getOrdre() {
		return ordre;
	}
}
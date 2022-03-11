package tamoul_package;

//gros pc

public class Game {

	public static void main(String[] args) {
		Deck paquet = new Deck();

		/*
		 * System.out.println("MELANGE --"); paquet.shuffle(); for (int i = 0; i < 52;
		 * i++) { System.out.println(paquet.getDeck().get(i).getRank() + " " +
		 * paquet.getDeck().get(i).getSuit()); }
		 */

		Menu menu = new Menu();
		paquet.distrib(menu);

		for (int i = 0; i < paquet.getDeck().size(); i++) {
			System.out.println(paquet.getDeck().get(i).getRank() + " " + paquet.getDeck().get(i).getSuit());
		}
		System.out.println("\n-_-_-_-__-_-_-_-_-_-_-_-_-__-_-_-_-\n");

		paquet.drawCard(paquet);
		paquet.drawCard(paquet);

		for (int i = 0; i < paquet.getDiscard().size(); i++) {
			System.out.println(paquet.getDiscard().get(i).getRank() + " " + paquet.getDiscard().get(i).getSuit());
		}
		System.out.println("\n-_-_-_-__-_-_-_-_-_-_-_-_-__-_-_-_-\n");

	}

}
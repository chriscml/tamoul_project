package tamoul_package;

//gros pc

public class Game {

	public static void main(String[] args) {
		Deck paquet = new Deck();
		Player player1 = new Player("chris");
		/*
		 * for (int i = 0; i < 52; i++) {
		 * System.out.println(paquet.getDeck().get(i).getRank() + " " +
		 * paquet.getDeck().get(i).getSuit()); }
		 */

		/*
		 * System.out.println("MELANGE --"); paquet.shuffle(); for (int i = 0; i < 52;
		 * i++) { System.out.println(paquet.getDeck().get(i).getRank() + " " +
		 * paquet.getDeck().get(i).getSuit()); }
		 */

		paquet.distrib(player1);
		Menu menu = new Menu();
		// menu.choixMenu();

		System.out.print("Enter a character: ");
		// Read the char
		char ch = (char) System.in.read();
		System.out.print("\n You pressed: " + ch);

	}

}
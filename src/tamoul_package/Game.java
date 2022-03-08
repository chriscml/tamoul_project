package tamoul_package;

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
    }

}
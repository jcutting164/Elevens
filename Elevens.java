import java.util.ArrayList;
import java.util.Scanner;


public class Elevens {

	/**
	 * @param args
	 */
	static Scanner scan; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		
		Deck deck = new Deck();
		ArrayList<Card> hand = new ArrayList<Card>();
		
		// start game here
		
		fillHand(hand, deck);
		
		// end of start game
		
		while(deck.currentSize()!=0){
			for(int i = 0; i<hand.size(); i++){
				System.out.println(i+": "+hand.get(i));
				try {
					Thread.sleep(110);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			scan.next();
		}
		
		
	}
	
	
	public static void fillHand(ArrayList<Card> hand, Deck deck){
		while(hand.size()!=9 && deck.currentSize()!=0){
			hand.add(deck.getCard());
		}
	}

}

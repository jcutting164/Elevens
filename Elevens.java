import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Elevens {

	/**
	 * @param args
	 */
	static Scanner scan;
	static private boolean running;
	public static void main(String[] args) {
		running=true;
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		
		Deck deck = new Deck();
		ArrayList<Card> hand = new ArrayList<Card>();
		ArrayList<Card> picked = new ArrayList<Card>();
		deck.shuffle();
		
		// start game here
		
		fillHand(hand, deck);
		
		// end of start game


		while(running){
			System.out.println("Your hand");
			printHand(hand);


			// FIRST CHECK TO MAKE SURE THE HAND IS VALID OR THEY LOSE

			ArrayList<Card> nonFace = new ArrayList<Card>();
			ArrayList<Card> Face = new ArrayList<Card>();
			// collecting non face cards + aces to calculate 11s
			for(int i = 0; i<hand.size(); i++){
				if(hand.get(i).isFaceCard())
					Face.add(hand.get(i));
				else
					nonFace.add(hand.get(i));
			}
			// rest go to face card collection for check


			// checking for 11s
			boolean possible=false;
			for(int i = 0; i<nonFace.size(); i++){
				for(int j = 0; j<nonFace.size(); j++){
					if(i!=j){
						ArrayList<Card> temp = new ArrayList<Card>();
						temp.add(nonFace.get(i));
						temp.add(nonFace.get(j));
						if(validPick(temp)){
							possible=true;
							break;
						}
						if(possible)
							break;
					}

				}
			}


			// checking for faces rule


			if(!possible){
				for(int i = 0; i<Face.size(); i++){
					for(int j = 0; j<Face.size()-1; j++){
						if(i!=j){
							ArrayList<Card> temp = new ArrayList<Card>();
							temp.add(Face.get(i));
							temp.add(Face.get(j));
							temp.add(Face.get(j+1));
							if(validPick(temp)){
								possible=true;
								break;
							}
							if(possible)
								break;
						}

					}
				}
			}




			if(!possible){
				System.out.println("GAME OVER");
				running=false;
				break;
			}



			System.out.println("Using the indexes provided, please pick cards to try to play. Type 'n' to stop picking");
			String choice = "Nothing";
			while(!(choice.equals("n") || choice.equals("N"))){
				choice = scan.next();
				if(choice.equals("n") || choice.equals("N"))
					continue;
				else{
					picked.add(hand.remove(Integer.parseInt(choice)-1));
				}
				System.out.println("Picked cards");
				printHand(picked);
				System.out.println("Your hand");
				printHand(hand);
			}

			// end of selection process and now time for evaluation

			if(validPick(picked)){
				System.out.println("VALID PICK! New cards have been added to your hand.");
				picked.clear();
				fillHand(hand, deck);

			}else{
				System.out.println("Not valid! Your cards have been recycled into your hand.");
				int size = picked.size();
				for(int i = 0; i<size; i++){
					hand.add(picked.remove(0));
				}

			}




		}


		
		
	}
	
	
	public static void fillHand(ArrayList<Card> hand, Deck deck){
		while(hand.size()!=9 && deck.currentSize()!=0){
			hand.add(deck.getCard());
		}
	}
	public static void printHand(ArrayList<Card> hand){
			for(int i = 0; i<hand.size(); i++){
				System.out.println(i+1+": "+hand.get(i));

			}

	}

	public static boolean validPick(ArrayList<Card> picked){
		int value=0;
		boolean face=false;
		int jackCount=0;
		int queenCount=0;
		int kingCount=0;
		for(int i = 0; i<picked.size(); i++){
			if(!picked.get(i).isFaceCard()){
				value+=picked.get(i).value();
			}else{
				if(picked.get(i).getKind().contains("K")){
					kingCount++;
				}else if(picked.get(i).getKind().contains("Q")){
					queenCount++;
				}else
					jackCount++;
				face=true;
			}
		}

		if(face){
			return jackCount==1 && queenCount==1 && kingCount==1;
		}else{
			return (value==11 && picked.size()==2);

		}

	}

}

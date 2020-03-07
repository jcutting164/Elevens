import java.util.ArrayList;

import java.util.Random;


public class Deck {

	private ArrayList<Card> deck;
	private Random rand = new Random(); 
	// suit then kind
	public Deck(){
		
		deck=new ArrayList<Card>();
		deck.add(new Card("Spades","Ace"));
		deck.add(new Card("Spades","2"));
		deck.add(new Card("Spades","3"));
		deck.add(new Card("Spades","4"));
		deck.add(new Card("Spades","5"));
		deck.add(new Card("Spades","6"));
		deck.add(new Card("Spades","7"));
		deck.add(new Card("Spades","8"));
		deck.add(new Card("Spades","9"));
		deck.add(new Card("Spades","10"));
		deck.add(new Card("Spades","Jack"));
		deck.add(new Card("Spades","Queen"));
		deck.add(new Card("Spades","King"));
		
		deck.add(new Card("Hearts","Ace"));
		deck.add(new Card("Hearts","2"));
		deck.add(new Card("Hearts","3"));
		deck.add(new Card("Hearts","4"));
		deck.add(new Card("Hearts","5"));
		deck.add(new Card("Hearts","6"));
		deck.add(new Card("Hearts","7"));
		deck.add(new Card("Hearts","8"));
		deck.add(new Card("Hearts","9"));
		deck.add(new Card("Hearts","10"));
		deck.add(new Card("Hearts","Jack"));
		deck.add(new Card("Hearts","Queen"));
		deck.add(new Card("Hearts","King"));
		
		deck.add(new Card("Diamonds","Ace"));
		deck.add(new Card("Diamonds","2"));
		deck.add(new Card("Diamonds","3"));
		deck.add(new Card("Diamonds","4"));
		deck.add(new Card("Diamonds","5"));
		deck.add(new Card("Diamonds","6"));
		deck.add(new Card("Diamonds","7"));
		deck.add(new Card("Diamonds","8"));
		deck.add(new Card("Diamonds","9"));
		deck.add(new Card("Diamonds","10"));
		deck.add(new Card("Diamonds","Jack"));
		deck.add(new Card("Diamonds","Queen"));
		deck.add(new Card("Diamonds","King"));
		
		deck.add(new Card("Clubs","Ace"));
		deck.add(new Card("Clubs","2"));
		deck.add(new Card("Clubs","3"));
		deck.add(new Card("Clubs","4"));
		deck.add(new Card("Clubs","5"));
		deck.add(new Card("Clubs","6"));
		deck.add(new Card("Clubs","7"));
		deck.add(new Card("Clubs","8"));
		deck.add(new Card("Clubs","9"));
		deck.add(new Card("Clubs","10"));
		deck.add(new Card("Clubs","Jack"));
		deck.add(new Card("Clubs","Queen"));
		deck.add(new Card("Clubs","King"));

	}
	
	public Card getCard(){
		return deck.remove(0);
	}
	public void shuffle(){
		for(int i = 0; i<100; i++){
			deck.add(deck.remove((int) rand.nextInt(52) ));
		}
	}
	
	public int currentSize(){
		return deck.size();
	}
	public String toString(){
		String bob="";
		
		for(int i = 0; i<deck.size(); i++){
			bob+=deck.get(i).toString();
		}
		return bob;
	}

}

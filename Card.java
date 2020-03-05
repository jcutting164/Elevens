
public class Card {

	/**
	 * @param args
	 */
	private String suit;
	private String kind;
	
	public Card(){
		suit="Diamonds";
		kind="Ace";
	}
	
	public Card(String suit, String kind){
		this.suit=suit;
		this.kind=kind;
	}
	
	public boolean isFaceCard(){
		return (kind.equals("King") || kind.contains("Queen") || kind.contains("Jack"));
	}
	
	public boolean isAce(){
		return kind.equals("Ace");
	}
	
	public int value(){
		int value=11;
		if(!isFaceCard()){
			value= Integer.parseInt(kind);
		}else if(!isAce()){
			value= 10;
		}
		return value;
	}
	public String toString(){
		return kind+" of "+suit;
	}
	

}

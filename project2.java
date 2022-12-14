

public class project2{
	
	
	//Shuffle deck 
	public static Deck[] shuffle(Deck[] array){
		for (int i = 0; i < array.length; i++) {
    		int index = (int)(Math.random() * array.length);
    		Deck temp = array[i];
    		array[i] = array[index];
     		array[index] = temp;
    	}
    return array;

	}
	//Display deck
	public static void display(Deck[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i].card());
		}
	}
		
	//Deal cards to opponent and player.
	public static void deal(Deck[] array){
		for(int i = 0;i<1;i++){
			if(i%2 == 0){
				player= new Hand(array[0].card(), array[1].card(), array[2].card(), array[3].card());
			}else{
				opponent= new Hand(array[4].card(), array[5].card(), array[6].card(), array[7].card());
			}
		}
	}
		
	public static void main(String[] args){
		//Initialize deck you can call the deck[x].card function later
		Hand player = player;
		Hand opponent = opponent;
		int a = a;
		Deck[] deck = new Deck[52];
		String[] suits = {"Spades ♠", "Hearts ♥", "Diamonds ♦", "Clubs ♣"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		for(int i=0;i<deck.length;i++){
			String suittemporary =	suits[i/13];
			String ranktemporary =	ranks[i%13];
			deck[i]= new Deck(suittemporary,ranktemporary);
		}
		shuffle(deck);
		display(deck); 
		deal(deck);
		System.out.println(player.reveal());
		System.out.println("\n"+"\n");


		
	}

}
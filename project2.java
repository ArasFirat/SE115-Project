import java.util.Scanner;
import java.util.Random;

public class project2{
	static Hand player; 	 //the four cards on the players hand
	static Hand opponent;	 //the four cards on the opponents hand
	static int pistiCounter = 4;
	static int counter = 4;/*counts the number of cards that have been played from the deck. 
						   so we know when the deck is out of cards.*/
	static Deck[] board = new Deck[52]; /* the cards that are on the board 
										   the length may need to change 
										   depending on the situation 
										   the length is 52 so it will always be enough 
										   wouldn't matter if it was more*/
	
	static int cardtoplay;	 // is the card that will be played that round varies from 1 to 4
	static int playerpoint;  // total points of a player.
	static int opponentpoint;// total points of the opponent.


	//puts the first four cards on the deck on the board
	public static void startboard(Deck[] array){
		board[0] = array[0];
		board[1] = array[1];
		board[2] = array[2];
		board[3] = array[3];
	}
	//Shuffles deck 
	public static Deck[] shuffle(Deck[] array){
		for (int i = 0; i < array.length; i++) {
    		int index = (int)(Math.random() * array.length);
    		Deck temp = array[i];
    		array[i] = array[index];
     		array[index] = temp;
    	}
    return array;

	}
	//Displays deck
	public static void display(Deck[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i].card());
		}
	}
	
	//Deal cards to opponent and player.
	public static void deal(Deck[] array){
		

		player= new Hand(array[counter], array[counter+2], array[counter+4], array[counter+6]);
			
		opponent= new Hand(array[counter+1], array[counter+3], array[counter+5], array[counter+7]);
			
		counter += 8;
	}
	//player picks a card to play that round
	public static Deck pickcard(Hand hand,int cardtoplay){
		
			switch (cardtoplay) {
 				case 1:
    				return hand.getCARD1();
  				case 2:
    				return hand.getCARD2();
  				case 3:
    				return hand.getCARD3();
  				case 4:
    				return hand.getCARD4();
  				
			}
			return null;
	}
	//compares the last card on the pile to the newly thrown one.
	public static void compare(Deck card){
		board[pistiCounter] = card;
		
		if(pistiCounter == 0){
			pistiCounter ++;
			return;
			}

		if(card.getRANK().equals(board[pistiCounter-1].getRANK())){
			if(isempty(board)){
				//pisti
				pistiCounter = 0;
			}else{
				emptyarray(board);
				pistiCounter = 0;
			}
		}
			pistiCounter ++;
	}

	//checks if an array is empty or not
	public static boolean isempty(Deck[] array){
		for(int i = 0; i< array.length;i++){
			if(array[i] != null){
				return false;
			}
		}
		return true;
	}

	//clears out an array
	public static void emptyarray(Deck[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = null;
		}
	}



	public static void main(String[] args){
		//Initialize deck you can call the deck[x].card function later
		Scanner sc = new Scanner(System.in);
		Random r = new Random(System.currentTimeMillis());


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
		startboard(deck);
		Deck opponentcard;
		Deck playercard;
		
		//every turn of the loop represents a round of the game.
		while(counter<52){
		
			
			deal(deck);
			
			System.out.println("\n"+"\n"+"players deck:");
			
			player.display();
			
			System.out.println("\n"+"\n"+"opponents deck:");
			
			opponent.display();
			
			System.out.println("Pick a card to play.");
			cardtoplay = sc.nextInt();
			playercard = pickcard(player, cardtoplay);
			
			compare(playercard);
			cardtoplay = r.nextInt(4);
			opponentcard = pickcard(opponent, cardtoplay);
			compare(opponentcard);
		}
		System.out.println("Game Over!");


	}
}
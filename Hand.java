public class Hand{
	private Deck card1;
	private Deck card2;
	private Deck card3;
	private Deck card4;
	
	public Hand(Deck card1, Deck card2, Deck card3, Deck card4){
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
	}

	public void setCARD1(Deck a) { card1 = a; } 
	public void setCARD2(Deck a) { card2 = a; } 
	public void setCARD3(Deck a) { card3 = a; } 
	public void setCARD4(Deck a) { card4 = a; } 
	public Deck getCARD1() { return card1; } 
	public Deck getCARD2() { return card2; }
	public Deck getCARD3() { return card3; } 
	public Deck getCARD4() { return card4; }

	/* // old version of display function.
	public Deck[] reveal(){
		return new Deck[] {getCARD1(),getCARD2(),getCARD3(),getCARD4()};
	}*/

	public void display(){
		System.out.println("1: " + card1.card());
		System.out.println("2: " + card2.card());
		System.out.println("3: " + card3.card());
		System.out.println("4: " + card4.card());
	}

	public void wipe(){
		card1 = null;
		card2 = null;
		card3 = null;
		card4 = null;
	}

}
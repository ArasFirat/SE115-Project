public class Deck{
	private String suit;
	private String rank;

	public Deck(String a, String b){
		suit = a;
		rank = b;
	}
	

	public void setSUIT(String a) { suit = a; } 
	public void setRANK(String a) { rank = a; } 
	public String getSUIT() { return suit; } 
	public String getRANK() { return rank; }

	public String card(){

		return getRANK() + " of " + getSUIT();
	}
}
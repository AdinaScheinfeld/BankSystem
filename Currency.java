
public class Currency {
	
	private int cents;
	
	public Currency() {
		cents=0;
	}
	
	public Currency(int cents) {
		this.cents=cents;
	}
	
	public int getValue() {
		return cents;
	}
	
	public Currency add(Currency rhs) {
		return new Currency(cents+rhs.cents);
	}
	
	public Currency subtract(Currency rhs) {
		return new Currency(cents-rhs.cents);
	}
	
	public String toString() {
		return "$"+(cents/100)+".";
	}


}














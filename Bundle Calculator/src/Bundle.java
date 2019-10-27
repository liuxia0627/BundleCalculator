
public class Bundle implements Comparable<Bundle>{
	
	private int amount;
	
	private double price;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Bundle() {

	}
	
	public Bundle(int amount, double price) {
		this.amount = amount;
		this.price = price;
	}

	@Override
	public int compareTo(Bundle target) {
		if(this.amount>target.amount) {
			return 1;
		}else if(this.amount<target.amount) {
			return -1;
		}else {
			return 0;
		}
	}


	
	
}

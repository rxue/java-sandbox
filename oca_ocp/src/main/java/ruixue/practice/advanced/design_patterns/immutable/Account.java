package ruixue.practice.advanced.design_patterns.immutable;

public class Account {
	private String id;
	private double amount;
	public Account(String id, double amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	
	public double getAmount() {
		return amount;
	}

}

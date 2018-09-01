package ruixue.practice.advanced.design_pattern.creational.builder;

import ruixue.practice.advanced.design_pattern.immutable.Account;

public class AccountBuilder {
	private String id;
	private double amount;
	public AccountBuilder() {}
	public AccountBuilder(String id) {
		this.id = id;
	}
	public AccountBuilder add(double amount) {
		this.amount += amount;
		return this;
	}
	
	public AccountBuilder setId(String id) {
		this.id = id;
		return this;
	}
	
	public AccountBuilder minus(double amount) {
		this.amount -= amount;
		return this;
	}
	
	public AccountBuilder append(AccountBuilder accountBuilder) {
		return add(accountBuilder.toAccount().getAmount());
	}

	public Account toAccount() {
		return new Account(id, amount);
	}
}


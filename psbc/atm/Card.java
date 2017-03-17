package com.psbc.atm;

public class Card {
	String cardNo;
	String pwd;
	double balance;
	/**
	 * 存钱校验及计算
	 * @param money
	 * @return boolean
	 */
	public boolean moneyIn(double money) {
		//只能存100元的钞票
		if (money % 100 != 0.0) {
			return false;
		} else {
			balance += money;
			return true;
		}
	}
	/**
	 * 取钱校验及计算
	 * @param money
	 * @return boolean
	 */
	public boolean moneyOut(double money) {
		if (money > balance || money % 100 != 0.0) {
			return false;
		} else {
			balance -= money;
			return true;
		}
	}
}

package com.psbc.atm;

public class Card {
	String cardNo;
	String pwd;
	double balance;
	/**
	 * ��ǮУ�鼰����
	 * @param money
	 * @return boolean
	 */
	public boolean moneyIn(double money) {
		if (money % 100 != 0.0) {
			return false;
		} else {
			balance += money;
			return true;
		}
	}
	/**
	 * ȡǮУ�鼰����
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

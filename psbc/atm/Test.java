package com.psbc.atm;

public class Test {
	public static void main(String[] args) {
		System.out.println("\t     欢迎来到中国邮政储蓄银行");
		Atm atm=new Atm();
		atm.initialTestData();
		atm.checkInsertCard();
	}
}



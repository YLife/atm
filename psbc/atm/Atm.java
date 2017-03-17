package com.psbc.atm;

import java.util.Scanner;

public class Atm {
	Card cardArr[]=new Card[2];
	Card currentCard;
	/**
	 * ��ʾ���
	 */
	public void showBalance(){
		System.out.println(currentCard.balance);
	}
	/**
	 * ���
	 */
	public void deposit(){
		Scanner sc=new Scanner(System.in);
		System.out.println("����������:");
		while (true) {
			double money=sc.nextDouble();
			if(this.currentCard.moneyIn(money)) {
				System.out.println("���ɹ���");
				break;
			}else {
				System.out.println("������������������:");
			}
		}
	}
	/**
	 * ȡ��
	 */
	public void withDraw(){
		Scanner sc=new Scanner(System.in);
		System.out.println("������ȡ����:");
		while (true) {
			double money=sc.nextDouble();
			if(this.currentCard.moneyOut(money)) {
				System.out.println("�㳮�У����Եȣ�");
				break;
			}else {
				System.out.println("������������������:");
			}
		}
	}
	/**
	 * ת��
	 */
	public void trans(){
		Scanner sc=new Scanner(System.in);
		System.out.println("������ת���˺�:");
		String lendCno=sc.next();
		System.out.println("������ת�˽��:");
		double money=sc.nextDouble();
		Card toCard=null;
		for (Card card : this.cardArr) {
			if (card == null) {
				continue;
			}
			if (card.cardNo.equals(lendCno) && currentCard.cardNo!=lendCno) {
				toCard=card;
				break;
			}
		}
		if (currentCard.moneyOut(money)) {
			System.out.println("ת�˳ɹ�");
		}
		toCard.moneyIn(money);				
	}
	/**
	 * �޸�����
	 */
	public void modifyPwd(){
		Scanner sc=new Scanner(System.in);
		System.out.println("������ԭʼ����:");
		String pwd=sc.next();
		if (pwd.equals(currentCard.pwd)) {
			System.out.println("������������:");
			String pwd1=sc.next();
			System.out.println("���ٴ�ȷ��������:");
			String pwd2=sc.next();
			if (pwd1!=null&&pwd1.equals(pwd2)) {
				currentCard.pwd=pwd2;
				System.out.println("�����޸ĳɹ�");
			}else {
				System.out.println("�������벻һ��");
			}
		}else {
			System.out.println("�����������");
		}
	}
	/**
	 * У���Ѳ��뿨��
	 */
	public void checkInsertCard(){
		Scanner sc=new Scanner(System.in);
		System.out.println("�����뿨�ţ�");
		String cno = sc.next();
		System.out.println("����������:");
		boolean ok = false;
		int count = 0;
		while (true) {
			String pwd = sc.next();
			//У�鿨�ţ�����ϸ���ٸ�ֵ��currentCard
			for (Card card : this.cardArr) {
				if (card == null) {
					continue;
				}
				if (card.cardNo.equals(cno) && card.pwd.equals(pwd)) {
					ok = true;
					this.currentCard = card;
					break;
				}

			}
			if (ok) {
				showMenu();
				break;
			} else {
				count++;
				if (count < 3) {
					System.out.println("����Ŀ��Ż�������������������:");
				}else {
					System.out.println("�����������3�Σ����������ԣ�");
					break;
				}
			}
		}
	}
	/**
	 * �˵���ʾ
	 */
	public void showMenu(){
		System.out.println("----------------------------------");
		System.out.println("  1.���                                             4.��ѯ���  ");
		System.out.println("  2.ȡ��                                             5.�޸�����  ");
		System.out.println("  3.ת��                                             6.�˳�  ");
		System.out.println("----------------------------------");
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.println("��ѡ����Ҫ���еĲ���:");
		int num=sc.nextInt();
		switch (num) {
		case 1:
			deposit(); 
			showMenu();
			break;
		case 2:
			withDraw(); 
			showMenu();
			break;
		case 3:
			trans(); 
			showMenu();
			break;
		case 4:
			showBalance();
			showMenu();
			break;
		case 5:
			modifyPwd();
			showMenu();
			break;
		case 6:
			System.out.println("�˳�");
			System.out.println();
			checkInsertCard();
			break;
		default:
			System.out.println("��������");
			break;
		}
	}
	/**
	 * ��ʼ����������
	 */
	public void initialTestData(){
		//ʹ��ǰ��ʵ�������󣬷��򱨿�ָ���쳣
		this.cardArr[0] = new Card();
		cardArr[0].cardNo="123456";
		cardArr[0].pwd="123456";
		cardArr[0].balance=1000;
		
		this.cardArr[1] = new Card();
		cardArr[1].cardNo="654321";
		cardArr[1].pwd="654321";
		cardArr[1].balance=2000;
		
		
	}
}

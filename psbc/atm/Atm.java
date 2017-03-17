package com.psbc.atm;

import java.util.Scanner;

public class Atm {
	Card cardArr[]=new Card[2];
	Card currentCard;
	/**
	 * 显示余额
	 */
	public void showBalance(){
		System.out.println(currentCard.balance);
	}
	/**
	 * 存款
	 */
	public void deposit(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入存款金额:");
		while (true) {
			double money=sc.nextDouble();
			if(this.currentCard.moneyIn(money)) {
				System.out.println("存款成功！");
				break;
			}else {
				System.out.println("输入有误，请重新输入:");
			}
		}
	}
	/**
	 * 取款
	 */
	public void withDraw(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入取款金额:");
		while (true) {
			double money=sc.nextDouble();
			if(this.currentCard.moneyOut(money)) {
				System.out.println("点钞中，请稍等！");
				break;
			}else {
				System.out.println("输入有误，请重新输入:");
			}
		}
	}
	/**
	 * 转账
	 */
	public void trans(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入转账账号:");
		String lendCno=sc.next();
		System.out.println("请输入转账金额:");
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
			System.out.println("转账成功");
		}
		toCard.moneyIn(money);				
	}
	/**
	 * 修改密码
	 */
	public void modifyPwd(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入原始密码:");
		String pwd=sc.next();
		if (pwd.equals(currentCard.pwd)) {
			System.out.println("请输入新密码:");
			String pwd1=sc.next();
			System.out.println("请再次确认新密码:");
			String pwd2=sc.next();
			if (pwd1!=null&&pwd1.equals(pwd2)) {
				currentCard.pwd=pwd2;
				System.out.println("密码修改成功");
			}else {
				System.out.println("两次密码不一致");
			}
		}else {
			System.out.println("输入密码错误！");
		}
	}
	/**
	 * 校验已插入卡号
	 */
	public void checkInsertCard(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入卡号：");
		String cno = sc.next();
		System.out.println("请输入密码:");
		boolean ok = false;
		int count = 0;
		while (true) {
			String pwd = sc.next();
			//校验卡号，密码合格后，再赋值给currentCard
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
					System.out.println("输入的卡号或密码有误，请重新输入:");
				}else {
					System.out.println("输入次数超过3次，请明天再试！");
					break;
				}
			}
		}
	}
	/**
	 * 菜单显示
	 */
	public void showMenu(){
		System.out.println("----------------------------------");
		System.out.println("  1.存款                                             4.查询余额  ");
		System.out.println("  2.取款                                             5.修改密码  ");
		System.out.println("  3.转账                                             6.退出  ");
		System.out.println("----------------------------------");
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.println("请选择需要进行的操作:");
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
			System.out.println("退出");
			System.out.println();
			checkInsertCard();
			break;
		default:
			System.out.println("输入有误");
			break;
		}
	}
	/**
	 * 初始化测试数据
	 */
	public void initialTestData(){
		//使用前先实例化对象，否则报空指针异常
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

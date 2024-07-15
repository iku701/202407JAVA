package project1_2;

import java.io.Serializable;

public class Member implements Serializable {
	private String name;
	private String ssn;   // 주민번호 6자리 패스워드
	private String phone;
	private int balance;

	public void deposit(int deposit) {
		if(deposit <= 0) {
			System.out.println("1원 이상의 예금액을 입력해주세요. ");
			
		}else {
			balance += deposit;
			System.out.println("예금액 " + deposit + " 원이 입금되었습니다. ");
			
		}
	}
	
	public void withdraw(int withdraw) {
		if(withdraw <= 0) {
			System.out.println("1원 이상의 출금액을 입력해주세요. ");
			
		}else if((balance <= 0) || (balance < withdraw)){
			System.out.println("잔액이 부족합니다. ");
			
		}else {
			balance -= withdraw;
			System.out.println("출금액 " + withdraw + " 원이 출금되었습니다. ");
			
		}
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", balance=" + balance + "]";
	}

	public Member(String name, String ssn, String phone) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public Member() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
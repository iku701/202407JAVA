package project2;

public class Member {
    String name;
    String ssn; // 주민번호 6자리 패스워드
    String phone;
    int balance;

    @Override
    public String toString() {
        return "Member [name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", balance=" + balance + "]";
    }

    public Member(String name, String ssn, String phone, int balance) {
        super();
        this.name = name;
        this.ssn = ssn;
        this.phone = phone;
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("예금액 " + amount + " 원이 입금되었습니다.");
        } else {
            System.out.println("1원 이상의 예금액을 입력해주세요.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("출금액 " + amount + " 원이 출금되었습니다.");
        } else if (amount <= 0) {
            System.out.println("1원 이상의 출금액을 입력해주세요.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    
}

package BankAtmProject;
import java.util.Scanner;

public class DepositWithdraw {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		int choice = 0;
		int deposit = 0;
		int withdraw = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.println("선택> ");
			choice = scanner.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("예금액> ");
					deposit = scanner.nextInt();
					scanner.close();
					if(deposit <= 0) {
						System.out.println("1원 이상의 예금액을 입력해주세요. ");
						break;
					}else {
						balance += deposit;
						System.out.println("예금액 " + deposit + " 원이 입금되었습니다. ");
						break;
					}
					
				case 2:
					System.out.println("출금액> ");
					withdraw = scanner.nextInt();
					if(withdraw <= 0) {
						System.out.println("1원 이상의 출금액을 입력해주세요. ");
						break;
					}else if((balance <= 0) || (balance < withdraw)){
						System.out.println("잔액이 부족합니다. ");
						break;
					}else {
						balance -= withdraw;
						System.out.println("출금액 " + withdraw + " 원이 출금되었습니다. ");
						break;
					}
					
				case 3:
					System.out.println("잔고>" + balance);
					break;
				case 4:
					System.out.println("프로그램 종료");
					scanner.close();
					return;	
					
			}
		
		}
	}
}

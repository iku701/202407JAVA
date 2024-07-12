package BankAtmProject;

import java.util.Scanner;

public class LoginSystem {
    private static final String VALID_ID = "java";
    private static final String VALID_PASSWORD = "12345";

    private static boolean checkLogin(String username, String password) {
        return VALID_ID.equals(username) && VALID_PASSWORD.equals(password);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int InnerSwitch;
        int OuterSwitch;

        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> "); 
            InnerSwitch = stdIn.nextInt();

            switch (InnerSwitch) {
                case 1:
                    System.out.print("아이디를 입력하세요: ");
                    String id = stdIn.next();

                    System.out.print("비밀번호를 입력하세요: ");
                    String password = stdIn.next();

                    if (checkLogin(id, password)) {
                        System.out.println("로그인 성공");
                    } else {
                        System.out.println("패스워드가 틀렸습니다.");
                    }
                    break;

                case 2:
                    System.out.println("[필수 정보 입력]");

                    System.out.print("1. 이름: ");
                    String name = stdIn.next();

                    System.out.print("2. 주민번호 앞 6자리: ");
                    int SecurityNum = stdIn.nextInt();

                    System.out.print("3. 전화번호: ");
                    String PhoneNum = stdIn.next();

                    System.out.println("[입력된 내용]");

                    System.out.println("1. 이름: " + name);
                    System.out.println("2. 주민번호 앞 6자리: " + SecurityNum);
                    System.out.println("3. 전화번호: " + PhoneNum);

                    break;

                case 3:
                    int balance = 0;
                    int deposit;
                    int withdraw;
                    boolean exitInnerLoop = false;

                    while (!exitInnerLoop) {
                        System.out.println("-----------------------------");
                        System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
                        System.out.println("-----------------------------");
                        System.out.print("선택> ");
                        OuterSwitch = stdIn.nextInt();

                        switch (OuterSwitch) {
                            case 1:
                                System.out.print("예금액> ");
                                deposit = stdIn.nextInt();

                                if (deposit <= 0) {
                                    System.out.println("1원 이상의 예금액을 입력해주세요.");
                                } else {
                                    balance += deposit;
                                    System.out.println("예금액 " + deposit + " 원이 입금되었습니다.");
                                }
                                break;

                            case 2:
                                System.out.print("출금액> ");
                                withdraw = stdIn.nextInt();
                                if (withdraw <= 0) {
                                    System.out.println("1원 이상의 출금액을 입력해주세요.");
                                } else if ((balance <= 0) || (balance < withdraw)) {
                                    System.out.println("잔액이 부족합니다.");
                                } else {
                                    balance -= withdraw;
                                    System.out.println("출금액 " + withdraw + " 원이 출금되었습니다.");
                                }
                                break;

                            case 3:
                                System.out.println("잔고> " + balance);
                                break;

                            case 4:
                                System.out.println("예금/출금 종료");
                                exitInnerLoop = true;
                                break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("프로그램 전체 종료");
                    return;
            }
        }
    }
}

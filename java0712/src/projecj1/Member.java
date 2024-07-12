package projecj1;

public class Member {
	String name;
	String SecurityNum; //주민번호 6자리
	String PhoneNum;
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", SecurityNum=" + SecurityNum + ", PhoneNum=" + PhoneNum + "]";
	}

	public Member(String name, String SecurityNum, String PhoneNum) {
		super();
		this.name = name;
		this.SecurityNum = SecurityNum;
		this.PhoneNum = PhoneNum;
	}
	
	public Member() {
		
	}

	
	
}

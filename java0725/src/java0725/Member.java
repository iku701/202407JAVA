package java0725;

//p.495
public class Member {
	String id;

	public Member(String id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Member) { 	//object 가 member의 부모일때만 가능
			Member member = (Member) obj;
			if (id.equals(member.id)) { 	//오브젝트 타입이기때문에 강제형변환 필수
				return true;
			}
		}
		return false;
		
		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}

	
	
}

package drive;

public class Person {
	private Role role;		//doti 메서드를 쓰기위해서 사용(getter setter 필요)
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void doIt() {
		role.doIt();
	}
	
}

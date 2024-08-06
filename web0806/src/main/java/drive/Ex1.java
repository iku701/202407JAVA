package drive;

import java.util.List;

import dept.DeptDAO;
import dept.DeptDTO;

public class Ex1 {
	public static void main(String[] args) {
		DeptDAO dap = new DeptDAO();
		List<DeptDTO> list = dap.getDeptList();
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}
		
	}
}

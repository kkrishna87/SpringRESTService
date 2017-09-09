package krishna.imcs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import krishna.imcs.beans.Department;
@Service
public class DepartmentService implements DepartmentServiceInterface {

	List<Department> deptlist = new ArrayList();

	@Override
	public Department getDepartment(int deptId) {
		deptlist = getDeptList();
		for (Department d : deptlist) {
			if (d.getDeptID() == deptId) {
				return d;
			}
		}
		return null;
	}

	@Override
	public List<Department> getDeptList() {
		deptlist.add(new Department(11, "ComputerScience"));
		deptlist.add(new Department(12, "EEE"));
		deptlist.add(new Department(12, "Electrical"));
		return deptlist;
	}

}

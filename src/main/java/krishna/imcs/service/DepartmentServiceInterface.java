package krishna.imcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import krishna.imcs.beans.Department;
@Service
public interface DepartmentServiceInterface {

	Department getDepartment(int deptId);

	List<Department> getDeptList();

}

package krishna.imcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import krishna.imcs.beans.Employee;

@Service
public interface EmployeeServiceInterface {
	
	boolean createEmployee( Employee employee);
	
	Employee findEmployee(int id);
	
	boolean updateEmployee(Employee employee);
	
	boolean deleteEmployee(int id);

	List<Employee> displayAll();

}

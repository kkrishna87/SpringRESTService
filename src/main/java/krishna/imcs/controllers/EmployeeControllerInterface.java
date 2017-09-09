	package krishna.imcs.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import krishna.imcs.beans.Employee;


public interface EmployeeControllerInterface {

	public ResponseEntity<?> createEmployee(@RequestBody Employee employee);

	public ResponseEntity<?> findEmployee(@PathVariable int EmpNum);

	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee);

	public ResponseEntity<?> deleteEmployee(@PathVariable int EmpNum);

	public List<Employee> getEmployee();

}

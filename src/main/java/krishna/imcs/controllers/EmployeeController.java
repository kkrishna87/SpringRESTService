package krishna.imcs.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import krishna.imcs.beans.Employee;
import krishna.imcs.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/Employee")
public class EmployeeController implements EmployeeControllerInterface {

	@Autowired
	EmployeeServiceInterface serviceInterface;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Employee> getEmployee() {
		return serviceInterface.displayAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		boolean newInstance = false;
		try {
			newInstance = serviceInterface.createEmployee(employee);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(newInstance, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{EmpNum}", method = RequestMethod.GET)
	public ResponseEntity<?> findEmployee(@PathVariable int EmpNum) {
		Employee employee = serviceInterface.findEmployee(EmpNum);
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { "application/json" })
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			boolean flag = serviceInterface.updateEmployee(employee);

			if (flag == false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(flag, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{EmpNum}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable int EmpNum) {
		boolean flag = serviceInterface.deleteEmployee(EmpNum);
		if (flag == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}

}

package krishna.imcs.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface DepartmentControllerInterface {

	public ResponseEntity<?> getEmployee(@PathVariable int deptId);
	
	public ResponseEntity<?> getEmployee();
}

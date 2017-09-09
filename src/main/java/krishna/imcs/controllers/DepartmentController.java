package krishna.imcs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import krishna.imcs.beans.Department;
import krishna.imcs.service.DepartmentServiceInterface;

@RestController
@RequestMapping("/Department")
public class DepartmentController implements DepartmentControllerInterface {

	@Autowired
	DepartmentServiceInterface deptserviceInterface;

	@RequestMapping(value = "/{DeptID}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getEmployee(@PathVariable int DeptID) {
		Department department = deptserviceInterface.getDepartment(DeptID);
		if (department == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(department, HttpStatus.ACCEPTED);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployee() {
		List<Department> deptList = deptserviceInterface.getDeptList();
		return new ResponseEntity<List<Department>>(deptList, HttpStatus.OK);
	}
}

package demo.restservices;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MySimpleController {

	@GetMapping(value="/employee1", produces={"application/json","application/xml"})
	public Employee getEmp1() {
		return new Employee("1", "John Smith", 100000);
	}

	@GetMapping(value="/employee2", produces={"application/json","application/xml"})
	public Employee getEmp2() {
		return new Employee("2", "Jane Evans", 200000);
	}	
	
	@GetMapping(value="/employeePv/{id}", produces={"application/json","application/xml"})
	public Employee getEmpViaPathVariable(@PathVariable String id) {
		return new Employee(id);
	}
	
	@GetMapping(value="/employeeRp", produces={"application/json","application/xml"})
	public Employee getEmpViaRequestParam(@RequestParam(value="id", required=false, defaultValue="1234") String id) {
		return new Employee(id);
	}

	@ModelAttribute("offices")
	public List<Office> populateOffices() {
		List<Office> offices = new ArrayList<Office>();
		offices.add(new Office("England", "London"));
		offices.add(new Office("France",  "Paris"));
		offices.add(new Office("USA",     "New York"));
		offices.add(new Office("Norway",  "Tromso"));
		offices.add(new Office("Wales",   "Swansea :-)"));
		return offices;
	}
	
	@GetMapping(value="/office", produces={"application/json","application/xml"})
	@SuppressWarnings("unchecked")
	public Office getOffice(@RequestParam(value="index", required=false, defaultValue="0") int index, ModelMap model) {
	
		List<Office> offices = (List<Office>)model.get("offices");
		if (index < 0 || index >= offices.size())
			index = 0;
	
		return offices.get(index);
	}
	
	@GetMapping(value="/offices", produces={"application/json","application/xml"})
	@SuppressWarnings("unchecked")
	public List<Office> getAllOffices(ModelMap model) {
		return (List<Office>)model.get("offices");
	}
}

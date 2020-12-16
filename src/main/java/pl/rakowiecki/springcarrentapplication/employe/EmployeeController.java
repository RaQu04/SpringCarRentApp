package pl.rakowiecki.springcarrentapplication.employe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) throws URISyntaxException {
        Long employeeId = employeeService.createEmployeeEntityFromEmployeeAndGetId(employee);

        return ResponseEntity
                .created(new URI("/employee/" + employeeId))
                .build();
    }

    @GetMapping("/employee")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

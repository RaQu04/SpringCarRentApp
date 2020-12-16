package pl.rakowiecki.springcarrentapplication.employe;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Long createEmployeeEntityFromEmployeeAndGetId(Employee employee) {
        final EmployeeEntity employeeEntity = employeeRepository.save(new EmployeeEntity(null, employee.getName(), employee.getSurname(), employee.getLevel()));
        return employeeEntity.getId();
    }

    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .map(Employee::fromEmployeeEntity);
    }

    public List<EmployeeEntity> getEmployeesByLevel(Level level) {
        return employeeRepository.findAllByLevel(level);
    }

}

package pl.rakowiecki.springcarrentapplication.employe;

import lombok.Value;

@Value
public class Employee {

    String name;
    String surname;
    Level level;

    public static Employee fromEmployeeEntity(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getName(), employeeEntity.getSurname(), employeeEntity.getLevel());
    }
}

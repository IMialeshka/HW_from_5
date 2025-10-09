package by.vadarod.homework.service;


import by.vadarod.homework.entity.Employee;
import by.vadarod.homework.repository.EmployeeRepository;


public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    public void addEmployeeService(Employee employee) {
        employeeRepository.addEmployee(employee);

    }

}

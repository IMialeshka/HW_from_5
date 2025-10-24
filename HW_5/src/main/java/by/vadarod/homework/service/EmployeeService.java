package by.vadarod.homework.service;


import by.vadarod.homework.entity.Employee;
import by.vadarod.homework.repository.EmployeeRepository;

import java.util.List;


public class EmployeeService {
    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    public void addEmployeeService(Employee employee) {
        employeeRepository.addEmployee(employee);

    }

    public double findMaxSalary () {
        return employeeRepository.findMaxSalary();
    }

    public double findMinSalary () {
        return employeeRepository.findMinSalary();
    }

    public double findSalaryPeriod(int dayCount) {
        return Math.round((employeeRepository.findSalarySumMonth()/30)*dayCount*100.00)/100.00;
    }

    public List<Employee> findAllEmployeesService() {
        return employeeRepository.findAllEmployees();
    }

}

package com.skdev.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Employee API is working");
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee body){
        Employee employee = new Employee();
        employee.setName(body.getName());
        employee.setDepartment(body.getDepartment());
        employee.setEmployee_income(body.getEmployee_income());
        return employeeRepository.save(employee);
    }

}

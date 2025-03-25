package com.springboot.productmanagement.controller;

import com.springboot.productmanagement.entity.Employee;
import com.springboot.productmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/id")
    public Optional<Employee>getEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @DeleteMapping
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/by-salary")
    public List<Employee> getEmployeesBySalary(@PathVariable Long salary) {
        return employeeService.fetchEmployees(salary);
    }

}

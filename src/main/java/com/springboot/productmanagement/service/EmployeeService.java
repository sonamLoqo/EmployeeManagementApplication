package com.springboot.productmanagement.service;

import com.springboot.productmanagement.entity.Employee;
import com.springboot.productmanagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public Optional<Employee>getEmployeeById(String employeeId) {
        return employeeRepo.findById(employeeId);
    }
    public Iterable<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public void deleteEmployee(String employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    public List<Employee> fetchEmployees(Long salary) {
        Sort sortBy = Sort.by(Sort.Order.asc("salary"));
        Pageable pageable = PageRequest.of(0, 10, sortBy);

        List<Employee> list = employeeRepo.findBySalary(20000L, pageable).getContent();
        list.forEach(emp -> System.out.println(emp.getName() + ": " + emp.getSalary()));
        return list;
    }

}

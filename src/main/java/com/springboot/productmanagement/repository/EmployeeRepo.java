package com.springboot.productmanagement.repository;

import com.springboot.productmanagement.entity.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepo extends ElasticsearchRepository<Employee, String> {
    //here I fetch employees with basis of salary
    List<Employee>findBySalaryBetween(Long startingSalary, Long endingSalary);
    //Pagination and sorting implementation
    @Query("{\"match\": {\"salary\": {\"query\": ?0}}}")
    Page<Employee> findBySalary(Long salary, Pageable pageable);

}

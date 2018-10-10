package com.example.payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

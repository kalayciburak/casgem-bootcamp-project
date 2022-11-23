package com.torukobyte.bootcampproject.repository.abstracts;

import com.torukobyte.bootcampproject.entities.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

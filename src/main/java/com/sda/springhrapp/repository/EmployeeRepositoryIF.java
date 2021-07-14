package com.sda.springhrapp.repository;

import com.sda.springhrapp.model.Employee;
import com.sda.springhrapp.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeRepositoryIF extends CrudRepository<Employee, Integer> {
    Integer deleteEmployeeBySalaryIsBetween(Integer x, Integer y);
    List<Employee> findEmployeeByProjectsEquals(Set<Project> projectSet);
}

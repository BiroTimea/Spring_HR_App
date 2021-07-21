package com.sda.springhrapp.repository;

import com.sda.springhrapp.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepositoryIf extends CrudRepository<Employee, Integer> {
    List<Employee> deleteEmployeeBySalaryIsBetween(Integer x, Integer y);

    List<Employee> findAll();

    List<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findEmployeeByEmailOrPhoneNumber(String email, String phoneNumber);

    List<Employee> findAllByDepartment_Id(Integer id);

    List<Employee> findAllEmployeesByDepartment_Name(String departmentName);

}

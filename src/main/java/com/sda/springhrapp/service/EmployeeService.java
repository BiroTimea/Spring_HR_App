package com.sda.springhrapp.service;

import com.sda.springhrapp.model.Employee;
import com.sda.springhrapp.repository.EmployeeRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepositoryIF employeeRepositoryIF;

    public Employee saveEmployee(Employee employee) {
        employeeRepositoryIF.save(employee);
        log.info("Employee has been saved!");
        return employee;
    }

    public Integer deleteEmployeeWithSalariesBetween(Integer x, Integer y) {
        return employeeRepositoryIF.deleteEmployeeBySalaryIsBetween(x, y);
    }

}

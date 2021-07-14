package com.sda.springhrapp.service;

import com.sda.springhrapp.model.Department;
import com.sda.springhrapp.model.Employee;
import com.sda.springhrapp.repository.DepartmentRepositoryIF;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepositoryIF departmentRepositoryIF;

    public Department saveDepartment(Department department){
        departmentRepositoryIF.save(department);
        log.info("Department saved successfully!");
        return department;
    }

    public Integer deleteById(Integer id){
        Integer department = departmentRepositoryIF.deleteDepartmentById(id);
        if (department ==0){
            log.info("Department with ID" + id + "was deleted!");
        } else {
            log.warn("The department didn't get deleted!");
        }
        return department;
    }

    public Integer deleteByName(String name){
        Integer department = departmentRepositoryIF.deleteDepartmentByName(name);
        if (department ==0){
            log.info("Department with name" + name + "was deleted!");
        } else {
            log.warn("The department didn't get deleted!");
        }
        return department;
    }

    public Department findDepartmentWithEmployeeList(List<Employee> employeeList){
         return departmentRepositoryIF.findDepartmentByEmployeeList(employeeList);
    }


}

package com.sda.springhrapp.repository;

import com.sda.springhrapp.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DepartmentRepositoryIF extends CrudRepository<Department, Integer> {
    Integer deleteDepartmentByName(String name);
    Integer deleteDepartmentById(Integer id);
    List<Department> findAll();
}

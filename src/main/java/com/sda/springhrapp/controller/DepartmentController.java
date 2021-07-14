package com.sda.springhrapp.controller;

import com.sda.springhrapp.model.Department;
import com.sda.springhrapp.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@Slf4j
@RequestMapping(value = "/humanresources/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // TODO: 14/07/2021 findAll, findById, findByName

    //  @GetMapping("/departments")
    //  public ResponseEntity<String> findDepartmentsWithEmployees(@RequestBody List<Employee> departmentList){
    //      Department department = departmentService.findDepartmentWithEmployeeList(departmentList);
    //      log.info("Department found!");
    //      log.debug(departmentService.toString());
    //      return new ResponseEntity<>("Department found " + department, HttpStatus.OK);
    //  }

    @PostMapping("/departments")
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        Department response = departmentService.saveDepartment(department);
        if (response.getName() == null || response.getName().isEmpty()) {
            log.warn("Something went wrong, department not saved!");
            return new ResponseEntity<>("Something went wrong, the department was saved but it's empty!", HttpStatus.BAD_REQUEST);
        } else {
            log.info(department.toString());
            return new ResponseEntity<>(response.toString(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/departments")
    @Transactional
    public ResponseEntity<String> deleteDepartment(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "id", required = false) Integer id) {

        Integer response ;
        if ((!(isBlank(name)) && id != null) || (isBlank(name) && id == null)) {
            throw new IllegalArgumentException("Please provide one of the options. Username or Id.");
        } else if (!isBlank(name)) {
            response = departmentService.deleteByName(name);
        } else {
            response = departmentService.deleteById(id);
        }
        if ( response == 1) {
            return new ResponseEntity<>("Department has been removed.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("The requested department does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isEmpty();
    }

    @PutMapping("/departments")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        Department updateDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(updateDepartment);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

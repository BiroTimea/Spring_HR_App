package com.sda.springhrapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@ToString
@Entity
@Table(name = "departments") 
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;


}

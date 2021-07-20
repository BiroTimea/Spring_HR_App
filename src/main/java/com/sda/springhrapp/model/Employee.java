package com.sda.springhrapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private java.sql.Date dateOfBirth;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private Integer salary;

    @OneToOne()
    @JoinColumn(name = "account_id") // account_id is from the database.
    private Account account;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    @ManyToMany
    @JoinTable(name = "employees_project",
            joinColumns = {@JoinColumn(name = "employee_Id")},
            inverseJoinColumns = {@JoinColumn(name = "project_Id")})
    private Set<Project> projects = new HashSet<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}


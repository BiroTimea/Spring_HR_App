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
@Entity()
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private double budget;
    @Transient
    private String currency;
    @Enumerated(EnumType.STRING)
    @Column
    private ProjectType projectType;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<Employee> employees= new HashSet<>();


}

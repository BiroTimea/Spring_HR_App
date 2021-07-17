package com.sda.springhrapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  Integer id;
    @Column
    private Date creationDate;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Employee employee;

}

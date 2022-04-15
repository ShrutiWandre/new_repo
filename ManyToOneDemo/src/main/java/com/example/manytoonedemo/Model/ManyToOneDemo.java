package com.example.manytoonedemo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ManyToOneDemo")

public class ManyToOneDemo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cust_no")
    private Long cust_no;

    @Column(name = "cust_name")
    private String cust_name;

    @ManyToOne
    Currency currency;

    @ManyToOne
    AccountClass accountClass;

}

package com.example.jpa.hibernate.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;
    public FullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.salary = salary;
    }


}

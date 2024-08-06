package com.example.jpa.hibernate.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    Employee(String name){
        this.name = name;
    }

    public String toString(){
        return String.format("Employee[%s]" , name);
    }
}

package com.example.jpa.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passport {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    @OneToOne(mappedBy = "passport")
    private Student student;
    public Passport(String number){
        this.number = number;
    }
    public String toString(){
        return String.format("passport [%s]", number);
    }
}

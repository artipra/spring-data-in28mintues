package com.example.jpa.hibernate.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class PartTimeEmployee extends Employee {

   private BigDecimal hourlyWage;

   public PartTimeEmployee(String name, BigDecimal hourlyWage){
      super(name);
      this.hourlyWage = hourlyWage;
   }


}

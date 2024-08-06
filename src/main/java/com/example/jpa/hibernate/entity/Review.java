package com.example.jpa.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;
    @ManyToOne
    private Course course;

    public Review(String rating , String description){
        this.description = description;
        this.rating = rating;

    }
    public String toString(){
        return String.format("Review [%s  %s]", rating, description);
    }
}

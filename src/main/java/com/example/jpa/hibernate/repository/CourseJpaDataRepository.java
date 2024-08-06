package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CourseJpaDataRepository extends JpaRepository<Course,Long> {


}

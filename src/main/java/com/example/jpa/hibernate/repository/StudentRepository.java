package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Passport;
import com.example.jpa.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Repository
@Transactional
public class StudentRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(long id){
        return em.find(Student.class, id);
    }

//    public List<Student> findAll(){
//        TypedQuery<Student> Students = em.createQuery("find_all",Student.class)
//        return Students.getResultList();
//    }

    public Student save(Student Student){
       if(Student.getId() == null) em.persist(Student);
       else em.merge(Student);
       return Student;
    }
    public void deleteById(long id){
        Student Student = findById(id);
         em.remove(Student);
    }

    // within the transaction entity is tracked
    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z1526398");
        em.persist(passport);
        Student student = new Student("lane");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertStudentAndCourse(){
        Student student = new Student("MICK");
        Course course = new Course("Microservice in 50 step with arti");
        student.setCourses(Arrays.asList(course));
        course.setStudents(Arrays.asList(student));

        em.persist(student);
        em.persist(course);
    }
}

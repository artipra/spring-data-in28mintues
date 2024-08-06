package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(long id){
        return em.find(Course.class, id);
    }

//    public List<Course> findAll(){
//        TypedQuery<Course> courses = em.createQuery("find_all",Course.class)
//        return courses.getResultList();
//    }

    public Course save(Course course){
       if(course.getId() == null) em.persist(course);
       else em.merge(course);
       return course;
    }
    public void deleteById(long id){
        Course course = findById(id);
         em.remove(course);
    }

    // within the transaction entity is tracked
    public void playWithEntityManager(){
        Course course = new Course("web service in 50 steps");
        em.persist(course);

        Course course2 = new Course("Angular js in 50 steps");
        em.persist(course2);

        //em.close();
        logger.info("entity manager is closed {} ",em.isOpen());

        course.setName("web service in 100 steps");
        course2.setName("Angular js in 100 steps");
        em.flush();
    }
    public void addReviewsHardForCourse(){
     Course course = findById(10003);
     logger.info("course reviews --->  {} ", course.getReviews());
     Review r1 = new Review("5","awesome");
     Review r2 = new Review("4","awesome awesome");
     course.addReview(r1);course.addReview(r2);
     r1.setCourse(course);r2.setCourse(course);
     em.persist(r1);em.persist(r2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        logger.info("course reviews generic method --->  {} ", course.getReviews());
        for(Review r : reviews){
            course.addReview(r);
            r.setCourse(course);
            em.persist(r);
        }
    }
}

package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Review;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CourseRepositoryTest {

	Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);


	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EntityManager em;

	@Test
	void findBy_id() {
		Course course = courseRepository.findById(1001);
		assertEquals("learn aws with arti", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteBy_id() {
		courseRepository.deleteById(1000);
		assertNull(courseRepository.findById(1000));
	}

	@Test
	@DirtiesContext
	void saveBy_id() {
		Course course = courseRepository.findById(1001);
		assertEquals("learn aws with arti", course.getName());

		course.setName("learn aws with arti - updated");
		courseRepository.save(course);
		assertEquals("learn aws with arti - updated", course.getName());
	}

	@Test
	@Transactional
	public void retrieveReviewForCourse(){
		Course course = courseRepository.findById(10003L);
	//	logger.info("{} ", course.getReviews());
	}


	@Test
	@Transactional
	public void retrieveCourseForReview(){
		Review review = em.find(Review.class,50004L);
		//	logger.info("{} ", course.getReviews());
	}

	@Test
	@Transactional
	public void findBy_firstLevelCache() {
		Course course = courseRepository.findById(10001L);
		logger.info("course retrieved first time -> {} ", course);
		Course course1 = courseRepository.findById(10001L);
		logger.info("course retrieved second time -> {} ", course);
	}

}




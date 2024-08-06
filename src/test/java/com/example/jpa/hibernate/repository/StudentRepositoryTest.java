package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Student;
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
class StudentRepositoryTest {

	Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void getStudentWithPassport() {
		Student student = em.find(Student.class,20001L);
		logger.info("student {} -> " ,student);
		logger.info("student passport detail {} -> " ,student.getPassport());
	}

//	@Test
//	@DirtiesContext
//	void deleteBy_id() {
//		courseRepository.deleteById(1000);
//		assertNull(courseRepository.findById(1000));
//	}
//
//	@Test
//	@DirtiesContext
//	void saveBy_id() {
//		Course course = courseRepository.findById(1001);
//		assertEquals("learn aws with arti", course.getName());
//
//		course.setName("learn aws with arti - updated");
//		courseRepository.save(course);
//		assertEquals("learn aws with arti - updated", course.getName());
//	}


	@Test@Transactional
	public void retrieveStudentAndCourses(){
		Student student = em.find(Student.class , 20001L);
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}

}




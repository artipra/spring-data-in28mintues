package com.example.jpa.hibernate;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.FullTimeEmployee;
import com.example.jpa.hibernate.entity.PartTimeEmployee;
import com.example.jpa.hibernate.entity.Review;
import com.example.jpa.hibernate.repository.CourseRepository;
import com.example.jpa.hibernate.repository.EmployeeRepository;
import com.example.jpa.hibernate.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

public class JpaHibernateApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(1000);
//		logger.info("course {} ", course);
		//		studentRepository.saveStudentWithPassport();
//		studentRepository.insertStudentAndCourse();
//		List<Review> reviews = new ArrayList<>();
//		Review r1 = new Review("5","awesome");
//		Review r2 = new Review("4","awesome awesome");
//        reviews.add(r1);reviews.add(r2);
//		courseRepository.addReviewsForCourse(10003L,reviews);

		employeeRepository.insert(
				new PartTimeEmployee("jill", new BigDecimal("50")));
		employeeRepository.insert(
				new FullTimeEmployee("jack", new BigDecimal("100")));
		logger.info("All Employee -> {} ", employeeRepository.getAllEmployees());
	}
}

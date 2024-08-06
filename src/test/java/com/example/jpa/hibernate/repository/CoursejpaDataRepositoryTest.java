package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Review;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoursejpaDataRepositoryTest {

	Logger logger = LoggerFactory.getLogger(CoursejpaDataRepositoryTest.class);


	 @Autowired
	CourseJpaDataRepository courseJpaDataRepository;

	@Test
	public void findById(){
	Optional<Course> courseOptional = courseJpaDataRepository.findById(10001L);
	assertTrue(courseOptional.isPresent());
	}


	@Test
	public void findById_course_not_present(){
		Optional<Course> courseOptional = courseJpaDataRepository.findById(30001L);
		assertFalse(courseOptional.isPresent());
	}

	@Test
	public void playingAroundWithSpringDataRepository(){
		Course course = new Course("Content writing with ARTI");
		courseJpaDataRepository.save(course);

		course.setName("Content creation with ARTI");
		courseJpaDataRepository.save(course);

		logger.info("courses -> {} ",courseJpaDataRepository.findAll());
		logger.info("courses count -> {} ",courseJpaDataRepository.count());

	}

	@Test
	public void sort(){
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		logger.info("sorted courses -> {} ",courseJpaDataRepository.findAll(sort));
		logger.info("courses count -> {} ",courseJpaDataRepository.count());
	}


	@Test
	public void pagination(){
		PageRequest pageRequest = PageRequest.of(0,2);

		Page<Course> firstPage =  courseJpaDataRepository.findAll(pageRequest);

		logger.info("First page -> {} ",firstPage.getContent());

		Pageable secondPage = firstPage.nextPageable();
		logger.info("second page -> {} ",courseJpaDataRepository.findAll(secondPage).getContent());

		logger.info("courses count -> {} ",courseJpaDataRepository.count());
	}

}




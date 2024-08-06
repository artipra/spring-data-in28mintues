package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CriteriaQueryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void criteria_basic() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> from = cq.from(Course.class);

		TypedQuery<Course> query = em.createQuery(cq.select(from));
		List<Course> resultList  = query.getResultList();
		logger.info("Select c from Course c jpql basic {} ", resultList);
//		[Course [learn aws with arti], Course [learn gardening with arti], Course [learn jpa with arti]]
	}

	@Test
	void criteria_basic_where() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> from = cq.from(Course.class);
		Predicate name = cb.like(from.get("name"), "%aws%");
		cq.where(name);
		TypedQuery<Course> query = em.createQuery(cq.select(from));
		List<Course> resultList  = query.getResultList();
		logger.info("Select c from Course c where {} ", resultList);
	}

	@Test
	void criteria_basic_student_isempty() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> from = cq.from(Course.class);
		Predicate studentIsEmpty = cb.isEmpty(from.get("students"));
		cq.where(studentIsEmpty);
		TypedQuery<Course> query = em.createQuery(cq.select(from));
		List<Course> resultList  = query.getResultList();
		logger.info("Select c from Course c where {} ", resultList);
	}
}




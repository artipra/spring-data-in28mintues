package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void jpql_basic() {
		Query query = em.createQuery("Select c from Course c");
		logger.info("Select c from Course c jpql basic {} ", query.getResultList());
	}

	@Test
	void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		logger.info(" Select c from Course c jpql type {} ", query.getResultList());
	}

	@Test
	void jpql_where() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%100 steps'", Course.class);
		logger.info("Select c from Course c where name like % 100 steps {} ", query.getResultList());
	}





}




package com.example.jpa.hibernate.repository;

import com.example.jpa.hibernate.entity.Employee;
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
public class EmployeeRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee){
        em.persist(employee);
    }
    public List<Employee> getAllEmployees(){
        TypedQuery<Employee> employee =
                em.createQuery("select e from Employee e", Employee.class);
        return employee.getResultList();
    }
}

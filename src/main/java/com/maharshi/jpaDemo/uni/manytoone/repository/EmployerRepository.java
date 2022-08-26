package com.maharshi.jpaDemo.uni.manytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maharshi.jpaDemo.uni.manytoone.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

}

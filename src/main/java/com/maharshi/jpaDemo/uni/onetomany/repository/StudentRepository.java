package com.maharshi.jpaDemo.uni.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maharshi.jpaDemo.uni.onetomany.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

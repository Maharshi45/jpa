package com.maharshi.jpaDemo.bi.manytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maharshi.jpaDemo.bi.manytoone.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}

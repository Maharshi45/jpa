package com.maharshi.jpaDemo.bi.manytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.jpaDemo.bi.manytoone.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}

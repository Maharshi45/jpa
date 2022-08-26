package com.maharshi.jpaDemo.uni.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maharshi.jpaDemo.uni.onetomany.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

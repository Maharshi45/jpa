package com.maharshi.jpaDemo.uni.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.jpaDemo.uni.onetoone.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}

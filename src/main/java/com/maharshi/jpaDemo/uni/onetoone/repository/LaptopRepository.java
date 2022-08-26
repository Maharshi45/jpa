package com.maharshi.jpaDemo.uni.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.jpaDemo.uni.onetoone.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}

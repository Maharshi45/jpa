package com.maharshi.jpaDemo.bi.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.jpaDemo.bi.onetoone.model.Husband;

@Repository
public interface HusbandRepository extends JpaRepository<Husband, Integer> {

}

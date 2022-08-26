package com.maharshi.jpaDemo.uni.onetoone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer laptopId;
	private Integer ram;

	public Integer getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", ram=" + ram + "]";
	}

}

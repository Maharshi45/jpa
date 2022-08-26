package com.maharshi.jpaDemo.bi.onetoone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wife {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToOne(mappedBy = "wife")
	private Husband husband;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return "Wife [id=" + id + ", name=" + name + "]";
	}

}

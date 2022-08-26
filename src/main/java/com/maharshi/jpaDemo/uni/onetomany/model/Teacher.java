package com.maharshi.jpaDemo.uni.onetomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer teacherId;
	private String name;
	@OneToMany
	@JoinColumn(name = "teacher_id")
	private List<Student> students = new ArrayList<>();

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", students=" + students + "]";
	}

}

package com.maharshi.jpaDemo.uni.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.jpaDemo.uni.onetomany.model.Student;
import com.maharshi.jpaDemo.uni.onetomany.model.Teacher;
import com.maharshi.jpaDemo.uni.onetomany.repository.StudentRepository;
import com.maharshi.jpaDemo.uni.onetomany.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class OneToManyController {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("")
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		List<Student> students = teacher.getStudents();
		students = studentRepository.saveAll(students);
		teacher.setStudents(students);
		teacher = teacherRepository.save(teacher);
		return teacher;
	}

	@GetMapping("")
	public List<Teacher> getTeacher() {
		return teacherRepository.findAll();
	}

	@PutMapping("/{id}")
	public Teacher updateTeacher(@RequestBody Student student, @PathVariable("id") int id) {
		student = studentRepository.save(student);
		Teacher teacher = teacherRepository.findById(id).get();
		teacher.getStudents().add(student);
		return teacherRepository.save(teacher);
	}

}

package com.maharshi.jpaDemo.bi.manytoone.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.jpaDemo.bi.manytoone.model.Course;
import com.maharshi.jpaDemo.bi.manytoone.model.Instructor;

@RestController
@RequestMapping("/course")
public class ManyToOneBiController {

	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private CourseRepository courseRepository;

	@PostMapping("/course")
	public Course createCourse(@RequestBody Course course) {
		Instructor instructor = course.getInstructor();
		instructor = instructorRepository.save(instructor);
		course.setInstructor(instructor);
		course = courseRepository.save(course);
		course.getInstructor().setCourses(null);
		return course;
	}

	@PostMapping("/instructor")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		List<Course> courses = instructor.getCourses();
		courses = courseRepository.saveAll(courses);
		instructor.setCourses(courses);
		instructor = instructorRepository.save(instructor);
		instructor.getCourses().forEach(course -> {
			course.setInstructor(null);
		});
		return instructor;
	}

}

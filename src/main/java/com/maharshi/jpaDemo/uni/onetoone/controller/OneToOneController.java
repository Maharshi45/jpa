package com.maharshi.jpaDemo.uni.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.jpaDemo.uni.onetoone.model.Laptop;
import com.maharshi.jpaDemo.uni.onetoone.model.Person;
import com.maharshi.jpaDemo.uni.onetoone.repository.LaptopRepository;
import com.maharshi.jpaDemo.uni.onetoone.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class OneToOneController {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private LaptopRepository laptopRepository;

	@PostMapping()
	public Person createPerson(@RequestBody Person person) {
		Laptop laptop = laptopRepository.save(person.getLaptop());
		person.setLaptop(laptop);
		return personRepository.save(person);
	}

	@GetMapping("/{id}")
	public Person getPerson(@PathVariable("id") Integer id) {
		return personRepository.findById(id).get();
	}

}

package com.maharshi.jpaDemo.bi.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.jpaDemo.bi.onetoone.model.Husband;
import com.maharshi.jpaDemo.bi.onetoone.model.Wife;
import com.maharshi.jpaDemo.bi.onetoone.repository.HusbandRepository;
import com.maharshi.jpaDemo.bi.onetoone.repository.WifeRepository;

@RestController
@RequestMapping("/husband")
public class OneToOneBiController {

	@Autowired
	private HusbandRepository husbandRepository;
	@Autowired
	private WifeRepository wifeRepository;

	@PostMapping("/husband")
	public Husband createHusband(@RequestBody Husband husband) {

		Wife wife = husband.getWife();

		wife = wifeRepository.save(wife);
		husband.setWife(wife);
		husband = husbandRepository.save(husband);
		husband.getWife().setHusband(null);
		return husband;

	}

	@PostMapping("/wife")
	public Wife createWife(@RequestBody Wife wife) {

		Husband husband = wife.getHusband();
		husband = husbandRepository.save(husband);
		wife.setHusband(husband);
		wife = wifeRepository.save(wife);
		wife.getHusband().setWife(null);
		return wife;

	}

//	@GetMapping("/husband")
//	public List<Husband> getHusbands() {
//		List<Husband> husbands = husbandRepository.findAll();
//		for (Husband husband : husbands) {
//			husband.getWife().setHusband(null);
//		}
//		return husbands;
//	}

//	@GetMapping("/wife")
//	public List<Wife> getWives() {
//		List<Wife> wives = wifeRepository.findAll();
//		for (Wife wife : wives) {
//			wife.getHusband().setWife(null);
//		}
//		return wives;
//	}

}

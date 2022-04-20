package com.spr;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PersonController {
	@Autowired PersonService personService;
	@RequestMapping("/")
	public List<Person> getAllRecords(){
		return personService.getAllPersons();
	}
	
	@RequestMapping("/myForm")
	public ModelAndView show() {
		ModelAndView modelAndView = new ModelAndView("myForm","command",new Person());
		modelAndView.setViewName("myForm");
		return modelAndView;
	}
	
	@RequestMapping(value="/add-person",method=RequestMethod.POST)
	public ModelAndView home(@ModelAttribute Person p) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("validate");
		personService.addPerson(p);
		System.out.println(p.getPname());
		modelAndView.addObject("user",p);
		return modelAndView;
	}
	
	@RequestMapping(value = "/person/{id}",method = RequestMethod.GET)
	public Optional<Person> getUser(@PathVariable Integer id){
		return personService.getPerson(id);
	}
	
	@RequestMapping(value="/viewAll")
	public java.util.List<Person> getAll(){
        return personService.getAllPersons();
    }
	
}

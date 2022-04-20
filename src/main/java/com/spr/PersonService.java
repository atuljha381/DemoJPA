package com.spr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired PersonRepository personRepository;
	public List<Person> getAllPersons(){
		List<Person> records=new ArrayList<>();
		personRepository.findAll().forEach(records::add);
		return records;
	}
	
	public Optional<Person> getPerson(int id){
		return personRepository.findById(id);
	}
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	public void deletePerson(int id) {
		personRepository.deleteById(id);
	}
}

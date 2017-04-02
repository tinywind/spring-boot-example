package com.gogokwon.controller.practice.api;

import com.gogokwon.model.Hello;
import com.gogokwon.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author KJShin
 * @since 2017-03-01
 */
@RestController
@RequestMapping("api/hello")
	public class HelloApiController {

	@Autowired
	private HelloRepository helloRepository;
	/* crud
	* create
    * read
    * update
    * delete
    */

//	@Autowired
//	private SessionFactory sessionFactory;

	//@RequestMapping(value = "hello")
	//@RequestMapping("hello")
	//public String helloPage() {return "Hello World";}

	@RequestMapping(method = RequestMethod.GET)
	public List<Hello> helloList() {
//		Session session = sessionFactory.openSession();
//		session.createCriteria(Hello.class).list();
//		Hello hello = session.get(Hello.class, 1L);
		return helloRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody Hello hello) {
		helloRepository.saveAndFlush(hello);
	}

	/*
	public void add(String name) {
		Hello hello = new Hello();
        hello.setName(name);
        helloRepository.saveAndFlush(hello);
    }*/
	// url: /hello/1/update?name=신권재
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable Long id, @RequestBody Hello hello) {
		Hello one = helloRepository.findOne(id);
		one.setName(hello.getName());
		helloRepository.flush();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		helloRepository.delete(id);
		helloRepository.flush();
	}
}

package com.gogokwon.controller;

import com.gogokwon.model.Hello;
import com.gogokwon.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by KJShin on 2017-03-01.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    //@RequestMapping(value = "hello")
    @RequestMapping("hello")
    public String helloPage()
    {
        return "Hello World";
    }
    /*crud
    *create
    *read
    * update
    * delete
    */

    @Autowired
    private HelloRepository helloRepository;



    @RequestMapping("add")
    public void add(Hello hello)
    {
        helloRepository.saveAndFlush(hello);
    }
    /*public void add(String name){
        Hello hello = new Hello();
        hello.setName(name);

        helloRepository.saveAndFlush(hello);
    }*/

    @RequestMapping("read")
    public List<Hello> helloList(){
        return helloRepository.findAll();
    }

    // url: /hell/1/updat?name=신권재
    @RequestMapping("{id}/update")
    public List<Hello> update(@PathVariable Long id, String name){
        Hello one = helloRepository.findOne(id);
        one.setName(name);
        helloRepository.flush();
        return helloRepository.findAll();
    }



    @RequestMapping("{id}/delete")
    public List<Hello> delete(@PathVariable Long id){
        helloRepository.delete(id);
        helloRepository.flush();
        return helloRepository.findAll();
    }
}

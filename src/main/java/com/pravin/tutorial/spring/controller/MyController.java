package com.pravin.tutorial.spring.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/user/{name}")
    @ResponseBody
    public String handler(@MatrixVariable("name") String name) {
	return "Matrix Variable -<br>" + name;
    }

    @GetMapping("/user/{firstName}/{lastName}")
    @ResponseBody
    public String handler(@MatrixVariable("firstName") String firstName, @MatrixVariable("lastName") String lastName) {
	return "Matrix Variables -<br> firstName= " + firstName + "<br> lastName= " + lastName;
    }

    @GetMapping("/employee/{name}")
    @ResponseBody
    public String handler(@PathVariable("name") String name, @MatrixVariable("salary") double salary,
	    @MatrixVariable("dept") String dept) {
	return "Path Variable -<br> Name= " + name + "<br> Matrix Variables - <br> Salary= " + salary
		+ "<br> department= " + dept;
    }

    @GetMapping("/employee/{name}/{address}")
    @ResponseBody
    public String handler(@PathVariable("name") String name, @MatrixVariable(name = "id", pathVar = "name") int empId,
	    @MatrixVariable("dept") String dept, @PathVariable("address") String address,
	    @MatrixVariable(name = "id", pathVar = "name") int addrId) {
	return "Path Variables <br> name = " + name + "<br> address = " + address + "<br> Matxrix variable <br> empId ="
		+ empId + "<br> dept =" + dept + "<br> addrId =" + addrId;
    }

    @GetMapping("/car/{name}")
    @ResponseBody
    public String handler(@PathVariable("name") String name, @MatrixVariable("color") String[] color) {
	return "Path Variables <br> name = " + name + "<br> Matxrix variable <br> colors =" + Arrays.asList(color);
    }

    @GetMapping("/person/{name}")
    @ResponseBody
    public String hanlder(@PathVariable("name") String name,
	    @MatrixVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob,
	    @MatrixVariable(required = false, defaultValue = "9198XXXXX") String mobile) {
	return "Path Variables <br> name = " + name + "<br> Matxrix variable <br> dob =" + dob + "<br> mobile ="
		+ mobile;
    }
}

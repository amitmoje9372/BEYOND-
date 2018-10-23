package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.domain.Student;
import com.nit.service.StudentService;

@RestController
public class StudentController 
{
	@Autowired(required=true)
	private StudentService stdserv;
	
	
	
	/*
	 * adiing student
	 * url==http://localhost:8081/StudentRegWithMongoDb/rest/add
	 * XML==<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     *          <StudentRegistration>
     *              <stdId>5</stdId>
     *              <stdName>takla</stdName>
     *              <stdAddress>gj</stdAddress>
     *              <stdContactNo>8793</stdContactNo>
     *          </StudentRegistration>
	 */
	
	
	
	
	@RequestMapping(value="add",method=RequestMethod.POST,consumes={"application/xml","application/json"})
	public String addStudent(@RequestBody Student s) throws Exception
	{		
		boolean ba=stdserv.addStudent(s);
		if(ba)
		return "Student Added SuccessFully";
		else
		return "Student Id already exist";
	}
	
	
	/*
	 * to get a particular student
	 * url==http://localhost:8081/StudentRegWithMongoDb/rest/get?uid=4
	 */
	
	@RequestMapping(value="get",method=RequestMethod.GET,produces="application/xml")
	public Student getStudent(@RequestParam(name="uid") Integer sid) throws Exception
	{
		Student s=stdserv.getStudent(sid);
	
		return s;
	}
	/*
	 * to update a particular student
	 * 
	 * url==http://localhost:8081/StudentRegWithMongoDb/rest/update/4
	 *
	 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     *  <StudentRegistration>
     *      <stdId>4</stdId>
     *      <stdName>takla</stdName>
     *       <stdAddress>gj</stdAddress>
     *       <stdContactNo>8793</stdContactNo>
     *    </StudentRegistration>
	 *
	 */
	@RequestMapping(value="/update/{sid}",method=RequestMethod.PUT,consumes={"application/xml","application/json"})
	public String updateStudent(@PathVariable Integer sid,@RequestBody Student s) throws Exception
	{
		
		boolean ba=stdserv.updateStudent(sid,s);
		if(ba)
		return "Student Updated SuccessFully";
		else
		return "Student Does not exist";
	}
	
	
	/*
	 * deleting a particular student
	 * url==http://localhost:8081/StudentRegWithMongoDb/rest/delete/1
	 */
	@RequestMapping(value="delete/{sid}",method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable Integer sid) throws Exception
	{		
		System.out.println(sid);
		boolean ba=stdserv.deleteStudent(sid);
		if(ba)
		return "Student Deleted SuccessFully";
		else
		return "Student Does not exist";
	}

}

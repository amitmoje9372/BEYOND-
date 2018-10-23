package com.nit.service;


import com.nit.domain.Student;

public interface StudentService
{
	public boolean addStudent(Student s) throws Exception;
	public Student getStudent(Integer sid) throws Exception;
	public boolean updateStudent(Integer sid,Student s) throws Exception;
	public boolean deleteStudent(Integer sid) throws Exception;
}


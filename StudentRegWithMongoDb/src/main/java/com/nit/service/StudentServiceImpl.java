package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.StudentDao;
import com.nit.domain.Student;

@Service("stdserv")
public class StudentServiceImpl implements StudentService 
{
	@Autowired(required=true)
	private StudentDao stddao;

	public boolean addStudent(Student s) throws Exception
	{		
		return stddao.addStudentToDb(s);
	}

	public Student getStudent(Integer sid) throws Exception {
		
		return stddao.getStudentToDb(sid);
	}

	public boolean updateStudent(Integer sid, Student s) throws Exception {
		
		return stddao.updateStudentToDb(sid, s);
	}

	public boolean deleteStudent(Integer sid) throws Exception{
		
		return stddao.deleteStudentToDb(sid);
	}

}

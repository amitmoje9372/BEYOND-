package com.nit.dao;

import com.nit.domain.Student;

public interface StudentDao
{
	public boolean addStudentToDb(Student s) throws Exception;
	public Student getStudentToDb(Integer sid) throws Exception;
	public boolean updateStudentToDb(Integer sid,Student s) throws Exception;
	public boolean deleteStudentToDb(Integer sid) throws Exception;

}

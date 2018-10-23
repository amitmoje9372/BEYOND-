package com.nit.dao;


import org.springframework.stereotype.Repository;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.nit.domain.Student;

@Repository("stddao")
public class StudentDaoImpl implements StudentDao 
{
	/*
	 * this method is used to create DB object to insert into mongodb database
	 */
	private static BasicDBObject createBasicDBObject(Student s)
	{
		BasicDBObjectBuilder builder=BasicDBObjectBuilder.start();
		builder.append("_id", s.getStdId());
		builder.append("Name",s.getStdName());
		builder.append("Address",s.getStdAddress());
		builder.append("MobileNo",s.getStdContactNo());
		return (BasicDBObject) builder.get();
	}
	
	/*
	 * this method is used to get the connection from mongodb database
	 */
	
	MongoClient mongoClient = null;
	
	
	/*
	 * this method is use to get the connection
	 */
	public DBCollection setConnection() throws Exception
	{
	 mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	DB db=mongoClient.getDB("student");
	DBCollection dbc=db.getCollection("studentdetails");
	return dbc;
	}
	
	
	/*
	 * this method is use to close the connection
	 */
	public void close()
	{mongoClient.close();}
	
	
	/*
	 * this method used to add student to database 
	 * if it throws exception means id already exist catch it and return false
	 * if doesn't throw exception means student added successfully return true  
	 * @see com.nit.dao.StudentDao#addStudentToDb(com.nit.domain.Student)
	 */
	public boolean addStudentToDb(Student s) throws Exception 
	{
		BasicDBObject doc1=createBasicDBObject(s); 
		DBCollection dbc=setConnection();
		try {
		dbc.insert(doc1);
		close();
		return true;
		}
		catch(MongoException me)
		{
			close();
			return false;
		}
		
	}

	
	/*
	 * this method is used to retrieve a particular student
	 * this method gives student in json object so we have to manually convert that into java object
	 */
	
	public Student getStudentToDb(Integer sid) throws Exception 
	{
		BasicDBObject query=(BasicDBObject) BasicDBObjectBuilder.start().add("_id",sid).get();
		DBCollection dbc=setConnection();
		DBCursor cur=dbc.find(query);
		
		Student s=new Student();
		if(cur.count()==0)
		{
			close();
			return null;
		}
		while(cur.hasNext())
		{			
			DBObject json=cur.next();
			s.setStdId((Integer) json.get("_id"));
			s.setStdContactNo((Integer) json.get("MobileNo"));
			s.setStdName((String) json.get("Name"));			
			s.setStdAddress((String) json.get("Address"));
			
		}
		close();
		return s;
	}
	
	
/*
 * this method is used to update existing object
 *  
 *  */
	public boolean updateStudentToDb(Integer sid, Student s) throws Exception
	{
		DBCollection dbc=setConnection();
		BasicDBObject query=(BasicDBObject) BasicDBObjectBuilder.start().add("_id",sid).get();
		BasicDBObject doc2=createBasicDBObject(s); 
		WriteResult wr=dbc.update(query,doc2);
		boolean s1=wr.isUpdateOfExisting();
		
		close();
		return s1;
	}
	
	
	/*
	 * To remove a record by id
	 */

	public boolean deleteStudentToDb(Integer sid) throws Exception
	{	DBCollection dbc=setConnection();	
		BasicDBObject query2=(BasicDBObject) BasicDBObjectBuilder.start().add("_id",sid).get();
		WriteResult wr=dbc.remove(query2);
		close();
		return wr.getN()==1?true:false ;
	}

}

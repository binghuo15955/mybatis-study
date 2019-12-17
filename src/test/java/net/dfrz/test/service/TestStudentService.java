package net.dfrz.test.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.dfrz.entity.Student;
import net.dfrz.service.StudentServiceI;
import net.dfrz.test.TestCase;

public class TestStudentService extends TestCase{
	
	@Autowired
	private StudentServiceI studentService;
	
	@Test
	public void TestAddStudent() {
		Student student=new Student();
		student.setName("11111");
		student.setBirthday(new Date());
		student.setSex("男");
		
		studentService.AddStudent(student);
		
	}

}

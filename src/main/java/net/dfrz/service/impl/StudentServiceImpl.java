package net.dfrz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dfrz.entity.Student;
import net.dfrz.mapper.StudentMapper;
import net.dfrz.service.StudentServiceI;

@Service("studentService")
public class StudentServiceImpl implements StudentServiceI {
	
	@Autowired
	private StudentMapper StudentMapper;

	@Override
	public int AddStudent(Student student) {
		return StudentMapper.insert(student);
	}

}

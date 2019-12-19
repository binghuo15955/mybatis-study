package net.dfrz.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.dfrz.entity.Student;

//@Mapper
public interface StudentMapper 
{
	//@Insert("insert into t_student(stuid,name,birthday,sex) values(#{stuID},#{name},#{birthday},#{sex})")
	int insertStudent(Student student);
	int deleteStudentById(String stuID);
	int updateStudentById(Student student);
	Student selectStudentById(String stuID);
	List<Student> selectStudentAll(Map<String, Object> param);
	List<Student> selectStudentByBirthday(Map<String, Date> param);
	Student selectStudentBirthandNameById(String stuID);
	Map<String, Object> selectStudentBirthandName4MapById(String stuID);
	
	Student selectStudentByIdWithScores(String stuID);
	List<Student> getStudentWithScores(Map<String, Object> params);
	List<Student> getStudents(Map<String, Object> params);
}

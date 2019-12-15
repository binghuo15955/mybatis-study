package net.dfrz.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;

import net.dfrz.entity.Student;
import net.dfrz.mapper.StudentMapper;

public class TestStudentMapper2 {

	@Test
	public void testPageHelper() throws Exception {
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		PageHelper.startPage(2, 3);

		List<Student> list = studentMapper.selectStudentAll();
		for (Student student : list) {
			System.out.println(student.getStuID());
		}
		
		sqlSession.close();
	}

	@Test
	public void testSelectStuById() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		Student student = studentMapper.selectStudentById("s002");

		System.out.println(student.getStuID() + student.getName());
		// 关闭会话
		sqlSession.close();
	}

	@Test
	public void testAddStu() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		// 创建student对象
		Student student = new Student("s006", "阿松", new Date(), "女");

		studentMapper.insertStudent(student);
		// 提交SQL
		sqlSession.commit();

		sqlSession.close();

	}

	@Test
	public void testUptStu() throws Exception {

		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student("s004", "王五133", new Date(), "男");
		studentMapper.updateStudentById(student);
		// 提交SQL
		sqlSession.commit();
		// 关闭会话
		sqlSession.close();
	}
}

package net.dfrz.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import net.dfrz.entity.Student;

public class TestStudentMapper {

	@Test
	public void testSelectStuById() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
//		//1.同一个session多次查询
		System.out.println("------第一次查询--------");
		Student student = sqlSession.selectOne("selectStudentById", "s002");
		System.out.println(student.getStuID());
		sqlSession.close();
		System.out.println("------第2次查询--------");
		sqlSession=sqlSessionFactory.openSession();
		student = sqlSession.selectOne("selectStudentById", "s002");// 不会重复调用了，已经存在session中
		System.out.println(student.getStuID());

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

		// 创建student对象
		Student student = new Student("s007", "asdf", new Date(), "女");

		// studentMapper.insertStudent(student);
		sqlSession.insert("insertStudent", student);
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
		Student student = new Student("s004", "王五1221", new Date(), "男");
		sqlSession.update("updateStudentById", student);
		// 提交SQL
		sqlSession.commit();
		// 关闭会话
		sqlSession.close();
	}
}

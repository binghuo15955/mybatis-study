package net.dfrz.test;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import net.dfrz.entity.Student;
import net.dfrz.mapper.StudentMapper;

public class TestStudentMapper2 {

	
	//延迟加载 多表查询
	@Test
	public void testGetStudentWithScores() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		Map<String,Object> params=new HashMap<String,Object>();
		
//		params.put("stuID", "s002");
		
//		List<Student> students=studentMapper.getStudentWithScores(params);
		List<Student> students=studentMapper.getStudents(params);
		
		System.out.println(students.size());

		//延迟加载 要用才加载
//		for (Student stu:students) {
//			System.out.println(stu.getScoresSet().size());
//		}
		sqlSession.close();

	}

	@Test
	public void testselectStudentBirthandNameById() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		// 侧重于返回为Map，避免了返回值为空时，浪费客户端流量
		Student student = studentMapper.selectStudentBirthandNameById("ec96fcd41fb011ea90d154ee7594d3a7");
		Map map = studentMapper.selectStudentBirthandName4MapById("ec96fcd41fb011ea90d154ee7594d3a7");

		// 关闭会话
		sqlSession.close();
	}

	@Test
	public void testSelectStuByBirthday() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Map<String, Date> param = new HashMap<String, Date>();

		param.put("start", new Date(119, 10, 1));
		param.put("end", new Date(120, 12, 10));

		List<Student> student = studentMapper.selectStudentByBirthday(param);

		System.out.println(student.size());
		// 关闭会话
		sqlSession.close();
	}

	@Test
	public void testPageHelper() throws Exception {
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		// 调用static方法
		// PageHelper.startPage(2, 3);

		// 通过Map直接传递任何需要的参数
		Map<String, Object> param = new HashMap<>();

		/*
		 * param.put("name", "UUID"); param.put("start", new Date(119,10,1));
		 * param.put("end", new Date(120,12,10));
		 */

		// foreach标签set测试
		Set<String> ids = new HashSet<String>();
		ids.add("S002");
		ids.add("1");
		ids.add("3");
		ids.add("6");
		ids.add("37");

		param.put("ids", ids);

		List<Student> list = studentMapper.selectStudentAll(param);

		/*
		 * for (Student student : list) { System.out.println(student.getStuID()); }
		 */

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
		Student student = new Student("", "include&sql", new Date(), "女");

		studentMapper.insertStudent(student);
		// System.out.println(student.getStuID());
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

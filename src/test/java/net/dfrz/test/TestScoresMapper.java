package net.dfrz.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import net.dfrz.entity.Scores;
import net.dfrz.mapper.ScoresMapper;

public class TestScoresMapper {

	@Test
	public void testGetStudentWithScores() throws Exception {
		// 读取配置文件
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建sessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		ScoresMapper scoresMapper = sqlSession.getMapper(ScoresMapper.class);
		
		Map<String,Object> params=new HashMap<String,Object>();
		
//		params.put("stuID", "s002");
		
//		List<Student> students=studentMapper.getStudentWithScores(params);
		List<Scores> scores=scoresMapper.getScoresBystuID(params);
		
		sqlSession.close();

	}

}

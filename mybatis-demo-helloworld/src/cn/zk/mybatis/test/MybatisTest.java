package cn.zk.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.zk.mybatis.entity.Blog;
import cn.zk.mybatis.mapper.BlogMapper;

public class MybatisTest {

	SqlSessionFactory sqlSessionFactory;
	SqlSession session;

	@Before
	public void init() throws IOException {
		String resource = "mybatis-config.xml";
		// �� ĳ��·���¼�����Դ�ļ�
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// ͨ��������ģʽ���sqlsessionfactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
	}

	@After
	public void destroy() {
		session.close();
	}

	@Test
	public void testDemo() {
		session = sqlSessionFactory.openSession();
		Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", "a");
		System.out.println(blog);
	}
	
	@Test
	public void testInterface(){
		session=sqlSessionFactory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		System.out.println(mapper);
		Blog blog = mapper.selectById(1);
		System.out.println(blog);
				
	}
	//���
	@Test
	public void testInsert() {
		session = sqlSessionFactory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		System.out.println(mapper);
		Blog blog = new Blog(3,"bb","bb");
		mapper.insertBlog(blog);
		session.commit();
		System.out.println(blog);
	}
	//ɾ��
	@Test
	public void testDelete() {
		session = sqlSessionFactory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		System.out.println(mapper);
		mapper.deleteBlog(1);
		session.commit();
		System.out.println("ɾ���ɹ�");
	}
	//����
	
	@Test
	public void testUpdate() {
		session = sqlSessionFactory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		System.out.println(mapper);
		Blog blog = new Blog();
		blog.setId(2);
		blog.setTitle("update");
		mapper.updateBlog(blog);
		session.commit();
		System.out.println(blog);
	}
	//��ѯ����
	@Test
	public void testfindAll(){
		session=sqlSessionFactory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		System.out.println(mapper);
		List<Blog> list = mapper.selectAllBlog();
		System.out.println(list);
				
	}

}

package cn.zk.mybatis.mapper;

import java.util.List;

import cn.zk.mybatis.entity.Blog;

public interface BlogMapper {

	public Blog selectById(Integer id);
	
	public void insertBlog(Blog blog);
	public void deleteBlog(Integer id);
	public void updateBlog(Blog blog);
	public List<Blog> selectAllBlog();
}

package com.spider.common.model;


import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.spider.common.model.base.BaseBlog;

@SuppressWarnings("serial")
public class Blog extends BaseBlog<Blog>{
	public static final Blog blog = new Blog();
	/**
	 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
	 */
	public Page<Blog> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from blog order by id desc");
	}
	
	public List<Blog> findBlogList(){
		List<Blog> blogs = Blog.blog.find("select * from blog limit 1,10");
		return blogs;
	}
	public List<Blog> findReadList(){
		List<Blog> blogs = Blog.blog.find("select * from blog b order by b.read desc limit 1,5");
		return blogs;
	}
	public List<Blog> findDateList(){
		List<Blog> blogs = Blog.blog.find("select * from blog order by date desc limit 1,5");
		return blogs;
	}
}

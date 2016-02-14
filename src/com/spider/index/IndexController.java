package com.spider.index;


import java.util.List;

import com.jfinal.core.Controller;
import com.spider.common.model.Blog;
import com.spider.common.model.User;

/**
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		List<Blog> blogs = Blog.blog.findBlogList();
		List<Blog> blogNew = Blog.blog.findDateList();
		List<Blog> blogRead = Blog.blog.findReadList();
		List<User> user = User.user.findUserNew();
		setAttr("blogs", blogs);
		setAttr("blogNew", blogNew);
		setAttr("blogRead", blogRead);
		setAttr("user", user);
		User sessionUser = getSessionAttr("user");
		setAttr("sessionUser",sessionUser);
		render("index.html");
	}
	public static void main(System [] star){
		
	}
}






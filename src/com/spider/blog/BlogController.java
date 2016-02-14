package com.spider.blog;

import com.jfinal.core.Controller;

public class BlogController extends Controller{
	public void index(){
		render("single.html");
	}
}

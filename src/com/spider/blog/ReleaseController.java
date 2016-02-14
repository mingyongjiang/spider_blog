package com.spider.blog;

import java.util.Date;

import com.jfinal.core.Controller;
import com.spider.common.model.Blog;
import com.spider.common.model.User;

/**
 * IndexController
 */
public class ReleaseController extends Controller {
	public void index() {
		User sessionUser = getSessionAttr("user");
		setAttr("sessionUser",sessionUser);
		render("release.html");
	}
	public void release(){
		User user = getSessionAttr("user");
		setAttr("msg", getModel(Blog.class).set(Blog.date, new Date()).set("userId", user.getId()).save());
		redirect("/release");
	}
}






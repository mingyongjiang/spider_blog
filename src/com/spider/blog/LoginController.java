package com.spider.blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.spider.common.model.User;

public class LoginController extends Controller{
	public void index(){
		render("login.html");
	}
	public void login(){
		List<User> user = User.user.loginFind(getPara("password"), getPara("userName"));
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(null!=user&&!user.isEmpty()){
			setSessionAttr("user", user.get(0));
			jsonMap.put("state", true);
		}else{
			jsonMap.put("state", false);
		}
		renderJson(jsonMap);
	}
}

package com.spider.blog;


import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.spider.common.model.User;

public class RegController extends Controller {
	public void index() {
		render("reg.html");
	}

	public void reg() {
		Map<String, Object> jsonMaps = new HashMap<>();
		if(User.user.exEmail(getPara("userName"))){
			if(User.user.exEmail(getPara("userEmail"))){
				jsonMaps = User.user.reg(getPara("password"), getPara("userName"), getPara("userEmail"));
			}else{
				jsonMaps.put("state",false);
				jsonMaps.put("msg","邮箱已经被使用");
			}
		}else{
			jsonMaps.put("state",false);
			jsonMaps.put("msg","用户名已被使用");
		}
		renderJson(jsonMaps);
	}
}

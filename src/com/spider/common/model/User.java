package com.spider.common.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Page;
import com.spider.common.model.base.BaseUser;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User user = new User();

	/**
	 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
	 */
	public Page<User> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from blog order by id asc");
	}

	public List<User> loginFind(String password, String userName) {
		List<User> user =  User.user.find("select * from user where userName = ? or userEmail = ? and password =?",
				userName,userName, password);
		return user;
	}
	
	public boolean exEmail(String email){
		List<User> count = User.user.find("select * from user where userEmail=?",email);
		if(count!=null&&count.size()>0&&!count.isEmpty()){
			return false;
		}
		return true;
	}
	public boolean exName(String name){
		List<User> count = User.user.find("select * from user where userName=?",name);
		if(count!=null&&count.size()>0&&!count.isEmpty()){
			return false;
		}
		return true;
	}

	public Map<String, Object> reg(String password, String userName, String userEmail) {
		Map<String, Object> jsonMap = new HashMap<>();
		if (!userName.equals("") && !userEmail.equals("") && !password.equals("") && !(userName == null)
				&& !(userEmail == null) && !(password == null)) {
			boolean state = User.user.set("regTime", new Date()).set("password", password).set("userName", userName).set("userEmail", userEmail).save();
			jsonMap.put("state", state);
			if (!state) {
				jsonMap.put("msg", "服务器繁忙，请稍后重试");
			}
		} else if (userName.equals("")) {
			jsonMap.put("state", false);
			jsonMap.put("msg", "USERNAME_NULL");
		} else if (userEmail.equals("")) {
			jsonMap.put("state", false);
			jsonMap.put("msg", "USEREMAIL_NULL");
		} else if (password.equals("")) {
			jsonMap.put("state", false);
			jsonMap.put("msg", "PASSWORD_ULL");
		} else {
			jsonMap.put("state", false);
			jsonMap.put("msg", "未知错误，请联系管理员");
		}
		return jsonMap;
	}
	public List<User> findUserNew(){
		List<User> user = User.user.find("select * from user order by regTime desc limit 1,5");
		return user;
	}
	
}

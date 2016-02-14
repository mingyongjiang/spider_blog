package com.spider.common.model.base;

import java.util.Date;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {
	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setUserName(String userName) {
		set("userName", userName);
	}

	public String getUserName() {
		return get("userName");
	}

	public void setRegTime(Date regTime) {
		set("regTime", regTime);
	}

	public Date getRegTime() {
		return get("regTime");
	}

	public void setLastTime(Date lastTime) {
		set("lastTime", lastTime);
	}

	public Date getLastTime() {
		return get("lastTime");
	}

	public void setUserEmail(String userEmail) {
		set("userEmail", userEmail);
	}

	public String getUserEmail() {
		return get("userEmail");
	}

	public void setPassword(String password) {
		set("password", password);
	}

	public String getPassword() {
		return get("password");
	}
}

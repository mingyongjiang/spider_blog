package com.spider.blog;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RegValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("user.userName", "valmsg", "请输入用户名");
		validateRequiredString("user.userEmail", "valmsg", "请输入邮箱");
	}

	@Override
	protected void handleError(Controller c) {
		
	}

}

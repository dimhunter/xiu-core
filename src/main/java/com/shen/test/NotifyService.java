package com.shen.test;

/**
 * 
 * 	UserCenter和MessageCenter都是接口，User是一个简单的JavaBean
	由于uc和mc乃外部依赖，此类不需也不应保证uc和mc的正确性，此类只需保证：
	假设uc和mc是正确的，那么我也是正确的。
	所以需要隔离依赖--使用mock

 * @author shen
 *
 */
public class NotifyService {
	
	private UserCenter uc;
	
	private MessageCenter mc;

	public void sendMessage(long userId, String message) {
		String email = uc.getUser(userId).getEmail();
		mc.sendEmail(email, message);
	}

	public void setUc(UserCenter uc) {
		this.uc = uc;
	}

	public void setMc(MessageCenter mc) {
		this.mc = mc;
	}
}

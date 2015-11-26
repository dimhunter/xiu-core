package com.shen.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class NotifyServiceTest {
	private NotifyService notifyService;
	private UserCenter uc;
	private MessageCenter mc;

	@Before
	public void setUp() {
		notifyService = new NotifyService();
		uc = Mockito.mock(UserCenter.class);
		mc = Mockito.mock(MessageCenter.class);
		notifyService.setUc(uc);
		notifyService.setMc(mc);
	}
	
	/**
	 *  测试前，从uc获得email
	 *  测试后，必须调用mc.sendEmail，所以验证之
	 */
	@Test
	public void testSendMessage() {
		long userId = 1L;
		Mockito.when(uc.getUser(userId)).thenReturn(createUserWithEmail("foo@bar"));
		notifyService.sendMessage(userId, "hello");
		Mockito.verify(mc).sendEmail(Mockito.eq("foo@bar"), Mockito.eq("hello"));
	}

	private UserBean createUserWithEmail(String email) {
		UserBean user = new UserBean();
		user.setEmail(email);
		return user;
	}

}

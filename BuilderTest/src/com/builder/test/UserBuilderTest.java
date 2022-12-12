package com.builder.test;

import org.junit.Test;

public class UserBuilderTest {

	@Test
	public void userbuilderTest() {
		User user = User.builder()
				.name("ȫ�浿")
				.age(20)
				.build();
		System.out.println(user);
		
		User user1 = User.builder()
				.name("ȫ���")
				.age(33)
				.build();
		System.out.println(user1);
				}
}

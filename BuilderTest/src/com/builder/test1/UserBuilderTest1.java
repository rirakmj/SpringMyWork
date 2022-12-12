package com.builder.test1;

import org.junit.Test;

public class UserBuilderTest1 {

	@Test
	public void userbuilderTest1() {
		User user = User.builder()
				.name("ȫ�浿")
				.age(20)
				.build();
		System.out.println(user);
		
		User user1 = User.builder()
				.age(200)
				.name("ȫ���")
				.build();
		System.out.println(user);
		}
}

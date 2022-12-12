package com.builder.test1;

import org.junit.Test;

public class UserBuilderTest1 {

	@Test
	public void userbuilderTest1() {
		User user = User.builder()
				.name("È«±æµ¿")
				.age(20)
				.build();
		System.out.println(user);
		
		User user1 = User.builder()
				.age(200)
				.name("È«±æ¼ø")
				.build();
		System.out.println(user);
		}
}

package com.roy;


import com.roy.entity.User;
import com.roy.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);

		userList.forEach(System.out::println);
	}

	@Test
	public void insert() {
		User user = new User();
		user.setAge(31);
		user.setEmail("mayun@sina.com");
		user.setName("马云");
		user.setManagerId(1088248166370832385L);
		int result = userMapper.insert(user);
		System.out.println("affect rows" + result);
	}

}
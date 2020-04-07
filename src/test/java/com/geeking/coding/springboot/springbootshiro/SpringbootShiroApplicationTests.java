package com.geeking.coding.springboot.springbootshiro;

import com.geeking.coding.springboot.App;
import com.geeking.coding.springboot.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SpringbootShiroApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedis(){
		redisTemplate.opsForValue().set("hello","hello redis");
		String name = (String) redisTemplate.opsForValue().get("hello");
		System.out.println(name);
	}

	@Resource
	private UserMapper userMapper;

	@Test
	public void testMybatis(){
		String value = userMapper.testDB();
		System.out.println(value);
	}
}

package com.example.springbootdemo;

import com.example.springbootdemo.service.ActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {

	@Autowired
	ActivityService activityService;
	@Test
	void contextLoads() {
			activityService.getOne();
	}

	@Test
	void query() {
		try {
			activityService.getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

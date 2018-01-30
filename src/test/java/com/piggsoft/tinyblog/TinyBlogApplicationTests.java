package com.piggsoft.tinyblog;

import com.piggsoft.tinyblog.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinyBlogApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private IUserService userService;
	@Autowired
	private CacheManager cacheManager;
	@Repeat(3)
	@Test
	public void testCache() {
		Cache cache = cacheManager.getCache("user");
		userService.findByUsername("admin533");
		System.out.println(cache.get("user:admin533"));
	}

}

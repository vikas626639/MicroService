package com.nit.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.nit.entity.User;

public class RedisService {
	
	//since JedisContection factory is a class so we have to annotated with @Bean Annotatioh
	@Bean
	JedisConnectionFactory connectionFactory() {
		//establish the connection with the redis server
		JedisConnectionFactory jcf=new JedisConnectionFactory();
		//if redis server is running in remote mashine the we have to set all connection properties
		//jcf.setHostName(hostName);
		//jcf.setPort(port);
		//jcf.set
		//jcf.setPassword(password);
		return jcf;
	}
	
	//configure the RedisTemplate as a bean to inject JedisConntectionFactory obj
	@Bean
	RedisTemplate<String, User> template() {
		RedisTemplate<String ,User> redisTemplate=new RedisTemplate<String, User>();
		redisTemplate.setConnectionFactory(connectionFactory());//JedisConntdtionFactory injected to RedisTemplate
		return redisTemplate;
	}
	
	
	
	
	
	
}

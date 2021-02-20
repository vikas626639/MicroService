package com.nit.confige;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Configuration
@Data
@ConfigurationProperties(prefix = "demo")
@EnableConfigurationProperties
public class DemoConfigProp {
	//private String welcomeMsg;
	//private String greetMsg;
	
	//when properties are huge in the yml file dont create any private memeber just read from the map
	Map<String,String>properties=new HashMap<String, String>();
}

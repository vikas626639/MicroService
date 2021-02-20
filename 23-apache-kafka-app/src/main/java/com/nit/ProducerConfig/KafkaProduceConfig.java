package com.nit.ProducerConfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nit.Service.Customer;
import com.nit.util.KafkaConstants;

@Configuration
public class KafkaProduceConfig {

	@Bean
	public ProducerFactory<String, Customer> producerFactory() {
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.HOST);				//here configure the topic and localhost port number
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaProducerFactory(configProps);
	}
	
	
	
	//configure the kafka template
	/**
	 * This method is used to create KafkaTemplate bean obj
	 * @return
	 */
	@Bean(name = "kafkaTemplate")
	public KafkaTemplate<String, Customer> kafkaTemplate() {		//creating the kafkaTemplate class
		return new KafkaTemplate<>(producerFactory());				//this is constructor injection where inject the producer factory
	}
	
	
}



/*
 * in the configure class we have to set
 * boot-strap-server 
 * key-serializer
 * value-serializer
 * 
 * in the form of key -value pair for this taken map
 */
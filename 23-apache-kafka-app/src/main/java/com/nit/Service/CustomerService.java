package com.nit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nit.util.KafkaConstants;
@Service("customerService")
public class CustomerService {

	//inejct the kafka template
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	/**
	 * This method is used to publish customer records as msgs to kafka topic
	 * 
	 * @param customers
	 * @return
	 */
	
	public String add(List<Customer> customers) {

		if (!customers.isEmpty()) {
			for (Customer c : customers) {
									//String			//customer data
				kafkaTemplate.send(KafkaConstants.TOPIC, c);    //i want to public the topic as a key and value of the object of custumer
				System.out.println("************Msg published to Kafka topic***************");
			}
		}
		return "Customer Records Added To Kafka Queue Successfully";
	}
	
	/**
	 * This method is used to consume messages from kafka topic
	 * 
	 * @param c
	 * @return
	 */
	
	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public Customer listener(Customer c) {
		System.out.println("***Msg recieved from Kafka Topic ::" + c);
		return c;
	}

}
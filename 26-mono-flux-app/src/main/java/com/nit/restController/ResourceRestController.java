package com.nit.restController;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.bindingClasses.CustomerEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class ResourceRestController {
	
	Logger logger=LoggerFactory.getLogger(ResourceRestController.class);
	
	@GetMapping(value = {"/","/index"}, produces = {"Application/json","Application/xml"})
	public ResponseEntity<Mono<CustomerEvent>> monoObject(){
		//create the CustomerEvent Object 
		logger.info("*******from monoObject********");
		CustomerEvent custmer=new CustomerEvent("vikas", new Date());
		Mono<CustomerEvent> event=Mono.just(custmer);
		return new ResponseEntity<Mono<CustomerEvent>>(event,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<CustomerEvent>> fluxObject(){
		CustomerEvent event=new CustomerEvent("vikas", new Date());
		
		// Creating Stream object to send data
		Stream<CustomerEvent> stream=Stream.generate(()->event);
		
		// Giving Stream object to Flux object
		Flux<CustomerEvent> flux=Flux.fromStream(stream);
		
		// Setting Response Interval
		Flux<Long> interval = Flux.interval(Duration.ofMillis(500));
		
		// Combining IntervalFlux and CustomerEventFlux
		Flux<Tuple2<Long, CustomerEvent>> zip = Flux.zip(interval, flux);
		
		// Getting Second Tuple value as Flux Obj
		Flux<CustomerEvent> fluxMap = zip.map(Tuple2::getT2);
		
		// Adding Flux Object to Response Body
		ResponseEntity<Flux<CustomerEvent>> resEntity = 
						new ResponseEntity<Flux<CustomerEvent>>(fluxMap, HttpStatus.OK);
		return resEntity;
	}
	
}

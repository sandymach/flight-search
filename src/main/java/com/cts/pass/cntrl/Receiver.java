package com.cts.pass.cntrl;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.cts.pass.service.SearchService;


@Controller
public class Receiver {
	
	@Autowired
	private SearchService searchService;
	
	@Bean
	Queue queue() {
		return new Queue("InventoryQ", false);
	}
	
	@RabbitListener(queues = "InventoryQ")
    public void processMessage(Map<String,Object> fare) {
        System.out.println("===========> ==== <===========");
		System.out.println(fare);
		System.out.println("===========> ==== <===========");
        searchService.updateInventory((String)fare.get("FLIGHT_NUMBER"),(LocalDate)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
       //call repository and update the fare for the given flight
    }	
	
	

	
}

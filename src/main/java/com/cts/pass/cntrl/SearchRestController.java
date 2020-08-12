package com.cts.pass.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pass.entity.Flight;
import com.cts.pass.service.SearchQuery;
import com.cts.pass.service.SearchService;


@RestController
@RequestMapping("/api/pss")
@CrossOrigin
public class SearchRestController {

	@Autowired
	private SearchService searchService;
	
	@PostMapping("/findFlights")
	public List<Flight> searchFlights(@RequestBody SearchQuery searchQuery){
		System.out.println(searchQuery);
		return searchService.search(searchQuery);
	}
	
	@GetMapping("/findFlight/{id}")
	public Flight findFlight(@PathVariable("id")long id) {
		return searchService.findByFlightId(id);
	}
	
}

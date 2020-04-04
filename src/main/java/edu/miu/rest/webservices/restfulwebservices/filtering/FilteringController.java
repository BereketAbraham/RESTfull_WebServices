package edu.miu.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue getSomeBean(){
		//Dynamic filtering
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	@GetMapping("/filtering-list")
	public MappingJacksonValue getSomeBeanList(){
		//Dynamic filtering
		List<SomeBean> list = new ArrayList<SomeBean>(Arrays.asList(new SomeBean("Value1", "Value2", "Value3"), new SomeBean("Value12", "Value22", "Value32")));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter1", "filter3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
	}
}

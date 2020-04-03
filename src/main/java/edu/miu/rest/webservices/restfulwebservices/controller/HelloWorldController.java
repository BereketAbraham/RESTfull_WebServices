package edu.miu.rest.webservices.restfulwebservices.controller;

import edu.miu.rest.webservices.restfulwebservices.model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/helloworld")
	public String helloWorld(){
		return "Hello Restful web services";
	}

	@GetMapping("/helloworldbean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("HelloWorld-Bean");
	}

	@GetMapping("/helloworld/pathvariable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello Bereket, %s" , name));
	}

	@GetMapping("/helloworldinternationalization")
	public String helloWorldInternationalization(@RequestHeader(name = "Accept-language", required = false) Locale locale){
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	//or I can use AcceptHeaderLocalResolver as a bean config
	@GetMapping("/helloworldinternationalization1")
	public String helloWorldInternationalization1(){
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}

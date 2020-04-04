package edu.miu.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    // Versioning using different URI
	@GetMapping("/V1/person")
	public PersonV1 getPersonV1(){
		return new PersonV1("Bereket Abraham");
	}

	@GetMapping("/V2/person")
	public PersonV2 getPersonV2(){
		return new PersonV2(new Name("Bereket", "Abraham"));
	}
	// Versioning using Request params
	@GetMapping(value = "/person/param", params = "V1")
	public PersonV1 paramV1(){
		return new PersonV1("Bereket Abraham");
	}

	@GetMapping(value = "/person/param", params = "V2")
	public PersonV2 paramV2(){
		return new PersonV2(new Name("Bereket", "Abraham"));
	}
	// Versioning using header
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1(){
		return new PersonV1("Bereket Abraham");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2(){
		return new PersonV2(new Name("Bereket", "Abraham"));
	}
	// Versioning using produces or Accept header versioning or mime type
	@GetMapping(value = "/person/produces", produces = "application/edu.miu.webserivces.app-V1+json")
	public PersonV1 producesV1(){
		return new PersonV1("Bereket Abraham");
	}

	@GetMapping(value = "/person/produces", produces = "application/edu.miu.webserivces.app-V2+json")
	public PersonV2 producesV2(){
		return new PersonV2(new Name("Bereket", "Abraham"));
	}
}

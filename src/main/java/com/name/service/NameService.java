package com.name.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {

	private static final Object FIRST_NAME = "firstName";

	private static final Object LAST_NAME = "lastName";

	private static final Object FULL_NAME = "fullName";
	

	// private FirstNameClient client1;

	// private SecondNameClient client2;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Autowired public NameService( FirstNameClient client1, SecondNameClient
	 * client2, RestTemplate restTemplate) { super(); //this.client1 = client1;
	 * //this.client2 = client2; this.restTemplate = RestTemplateBuilder.build }
	 */

	public String getNameByParam(String nameType) {
		String searchedName = null;
		if (nameType.equals(FIRST_NAME)) {
			searchedName = restTemplate.getForEntity("http://first-name-service/firstName", String.class).getBody();
		} else if (nameType.equals(LAST_NAME)) {
			searchedName = restTemplate.getForEntity("http://last-name-service/lastName", String.class).getBody();
		} else if (nameType.equals(FULL_NAME)) {
			searchedName = restTemplate.getForEntity("http://FIRST-NAME-SERVICE/firstName", String.class).getBody() + " "
					+ restTemplate.getForEntity("http://last-name-service/lastName", String.class).getBody();
		} else {
			return "name type is wrong!";
		}
		return searchedName;
	}

}

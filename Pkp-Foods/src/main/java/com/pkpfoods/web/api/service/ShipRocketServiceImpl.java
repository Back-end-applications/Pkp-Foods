package com.pkpfoods.web.api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.pkpfoods.web.api.domain.ShipRocketCredentials;
import com.pkpfoods.web.api.domain.ShipRocketUser;

@Service
public class ShipRocketServiceImpl implements ShippingService {

	private static String getAccessToken() {
		String url = "https://apiv2.shiprocket.in/v1/external/auth/login";
		ShipRocketCredentials credentials = new ShipRocketCredentials();
		credentials.setEmail("vivek.pyda95@gmail.com");
		credentials.setPassword("Vivek@95");

		RestTemplate restTemplate = new RestTemplate();
		ShipRocketUser shipRocketUser = restTemplate.postForObject(url, credentials, ShipRocketUser.class);

		return shipRocketUser.getToken();
	}

	private static String sendRequest(String url) {

		String accessToken = "Bearer " + ShipRocketServiceImpl.getAccessToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", accessToken);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		return response.getBody();
	}

	@Override
	public String fetchCourierServiceability() {

		String url = "https://apiv2.shiprocket.in/v1/external/courier/serviceability/";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("pickup_postcode", 110030)
				.queryParam("delivery_postcode", 500074)
				.queryParam("cod", 1)
				.queryParam("weight", 0.25);

		return ShipRocketServiceImpl.sendRequest(builder.toUriString());

	}

	@Override
	public String fetchLocalityDetails() {

		String url = "https://apiv2.shiprocket.in/v1/external/open/postcode/details";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("postcode", "500074");

		return ShipRocketServiceImpl.sendRequest(builder.toUriString());

	}

}

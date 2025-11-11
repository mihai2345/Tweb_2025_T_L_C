package com.example.demo.client;

import com.example.demo.dto.AuthDtos;
import com.example.demo.dto.ElementDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersistenceClient {
	private final RestTemplate restTemplate;

	@Value("${persistence.base-url:http://localhost:8081}")
	private String baseUrl;

	public PersistenceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<?> login(AuthDtos.LoginRequest req) {
		return restTemplate.postForEntity(baseUrl + "/persistence/api/auth/login", req, Object.class);
	}

	public ResponseEntity<?> signup(AuthDtos.SignupRequest req) {
		return restTemplate.postForEntity(baseUrl + "/persistence/api/auth/signup", req, Object.class);
	}

	public ResponseEntity<?> reset(AuthDtos.ResetPasswordRequest req) {
		return restTemplate.postForEntity(baseUrl + "/persistence/api/auth/reset", req, Object.class);
	}

	public ResponseEntity<Object> getElements() {
		return restTemplate.getForEntity(baseUrl + "/persistence/api/elements", Object.class);
	}

	public ResponseEntity<Object> getElement(String id) {
		return restTemplate.getForEntity(baseUrl + "/persistence/api/elements/" + id, Object.class);
	}

	public ResponseEntity<Object> updateElement(String id, ElementDto dto) {
		return restTemplate.exchange(baseUrl + "/persistence/api/elements/" + id, HttpMethod.PUT, new HttpEntity<>(dto), Object.class);
	}
}



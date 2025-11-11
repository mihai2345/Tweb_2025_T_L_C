package com.example.demo.controller;

import com.example.demo.client.PersistenceClient;
import com.example.demo.dto.AuthDtos;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final PersistenceClient client;

	public AuthController(PersistenceClient client) {
		this.client = client;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody AuthDtos.LoginRequest req) {
		return (ResponseEntity<?>) client.login(req);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody AuthDtos.SignupRequest req) {
		return (ResponseEntity<?>) client.signup(req);
	}

	@PostMapping("/reset")
	public ResponseEntity<?> reset(@Valid @RequestBody AuthDtos.ResetPasswordRequest req) {
		return (ResponseEntity<?>) client.reset(req);
	}
}



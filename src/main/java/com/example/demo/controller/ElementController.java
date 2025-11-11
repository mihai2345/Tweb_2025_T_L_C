package com.example.demo.controller;

import com.example.demo.client.PersistenceClient;
import com.example.demo.dto.ElementDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elements")
public class ElementController {
	private final PersistenceClient client;

	public ElementController(PersistenceClient client) {
		this.client = client;
	}

	@GetMapping
	public ResponseEntity<Object> all() {
		return client.getElements();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable String id) {
		return client.getElement(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody ElementDto dto) {
		return client.updateElement(id, dto);
	}
}



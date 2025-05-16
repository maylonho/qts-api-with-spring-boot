package br.com.oliveira.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@GetMapping
	public String raiz() {
		return "endpoint raiz";
	}
	
}

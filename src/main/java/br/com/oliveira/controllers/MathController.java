package br.com.oliveira.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@GetMapping("/sum")
	public Double sum() {
		return 10D;
	}
	
	@GetMapping("/")
	public String raiz() {
		return "endpoint raiz";
	}
	
}

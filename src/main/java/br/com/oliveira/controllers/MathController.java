package br.com.oliveira.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.oliveira.SimpleMath;

@RestController
public class MathController {

	@GetMapping("/sum/{firstNumber}/{secoundNumber}")
	public Double sum(
			@PathVariable(value = "firstNumber") String firstNumber, 
			@PathVariable(value = "secoundNumber") String secoundNumber) {
		
		SimpleMath math = new SimpleMath();
		
		double n1 = Double.parseDouble(firstNumber);
		double n2 = Double.parseDouble(secoundNumber);
		
		return math.sum(n1, n2);
	}
	
	
}

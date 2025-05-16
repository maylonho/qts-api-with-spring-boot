package br.com.oliveira;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleMathTest {

	@Test
	void sum() {
		SimpleMath math = new SimpleMath();
		
		double actual = math.sum(8D,2D);
		assertEquals(10D, null);
	}

}

package br.com.oliveira;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe SimpleMath")
class SimpleMathTest {

	@Test
	@DisplayName("Teste de soma - 8D + 2D = 10D)")
	void testSum_EightAddTwoEqualTen() {
		//GIVEN
		SimpleMath math = new SimpleMath();
		
		//WHEN
		double actual = math.sum(8D,2D);
		double expected = 10D;
		
		//THEN
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Teste de subtração - 20D - 13D = 7D")
	void testSubtraction() {
		
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	void test() {
		int a = 10;
	}
	@Test
	public void operatorsTest() {
		int number = 123;
		int z = 10;
		assertEquals(3, getThirdDigit(number, z));
		assertEquals(2, getSecondDigit(number, z));
		assertEquals(1, getFirstDigit(number, z));
	}
	
	
	private int getFirstDigit(int number, int z) {
		return (number / z) / z;
	}
	private int getSecondDigit(int number, int z) {
		return (number / z) % z;
	}
	private int getThirdDigit(int number, int z) {
		return number % z;
	}
	
}
 
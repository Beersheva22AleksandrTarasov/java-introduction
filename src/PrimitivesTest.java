import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void test() {
		int a = 10;
	}
	@Test
	@Disabled
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
	
	@Test
	void getBitValueTest() {
		long number = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
		
		number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		
		number = BitOperations.revertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
				
	}
	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	@Test
	void revertBitValueTest() {
		long number = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.revertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.revertBitValue(number, 0));
	}
}
 
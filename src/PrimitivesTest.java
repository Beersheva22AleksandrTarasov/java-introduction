import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void test() {
		// TODO
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
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
		assertEquals(-1, BitOperations.getBitValue(number, -2));

		number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));

		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));

	}

	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}

	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}

	@Test
	@Disabled
	void leadingNumberTest() {
		assertEquals(2, BitOperations.onesInNumber(5));
		assertEquals(6, BitOperations.onesInNumber(500));
		assertEquals(9, BitOperations.onesInNumber(14525));
	}

	@Test
	@Disabled
	void leadingZeroTest() {
		assertEquals(61, BitOperations.leadingZeros(5));
		assertEquals(55, BitOperations.leadingZeros(500));
		assertEquals(47, BitOperations.leadingZeros(100000));
	}

	@Test
	@Disabled
	void isHappyNumberTest() {
		int expectedTrue = 123321;
		int expectedFalse = 123467;
		assertTrue(Numbers.isHappyNumber(expectedTrue));
		assertFalse(Numbers.isHappyNumber(expectedFalse));
		assertEquals(true, Numbers.isHappyNumber(452650));
		assertEquals(false, Numbers.isHappyNumber(562123));
		assertEquals(true, Numbers.isHappyNumber(100001));
	}
	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = {1, 2, 3, 4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}
	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[]{1, 2, 3, 4}));			
		}
	
	@Test
	void getAddsNumberTest() {
		int arrayTest[] = {1, 3, 6, 5, 0};
		int number = 7;
		System.out.println(Arrays.toString(MyArrays.addsNumber(arrayTest, number)));
	}
	
	@Test
	void getRemoveNumber() {
		int arrTest[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int index = 5;
		System.out.println(Arrays.toString(arrTest));
		System.out.println(Arrays.toString(MyArrays.removeNumber(arrTest, index)));
	}
	
	@Test
	void getInsertSorted() {
		int arraySorted[] = {1, 2, 4, 5, 6, 7};
		int number = 3;
		System.out.println(Arrays.toString(MyArrays.insertSorted(arraySorted, number)));
	}
	
	@Test
	void getIsraelIdentity() {
		assertEquals(false, IsraelIdentity.verify(IsraelIdentity.generateRandomId(0, 9)));
		assertEquals(true, IsraelIdentity.verify(IsraelIdentity.generateRandomId(0, 9)));
	}
}

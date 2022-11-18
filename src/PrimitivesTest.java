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
		int expected[] = { 1, 2, 3, 4 };
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	@Disabled
	void getAddsNumberTest() {
		int arrayTest[] = { 1, 3, 6, 5, 0 };
		int number = 7;
		System.out.println(Arrays.toString(MyArrays.addsNumber(arrayTest, number)));
	}

	@Test
	@Disabled
	void getRemoveNumber() {
		int arrTest[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int index = 0;
		System.out.println(Arrays.toString(arrTest));
		System.out.println(Arrays.toString(MyArrays.removeNumber(arrTest, index)));
	}

	@Test
	@Disabled
	void getInsertSorted() {
		int arraySorted[] = { 1, 2, 4, 5, 6, 7 };
		int number = 1;
		System.out.println(Arrays.toString(MyArrays.insertSorted(arraySorted, number)));
	}

	@Test
	@Disabled
	void getIsraelIdentity() {
		assertEquals(false, IsraelIdentity.verify(445862792));
		assertEquals(true, IsraelIdentity.verify(445862790));
	}

	@Test
	@Disabled
	void getBinarySearch() {
		int[] arrayTest = { 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5 };
		assertEquals(3, MyArrays.binarySearch(arrayTest, 3));
		assertEquals(12, MyArrays.binarySearch(arrayTest, 4));
		assertEquals(15, MyArrays.binarySearch(arrayTest, 5));
		assertEquals(0, MyArrays.binarySearch(arrayTest, 1));
	}

	@Test
	@Disabled
	void getBubbleSort() {
		int[] bubbleSortTest1 = { 5, 3, 6, 8, 7, 6, 9, 15, 10, 20 };
		int[] bubbleSortTrue1 = { 3, 5, 6, 6, 7, 8, 9, 10, 15, 20 };
		int[] bubbleSortTest2 = {};
		int[] bubbleSortTrue2 = {};
		int[] bubbleSortTest3 = { 1, 2, 3, 4, 5 };
		int[] bubbleSortTrue3 = { 1, 2, 3, 4, 5 };
		assertArrayEquals(bubbleSortTrue1, MyArrays.bubbleSort(bubbleSortTest1));
		assertArrayEquals(bubbleSortTrue2, MyArrays.bubbleSort(bubbleSortTest2));
		assertArrayEquals(bubbleSortTrue3, MyArrays.bubbleSort(bubbleSortTest3));
	}

	@Test
	@Disabled
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = { 1, 3, 20, 4, 5, 6, 10 };
		int ar7[] = { 1, 3, 20, 4, 5, 11, 2 };
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
		assertFalse(MyArrays.isOneSwapForSorted(ar7));
	}

	@Test
	@Disabled
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
	}
	
	@Test
	void isSum2Test() {
		short array[] = {3, 1, 2, 5, 7, 5, 7, 1, 1, 0};
		short sum = 10;
		short sum1 = 20;
		assertEquals(true, MyArrays.isSumBoolean(array, sum));
		assertEquals(false, MyArrays.isSumBoolean(array, sum1));
		assertEquals(true, MyArrays.isSum1(array, sum));
		assertEquals(false, MyArrays.isSum1(array, sum1));
		short ar[] = {1, 2, 5, 4, 5, 100, 9, 0x7fff, 1};
		assertTrue(MyArrays.isSum2(ar, (short)101));
		assertTrue(MyArrays.isSum2(ar, (short)11));
		assertTrue(MyArrays.isSum2(ar, (short)14));
		assertFalse(MyArrays.isSum2(ar, (short)8));
		assertFalse(MyArrays.isSum2(ar, (short)2000));
		assertTrue(MyArrays.isSum2(ar, (short)(0x7fff + 1)));
	}
}

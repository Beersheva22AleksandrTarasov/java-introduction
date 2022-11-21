import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {

		Integer a = 11;

		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);
		assertTrue(c.equals(d));
	}

	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		System.out.println((byte) helloAr[0]);
		assertEquals(5, hello.length());
	}

	@Test
	void isAnagramTest() {
		
		String word = "yellow";
		
		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word,""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word,"yello"));
		assertFalse(Strings.isAnagram(word,"yelllo"));

		
	}
	
	@Test
	void sortStringNumbersTest() {
		String[] array = {"2", "10", "5", "10", "10", "5", "7", "-5"};
		String[] ar = {"-5", "2", "5", "5", "7", "10", "10", "10"};
		String[] array1 = {"100", "127", "-128", "0", };
		String[] ar1 = {"-128", "0", "100", "127"};
		
		assertArrayEquals(ar, Strings.sortStringNumbers(array));
		assertArrayEquals(ar1, Strings.sortStringNumbers(array1));
	}
}
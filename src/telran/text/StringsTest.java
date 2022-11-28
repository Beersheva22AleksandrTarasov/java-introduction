package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import static telran.text.Strings.*;
import org.junit.jupiter.api.*;

public class StringsTest {
	@Test
	@Disabled
	void isAnagramTest() {

		String word = "yellow";

		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));

	}

	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array = { "2", "10", "5", "10", "10", "5", "7", "-5" };
		String[] ar = { "-5", "2", "5", "5", "7", "10", "10", "10" };
		String[] array1 = { "100", "127", "-128", "0", };
		String[] ar1 = { "-128", "0", "100", "127" };

		assertArrayEquals(ar, Strings.sortStringNumbers(array));
		assertArrayEquals(ar1, Strings.sortStringNumbers(array1));
	}

	@Test
	@Disabled
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));

	}

	@Test
	@Disabled
	void ipV4OctetTest() {
		assertTrue("0".matches(ipV4Octet()));
		assertTrue("5".matches(ipV4Octet()));
		assertTrue("49".matches(ipV4Octet()));
		assertTrue("249".matches(ipV4Octet()));
		assertTrue("255".matches(ipV4Octet()));

		assertFalse("1111".matches(ipV4Octet()));
		assertFalse("256".matches(ipV4Octet()));
		assertFalse("_0".matches(ipV4Octet()));
	}

	@Test
	@Disabled
	void ipV4Test() {
		assertTrue("1.2.3.4".matches(ipV4()));
		assertTrue("255.199.249.209".matches(ipV4()));
		assertTrue("25.99.49.05".matches(ipV4()));

		assertFalse("1111.0.0.0".matches(ipV4()));
		assertFalse("256.0.0.0".matches(ipV4()));
		assertFalse("0.0.0".matches(ipV4()));
		assertFalse("-255.0.0.0".matches(ipV4()));
	}

	@Test
	void computeExpressionTest() {
		assertEquals(11.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 1.5", null, null));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5,
				computeArithmenticExpression("(a + 2) + (c * 2) + 0.5", new double[] { 2, 1 }, new String[] { "a", "c" }));
		assertTrue(Double.isNaN(
				computeArithmenticExpression("b + 2 + k * 2 + d23", new double[] { 2, 1 }, new String[] { "b", "k" })));
		assertEquals(0,
				computeArithmenticExpression("[a / {2 + c} - 2] * 2", new double[] { 2, 1 }, new String[] { "a", "c" }));
		assertTrue(Double.isNaN(
				computeArithmenticExpression("b + 2) + k * 2 + 0", new double[] { 2, 1 }, new String[] { "b", "k" })));
	}
}

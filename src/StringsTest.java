import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
	void ipV4OctetTest() {
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("5".matches(Strings.ipV4Octet()));
		assertTrue("49".matches(Strings.ipV4Octet()));
		assertTrue("249".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		

		assertFalse("1111".matches(Strings.ipV4Octet()));
		assertFalse("299".matches(Strings.ipV4Octet()));
		assertFalse("_0".matches(Strings.ipV4Octet()));
	}

	@Test
	void ipV4Test() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("255.199.5.15".matches(Strings.ipV4()));
		assertTrue("249.249.255.0".matches(Strings.ipV4()));

		assertFalse("1111.0.0.0".matches(Strings.ipV4()));
		assertFalse("256.0.0.0".matches(Strings.ipV4()));
		assertFalse(" 0.0.0.0".matches(Strings.ipV4()));
		assertFalse("-255.0.0.0".matches(Strings.ipV4()));
	}
}

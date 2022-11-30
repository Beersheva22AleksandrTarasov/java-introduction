package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;


public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(horizontalLine(30, 30));
	}
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(verticalLine(30, 5));
	}
	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(3, 9, 7));
	}
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(3, 9, 7));
	}
	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(3, 9, 7));
	}
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(3, 9, 7));
	}
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(3, 9, 7));
	}
	
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(3, 9, 7));
	}
	
	@Test
	@Disabled
	void sixTest() {
		displayStrings(six(3, 9, 7));
	}
	
	@Test
	@Disabled
	void sevenTest() {
		displayStrings(seven(3, 9, 7));
	}
	
	@Test
	@Disabled
	void eightTest() {
		displayStrings(eight(3, 9, 7));
	}
	
	@Test
	@Disabled
	void nineTest() {
		displayStrings(nine(3, 9, 7));
	}
	
	@Test
	void displayTest() {
		displayDigitalNumber(123456, 3, 9, 11);
	}
}

package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";

	public static void displayDigitalNumber(int number, int offset, int width, int height) {

		String numbersString = Integer.toString(number);
		char[] arrayNumber = new char[numbersString.length()];
		for (int i = 0; i < numbersString.length(); i++) {
			arrayNumber[i] = numbersString.charAt(i);
		}

		String[] resultArray = new String[height];
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = " ";
		}

		int index = 0;
		while (index < arrayNumber.length) {
			switch (arrayNumber[index]) {
			case '0':
				sumString(resultArray, zero(offset, width, height));
				break;
			case '1':
				sumString(resultArray, one(offset, width, height));
				break;
			case '2':
				sumString(resultArray, two(offset, width, height));
				break;
			case '3':
				sumString(resultArray, three(offset, width, height));
				break;
			case '4':
				sumString(resultArray, four(offset, width, height));
				break;
			case '5':
				sumString(resultArray, five(offset, width, height));
				break;
			case '6':
				sumString(resultArray, six(offset, width, height));
				break;
			case '7':
				sumString(resultArray, seven(offset, width, height));
				break;
			case '8':
				sumString(resultArray, eight(offset, width, height));
				break;
			case '9':
				sumString(resultArray, nine(offset, width, height));
				break;
			default:
				break;
			}
			index++;
		}
		displayStrings(resultArray);
	}

	private static void sumString(String[] resultArray, String[] currentNumber) {
		for (int i = 0; i < currentNumber.length; i++) {
			resultArray[i] = resultArray[i] + currentNumber[i];
		}
	}

	public static String horizontalLine(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	public static String[] halfVerticalLineRight(int offset, int width, int height) {
		height = height % 2 != 0 ? height += 1 : height;
		String[] res = new String[height / 2];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + " ".repeat(width - 1) + SYMBOL;
		}
		return res;
	}

	public static String[] halfVerticalLineLeft(int offset, int width, int height) {
		height = height % 2 != 0 ? height += 1 : height;
		String[] res = new String[height / 2];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] resNumberZero = new String[height];
		resNumberZero[0] = horizontalLine(offset, width);
		String[] twoVerticalLines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(twoVerticalLines, 0, resNumberZero, 1, twoVerticalLines.length);
		resNumberZero[height - 1] = horizontalLine(offset, width);
		return resNumberZero;
	}

	public static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, height);
	}

	public static String[] two(int offset, int width, int height) {
		String[] resNumberTwo = new String[height];
		resNumberTwo[0] = horizontalLine(offset, width);
		String[] halfLineVerticalBottomRight = halfVerticalLineRight(offset, width, height - 3);
		String[] halfLineVerticalUpperLeft = halfVerticalLineLeft(offset, width, height - 2);
		System.arraycopy(halfLineVerticalBottomRight, 0, resNumberTwo, 1, halfLineVerticalBottomRight.length);
		System.arraycopy(halfLineVerticalUpperLeft, 0, resNumberTwo, halfLineVerticalBottomRight.length + 2,
				halfLineVerticalUpperLeft.length);
		resNumberTwo[height / 2] = horizontalLine(offset, width);
		resNumberTwo[height - 1] = horizontalLine(offset, width);
		return resNumberTwo;
	}

	public static String[] three(int offset, int width, int height) {
		String[] resNumberThree = new String[height];
		resNumberThree[0] = horizontalLine(offset, width);
		String[] verticalLineRight = verticalLine(offset + width - 1, height - 1);
		System.arraycopy(verticalLineRight, 0, resNumberThree, 1, verticalLineRight.length);
		resNumberThree[height / 2] = horizontalLine(offset, width);
		resNumberThree[height - 1] = horizontalLine(offset, width);
		return resNumberThree;
	}

	public static String[] four(int offset, int width, int height) {
		String[] resNumberFour = new String[height];
		String[] twoVerticalHalfLinesUpper = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(twoVerticalHalfLinesUpper, 0, resNumberFour, 0, twoVerticalHalfLinesUpper.length);
		resNumberFour[height / 2] = horizontalLine(offset, width);
		String[] linesRight = halfVerticalLineRight(offset, width, height - 1);
		System.arraycopy(linesRight, 0, resNumberFour, linesRight.length + 1, linesRight.length);
		return resNumberFour;
	}

	public static String[] five(int offset, int width, int height) {
		String[] resNumberFive = new String[height];
		resNumberFive[0] = horizontalLine(offset, width);
		String[] halfLineVerticalUpperLeft = halfVerticalLineLeft(offset, width, height - 3);
		String[] halfLineVerticalBottomRight = halfVerticalLineRight(offset, width, height - 3);
		System.arraycopy(halfLineVerticalUpperLeft, 0, resNumberFive, 1, halfLineVerticalUpperLeft.length);
		System.arraycopy(halfLineVerticalBottomRight, 0, resNumberFive, halfLineVerticalUpperLeft.length + 2,
				halfLineVerticalBottomRight.length);
		resNumberFive[height / 2] = horizontalLine(offset, width);
		resNumberFive[height - 1] = horizontalLine(offset, width);
		return resNumberFive;
	}

	public static String[] six(int offset, int width, int height) {
		String[] resNumberSix = new String[height];
		resNumberSix[0] = horizontalLine(offset, width);
		String[] halfLineVerticalUpperLeft = halfVerticalLineLeft(offset, width, height - 3);
		String[] halfLineVerticalBottomRight = twoVerticalLines(offset, width, (height - 3) / 2);
		System.arraycopy(halfLineVerticalUpperLeft, 0, resNumberSix, 1, halfLineVerticalUpperLeft.length);
		System.arraycopy(halfLineVerticalBottomRight, 0, resNumberSix, halfLineVerticalUpperLeft.length + 2,
				halfLineVerticalBottomRight.length);
		resNumberSix[height / 2] = horizontalLine(offset, width);
		resNumberSix[height - 1] = horizontalLine(offset, width);
		return resNumberSix;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] resNumberSeven = new String[height];
		resNumberSeven[0] = horizontalLine(offset, width);
		String[] verticalLineRight = verticalLine(offset + width - 1, height - 1);
		System.arraycopy(verticalLineRight, 0, resNumberSeven, 1, verticalLineRight.length);
		return resNumberSeven;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] resNumberEight = new String[height];
		resNumberEight[0] = horizontalLine(offset, width);
		String[] halfVerticalTwoLinesUpper = twoVerticalLines(offset, width, (height - 3) / 2);
		String[] halfVerticalTwoLinesBottom = twoVerticalLines(offset, width, (height - 3) / 2);
		System.arraycopy(halfVerticalTwoLinesUpper, 0, resNumberEight, 1, halfVerticalTwoLinesUpper.length);
		System.arraycopy(halfVerticalTwoLinesBottom, 0, resNumberEight, halfVerticalTwoLinesUpper.length + 2,
				halfVerticalTwoLinesBottom.length);
		resNumberEight[height / 2] = horizontalLine(offset, width);
		resNumberEight[height - 1] = horizontalLine(offset, width);
		return resNumberEight;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] resNumberNine = new String[height];
		resNumberNine[0] = horizontalLine(offset, width);
		String[] twoVerticalHalfLinesUpper = twoVerticalLines(offset, width, (height - 3) / 2);
		String[] halfLineVerticalBottomRight = halfVerticalLineRight(offset, width, height - 3);
		System.arraycopy(twoVerticalHalfLinesUpper, 0, resNumberNine, 1, twoVerticalHalfLinesUpper.length);
		System.arraycopy(halfLineVerticalBottomRight, 0, resNumberNine, twoVerticalHalfLinesUpper.length + 2,
				halfLineVerticalBottomRight.length);
		resNumberNine[height / 2] = horizontalLine(offset, width);
		resNumberNine[height - 1] = horizontalLine(offset, width);
		return resNumberNine;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

	}
}

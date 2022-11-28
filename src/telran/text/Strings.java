package telran.text;

public class Strings {

	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 complexity O[N] two passes only
	 *         one additional array only symbols or English letters 1. the same
	 *         length 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean flag = false;
		byte helper[] = new byte[Byte.MAX_VALUE + 1];

		char[] strArray = str1.toCharArray();
		char[] arrayAnagram = str2.toCharArray();
		if (strArray.length == arrayAnagram.length) {
			flag = true;

			for (int i = 0; i < strArray.length; i++) {
				helper[(byte) strArray[i]]++;
				helper[(byte) arrayAnagram[i]]--;
			}
			for (int i = 0; i < helper.length; i++)
				if (helper[i] != 0) {
					flag = false;

				}
		}
		return flag;
	}

	public static String[] sortStringNumbers(String arrayString[]) {

		byte[] helper = new byte[256];
		String[] result = new String[arrayString.length];

		for (int i = 0; i < arrayString.length; i++) {
			helper[Integer.parseInt(arrayString[i]) + 128]++;
		}
		int index = 0;
		for (int j = 0; j < helper.length; j++) {
			for (int k = helper[j]; k > 0; k--) {
				result[index++] = Integer.toString(j - 128);
			}
		}
		return result;
	}

	public static String javaNameExp() {

		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}

	public static String ipV4Octet() {

		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}

	public static String ipV4() {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}

	private static String arithmeticExpression() {
		String operandExp = operand();
		String operatorExp = operator();
		String bracesOpen = bracesOpen();
		String bracesClose = brecesClose();

		return String.format("%3$s%1$s(%2$s%3$s%1$s%4$s)*", operandExp, operatorExp, bracesOpen, bracesClose);
	}

	private static String brecesClose() {

		return "(\\]*\\}*\\)*)";
	}

	private static String bracesOpen() {

		return "(\\[*\\{*\\(*)";
	}

	private static String operand() {

		return String.format("(\\d+\\.?\\d*|\\.\\d+|%1$s)", javaNameExp());
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {

		return "([-+*/])";
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {

		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()\\[\\]\\{}]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}

		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {
			switch (operator) {
			case "+":
				res = operand1 + operand2;
				break;
			case "-":
				res = operand1 - operand2;
				break;
			case "*":
				res = operand1 * operand2;
				break;
			case "/":
				res = operand1 / operand2;
				break;
			default:
				res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		Double res = Double.NaN;
		if (operand.matches("(\\d+\\.?\\d*|\\.\\d+)")) {
			res = Double.parseDouble(operand);
		}

		if (operand.matches(javaNameExp()) && values != null && names != null) {

			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(operand)) {
					res = values[i];

				}
			}

		}

		return res;
	}

	public static boolean checkBraces(String expression) {
		char expressionBraces[] = expression.toCharArray();
		boolean flag = true;

		if (countBraces(expressionBraces) != 0) {
			flag = false;
		}
		return flag;
	}

	private static int countBraces(char[] expressionBraces) {
		int count = 0;
		for (int i = 0; i < expressionBraces.length; i++) {
			if (expressionBraces[i] == '(') {
				count++;
			}
			if (expressionBraces[i] == ')') {
				count--;
				if (count == -1) {
					break;
				}
			}
		}
		return count;
	}

}
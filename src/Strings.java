
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
		
		return "\\d\\d|0|1\\d{0,2}|2([0-4]\\d|5[0-5])";
	}

	public static String ipV4() {
		
		return "((\\d{0,2}|0|1\\d{0,2}|2([0-4][\\d]|5[0-5]))\\.){3}([0-9]\\d|0|1\\d{0,2}|2([0-4][\\d]|5[0-5]))";
	}

}
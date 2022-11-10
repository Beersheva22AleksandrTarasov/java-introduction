
public class IsraelIdentity {
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false number control sum should be
	 *         multiple of 10 (sum % 10 == 0) for even indexes (0, 2, 4, 6, 8)
	 *         digits as is for add indexes (1, 3, 5, 7, 9) digits = digit * 2, if >
	 *         9 the sum of inner digits is taken example, 123456782 => 1 + 4(2 * 2)
	 *         + 3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6)
	 *         + 2
	 */

	public static boolean verify(int id) {

		boolean res = false;
		int[] arrayIdNumber = Numbers.getDigits(id);
		int sumIdNumbers = 0;
		for (int i = 0; i < arrayIdNumber.length; i++) {
			if (i % 2 == 0) {
				sumIdNumbers += arrayIdNumber[i];
			} else {
				int result = arrayIdNumber[i] * 2;
				int result1 = (result > 10) ? ((result / 10) + (result % 10)) : result;
				sumIdNumbers += result1;
			}
		}
		if (sumIdNumbers % 10 == 0) {
			res = true;
		}
		return res;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id cycle not more
	 *         than 9 iterations
	 */

	public static int generateRandomId(int min, int max) {
		int[] arrayId = new int[9];
		for (int i = 0; i < 9; i++) {
			arrayId[i] = (int) (min + Math.random() * (max - min + 1));
		}
		int id = Numbers.getNumberFromDigits(arrayId);
		return id;
	}

}


/**
 * right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */
public class BitOperations {
/**
 * 
 * @param number - any number
 * @param nBit - number of bit
 * @return value of bit with number nBit
 */
	static public int getBitValue(long number, int nBit) {
			int res = -1;
		if (checkNbit(nBit)) {
			long mask = 1 << nBit; //all bits are - except bit with number nBit
			if ((number & mask) == 0) {
				res = 0;
			} else {
				res = 1;
			}
		}
		return res;
	}
	private static boolean checkNbit(int nBit) {
	
		return nBit < 64 && nBit > -1;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @param b - true for 1, false for 0
	 * @return new number in which value of nBit'h bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean b) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = 1 << nBit;
			if (b == true) {
				res = number | mask;
			} else {
				res = number ^ mask;
			}
			} 
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return - new number in which nBit'h will be replaced (old value - 1, new value - 0)
	 */
	static public long revertBitValue(long number, int nBit) {
		if (checkNbit(nBit)) {	
			long mask = 1 << nBit;
				number ^= mask;
			return number;
		}
		return -1;
	}
}
	

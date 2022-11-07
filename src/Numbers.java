
public class Numbers {
static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while(number != 0);
	return res;
}

/**
 * 
 * @param number
 * @return true only if number comprises of 6 digits
 * and sum of first three digits equals the sum of last three digits
 */

static public boolean isHappyNumber(int number) {
	int firstThreeNum = number / 1000;
	int secondThreeNum = number % 1000;
	
	return (getSumDigits(firstThreeNum) == getSumDigits(secondThreeNum)) ? true : false;	
}	
	
	public static int getSumDigits(int num) {
		int result = 0; 
		
		while(num != 0) {
			result += num % 10;
			num /= 10;
		}
		return result;
		
		//	return (num / 100) + (num / 10 % 10) + (num % 10);
	}


 
}

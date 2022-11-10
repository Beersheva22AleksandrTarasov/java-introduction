import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[array.length] = number;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array if index
	 *         doesn't exist in a given array it returns the same array
	 */

	public static int[] removeNumber(int[] array, int index) {
		int[] arrayres = array;
		if (index < array.length) {
			arrayres = new int[array.length - 1];
			System.arraycopy(array, 0, arrayres, 0, index);
			System.arraycopy(array, index + 1, arrayres, index, array.length - index - 1);
		}
		return arrayres;
	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		
		int index = Arrays.binarySearch(arraySorted, number);
		index = (index < 0) ? Math.abs(index) - 1 : index;
		int[] arrayres = new int[arraySorted.length + 1];
		
		System.arraycopy(arraySorted, 0, arrayres, 0, index);
		arrayres[index] = number;
		System.arraycopy(arraySorted, index, arrayres, index + 1, arraySorted.length - index);
		
		return arrayres;
	}

}

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
		if (index > -1 && index < array.length) {
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

	/**
	 * 1. Update method binarySearch in the class MyArrays such that if a being
	 * searched number is encountered several times in a given sorted array the
	 * method should return the first index value, otherwise (no number in a given
	 * array) the method should return the same negative value as the Java standard
	 * Arrays.binarySearch does 1.1. Complexity of the method should be O[LogN]
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index of first number or if number not exists in array return -1
	 */

	public static int binarySearch(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int res = 0;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (number == arraySorted[middle]) {
				res = middle;
				right = middle - 1;
			} else if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return arraySorted[res] == number ? res : -1;
	}

	/**
	 * 3.1. Bubble sort implies repeated moving greater values toward the end of
	 * array until array is sorted. The moving is done by swapping between two
	 * adjacent array elements (i with i+1). Consider method swap. 3.2. Apply
	 * additional private method moveGreaterRight that in the cycle compares I-th
	 * element with I+1-th element and if I-th value greater than I+1-th one the
	 * swap is performed, thus it moves the greater value to right. 3.3.
	 * Requirements: 3.3.1. Most effective algorithm in the class of algorithms O[N
	 * ^ 2] 3.3.2. The minimal number of iterations (the array is already sorted)
	 * should be N 3.3.3. The maximal number of iterations should be N * (N + 1) / 2
	 * 
	 * @param unSortArray
	 * @return sortedArray
	 */

	static boolean FLAG = false;

	public static int[] bubbleSort(int unSortedArray[]) {
		while (!FLAG) {
			FLAG = true;
			for (int i = 0; i < unSortedArray.length - 1; i++)
				moveGreaterRight(unSortedArray, i);
		}
		return unSortedArray;
	}

	private static void moveGreaterRight(int sortedArray[], int j) {
		if (sortedArray[j] > sortedArray[j + 1]) {
			int tempVar = sortedArray[j];
			sortedArray[j] = sortedArray[j + 1];
			sortedArray[j + 1] = tempVar;

			FLAG = false;
		}
	}

	/**
	 * Write method isOneSwapForSorted in the class MyArrays that takes an array
	 * and returns true if the array is unsorted but only one swap between two
	 * numbers is required for getting a sorted array.
	 * 
	 * @param arrayUnSorted[]
	 */

	
	public static int isOneSwapForSorted(int arrayUnSorted[]) {
		int a = 0;
		for (int i = 1; i < arrayUnSorted.length; i++) {
			int current = arrayUnSorted[i];
			int j = i;
			while (j > 0 && arrayUnSorted[j - 1] > current) {
				arrayUnSorted[j] = arrayUnSorted[j - 1];
				j--;
				a++;
			}
			arrayUnSorted[j] = current;
		}
		return a;
	}
}

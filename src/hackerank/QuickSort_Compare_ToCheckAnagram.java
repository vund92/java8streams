package hackerank;

import java.util.Scanner;

public class QuickSort_Compare_ToCheckAnagram {
	static boolean isAnagram(String a, String b) {
		char[] charListA = new char[a.length()];
		char[] charListB = new char[b.length()];

		String aUpString = a.toUpperCase();
		String bUpString = b.toUpperCase();

		for (int i = 0; i < aUpString.length(); i++) {
			charListA[i] = aUpString.charAt(i);
		}

		for (int i = 0; i < bUpString.length(); i++) {
			charListB[i] = bUpString.charAt(i);
		}

		char[] c = quickSort(charListA, 0, charListA.length - 1);
		char[] d = quickSort(charListB, 0, charListB.length - 1);

		return compare2Arrays(c, d);
	}

	public static char[] quickSort(char[] arr, int low, int high) {
		if (low < high) {
			// Partition the array into two sub-arrays and get the pivot index
			int pivotIndex = partition(arr, low, high);

			// Recursively sort the sub-arrays
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
		return arr;
	}

	private static int partition(char[] arr, int low, int high) {
		// Choose the rightmost element as the pivot
		char pivot = arr[high];

		// Index of the smaller element
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			// If the current element is smaller than or equal to the pivot
			if (arr[j] <= pivot) {
				i++;

				// Swap arr[i] and arr[j]
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Swap arr[i+1] and arr[high] (pivot)
		char temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static boolean compare2Arrays(char[] a, char[] b) {

		if (a.length != b.length) {
			return false; // Arrays have different lengths, not equal
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}

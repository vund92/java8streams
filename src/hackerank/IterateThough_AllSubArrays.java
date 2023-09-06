package hackerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IterateThough_AllSubArrays {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

//		Scanner scanner = new Scanner(System.in);
//
//		int n = scanner.nextInt();
//		int[] a = new int[n];
//
//		for (int i = 0; i < n; i++) {
//			a[i] = scanner.nextInt();
//		}
//
//		List<int[]> subArrays = new ArrayList<int[]>();
//
//		for (int i = 1; i <= n; i++) {
//			int numToTake = i;
//			
//			for (int j = 0; j < n; j++) {
//				int[] arrayTemp = new int[numToTake];
//				int index = j;
//				int flagToEnd = n-1;
//				for (int k = 0; k < numToTake; k++) {
//					if (index < n) {
//						arrayTemp[k] = a[index];
//						index++;
//					}
//				}
//				subArrays.add(arrayTemp);
//			}
//		}
//
//		int count = 0;
//		for (int[] array : subArrays) {
//			int sumTemp = 0;
//			for (int j = 0; j < array.length; j++) {
//				sumTemp += array[j];
//			}
//			if (sumTemp < 0)
//				count++;
//
//			// ==========
//			// Construct the string representation of the int array
//			StringBuilder sb = new StringBuilder("[");
//			for (int i = 0; i < array.length; i++) {
//				sb.append(array[i]);
//				if (i < array.length - 1) {
//					sb.append(", ");
//				}
//			}
//			sb.append("]");
//			// ==========
//
//			// Print the formatted string
//			System.out.println(sb.toString());
//		}
//
//		System.out.println(count);
		
		Scanner scanner = new Scanner(System.in);

        // Read the length of the array
        int n = scanner.nextInt();

        // Read the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Initialize a variable to count negative subarrays
        int negativeSubarrayCount = 0;

        // Loop through all possible subarrays
        for (int start = 0; start < n; start++) {
            int subarraySum = 0;
            for (int end = start; end < n; end++) {
                // Calculate the sum of the current subarray
                subarraySum += arr[end];

                // If the sum is negative, increment the count
                if (subarraySum < 0) {
                    negativeSubarrayCount++;
                }
            }
        }

        // Print the count of negative subarrays
        System.out.println(negativeSubarrayCount);

        scanner.close();
	}
}

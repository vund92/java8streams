package hackerank;

/**
 We call an array switching if all numbers in even positions are equal and all numbers in odd positions are equal.
For example: [3, -7, 3, -7, 3] and [4, 4, 4] are switching, but [5, 5, 4, 5, 4] and [-3, 2, 3] are not switching.
What is the length of the longest switching slice (continuous fragment) in a given array A? Write a function:
class Solution { public int solution (int[] A); }
that, given an array A consisting of N integers, returns the length of the longest switching slice in A.
Examples:
1. Given A = [3, 2, 3, 2, 3], the function should return 5, because the whole array is switching. 2. Given A = [7, 4, −2, 4, −2, −9], the function should return 4. The longest switching slice is [4, -2, 4, -2].
3. Given A = [7, -5, -5, -5, 7, -1, 7], the function should return 3. There are two switching slices of equal length: [-5, -5, -5] and [7, -1, 7].
4. Given A = [4], the function should return 1. A single-element slice is also a switching slice. Write an efficient algorithm for the following assumptions:
• N is an integer within the range [1..100,000];
• each element of array A is an integer within the range [-1,000,000,000..1,000,000,000].
**/

import java.util.*;
import java.io.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Codility_Array_Switching {
	public int solution(int[] A) {
		List<List<Integer>> combinations = creatCombinations(A);
		int countFinal = 0;
		for (List<Integer> list : combinations) {
			int count = 0;
			int[] a = convertListToArray(list);
			if (isSwitching(a)) {
				count = a.length;
			}
			countFinal = Math.max(countFinal, count);
		}
		return countFinal;
	}

	public static int[] convertListToArray(List<Integer> list) {
		int[] array = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}

		return array;
	}

	public static List<List<Integer>> creatCombinations(int[] array) {
		List<List<Integer>> result = new ArrayList<>();
		createAllCombinationsOfElementsOfArrayFactory(array, 0, new ArrayList<>(), result);
		return result;
	}

	public static void createAllCombinationsOfElementsOfArrayFactory(int[] num, int index, List<Integer> current,
			List<List<Integer>> result) {
		result.add(new ArrayList<>(current));

		for (int i = index; i < num.length; i++) {
			current.add(num[i]);
			createAllCombinationsOfElementsOfArrayFactory(num, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}

	public boolean isSwitching(int[] A) {
		int n = A.length;

		if (n <= 1) {
			return true; // An array with 0 or 1 element is switching by definition
		}

		int evenValue = A[0];
		int oddValue = A[1];

		for (int i = 2; i < n; i++) {
			if (i % 2 == 0) {
				if (A[i] != evenValue) {
					return false;
				}
			} else {
				if (A[i] != oddValue) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Codility_Array_Switching solution = new Codility_Array_Switching();
		int[] A1 = { 1 };
		int[] A2 = {7, -5, -5, -5, 7, -1, 7};
		int[] A3 = {7, 4, -2, 4, -2, -9};
		int[] A4 = {3, 2, 3, 2, 3};
		int[] A5 = {3, 2};
		int[] A6 = {3, 3};
		System.out.println(solution.solution(A1)); //1
		System.out.println(solution.solution(A2)); //3
		System.out.println(solution.solution(A3)); //4
		System.out.println(solution.solution(A4)); //5
		System.out.println(solution.solution(A5)); //2
		System.out.println(solution.solution(A6)); //2
	}
}

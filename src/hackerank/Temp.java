package hackerank;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Temp {
	public int solution(int[] A) {

		List<List<Integer>> combinations = creatCombinations(A);
		Set<Integer> unique = new HashSet<>();
		int countFinal = 0;
		if (combinations.size() <= 1 && combinations.get(0).size() <= 1) {
			countFinal++;
		} else {
			for (List<Integer> list : combinations) {
				int count = 0;
				Set<Integer> uniqueOdd = new HashSet<>();
				Set<Integer> uniqueEven = new HashSet<>();

				if (list.size() <= 1 && combinations.size() <= 1) {
					return countFinal = list.size();
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (i % 2 != 0) {
							uniqueOdd.add(list.get(i));
							count++;
						} else {
							uniqueEven.add(list.get(i));
							count++;
						}
					}
				}
				if (uniqueOdd.size() == 1 && uniqueEven.size() == 1) {
					countFinal = Math.max(countFinal, count);
				}
			}
		}
		return countFinal;
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
		int[] A = { 1 };
		System.out.println(solution.solution(A));
	}
}

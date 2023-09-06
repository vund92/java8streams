package hackerank;

/**﻿
There is an array A made of N integers. Your task is to choose as many integers from A as possible so that, when they are put in ascending order, all of the differences between all pairs of consecutive integers are equal.
For example, for A = [4, 3, 5, 1, 4, 4], you could choose 1, 3 and 5 (with differences equal to 2) or 4, 4 and 4 (with differences equal to 0).
What is the maximum number of integers that can be chosen?

Write a function:
class Solution { public int solution (int[] A); }
that, given an array A made of N integers, returns the maximum number of integers that can be chosen following the rules described above.

Examples:
1. For A = [4, 7, 1, 5, 3], the function should return 4. It is possible to choose four integers (7, 1, 5 and 3). When put in ascending order, the difference between all consecutive integers is 2.
2. For A = [12, 12, 12, 15, 10], the function should return 3. It is optimal to choose all integers with a value of 12.
3. For A = [18, 26, 18, 24, 24, 20, 22], the function should return 5. Five integers (18, 20, 22, 24, 26) can be chosen. Notice that we cannot pick any other integers, even though they occur more than once.
**/

import java.util.ArrayList;
import java.util.List;

public class Codility_Differences_Between_All_Pairs_Are_Equal{

	public static int solution(int[] A) {

		List<List<Integer>> allPossibleGroupsOfElements = createAllPossibleGroupsOfElements(A);

		for (List<Integer> group : allPossibleGroupsOfElements) {
			System.out.println(group);
		}

		int size = 0;
		for (List<Integer> group : allPossibleGroupsOfElements) {
			boolean resullt = checkSameDifferences(convertListToArray(group));
			if (resullt == true && size < group.size()) {
				size = group.size();
			}
		}
		
		System.out.println("the maximum number of integers that can be chosen: " + size);
		return size;
	}
	
	public static List<List<Integer>> createAllPossibleGroupsOfElements(int[] array) {
        List<List<Integer>> listOfAllPossibleGroupsOfElements = new ArrayList<>();
        createAllPossibleGroupsOfElementsFactory(listOfAllPossibleGroupsOfElements, new ArrayList<>(), array, 0);
        return listOfAllPossibleGroupsOfElements;
    }

    private static void createAllPossibleGroupsOfElementsFactory(
            List<List<Integer>> listOfAllPossibleGroupsOfElements, List<Integer> currentGroup, int[] array, int index) {
        if (index == array.length) {
            listOfAllPossibleGroupsOfElements.add(new ArrayList<>(currentGroup)); // Add a copy of the group
            return;
        }

        // Include the current element in the group
        currentGroup.add(array[index]);
        createAllPossibleGroupsOfElementsFactory(listOfAllPossibleGroupsOfElements, currentGroup, array, index + 1);

        // Exclude the current element from the group
        currentGroup.remove(currentGroup.size() - 1);
        createAllPossibleGroupsOfElementsFactory(listOfAllPossibleGroupsOfElements, currentGroup, array, index + 1);
    }

	public static boolean checkSameDifferences(int[] arr) {
		int n = arr.length;
		
		if (n <= 2) {
			return false;
		}
		
		int sameDifference = arr[1] - arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] != sameDifference) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] convertListToArray(List<Integer> integerList) {
		int[] intArray = new int[integerList.size()];
		for (int i = 0; i < integerList.size(); i++) {
			intArray[i] = integerList.get(i);
		}
		return intArray;
	}

	public static void main(String[] args) {
		int[] A = { 12,12,12,15,10};
		solution(A);
	}
}


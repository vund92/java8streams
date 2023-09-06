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

public class GenerateAllCombinationsOfElementsOfList{

//	public static void main(String[] args) {
//        int[] array = { 12,12,12,15,10}; 
//        List<List<Integer>> combinations = generateCombinations(array);
//        
//        // Print all combinations
//        for (List<Integer> combination : combinations) {
//            System.out.println(combination);
//        }
//    }
//
//    public static List<List<Integer>> generateCombinations(int[] array) {
//        List<List<Integer>> result = new ArrayList<>();
//        generateCombinationsHelper(result, new ArrayList<>(), array, 0);
//        return result;
//    }
//
//    private static void generateCombinationsHelper(
//            List<List<Integer>> result, List<Integer> currentCombination, int[] array, int index) {
//        if (index == array.length) {
//            result.add(new ArrayList<>(currentCombination)); // Add a copy of the combination
//            return;
//        }
//
//        // Include the current element in the combination
//        currentCombination.add(array[index]);
//        generateCombinationsHelper(result, currentCombination, array, index + 1);
//
//        // Exclude the current element from the combination
//        currentCombination.remove(currentCombination.size() - 1);
//        generateCombinationsHelper(result, currentCombination, array, index + 1);
//    }
	
	public static List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current combination to the result
        result.add(new ArrayList<>(current));

        // Generate combinations by including each element from the current index onward
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateCombinationsHelper(nums, i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combinations = generateCombinations(nums);

        // Print the generated combinations
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}


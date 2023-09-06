package hackerank;

/**﻿
Charlemagne, the King of Frankia, is considering building some castles on the border with Servia. The border is divided into N segments. The King knows the height of the terrain in each segment of the border. The height of each segment of terrain is stored in array A, with A[P] denoting the height of the P-th segment of the border. The King has decided to build a castle on top of every hill and in the bottom of every valley.
Let [P..Q] denote a group of consecutive segments from P to Q inclusive such that (0 ≤ P ≤ Q≤N-1). Segments [P..Q] form a hill or a valley if all the following conditions are satisfied:
• The terrain height of each segment from P to Q is the same (A[P] = A[P+1] =
= A[Q]);
• If P > 0 then A[P-1] < A[P] (for a hill) or A[P-1] > A[P] (for a valley);
• If Q < N−1 then A[Q+1] < A[Q] (for a hill) or A[Q+1] > A[Q] (for a valley);
That is, a hill is higher than its surroundings and a valley is lower than its surroundings. Note that if the surroundings on either side of the hill or valley don't exist (i.e. at the edges of the area under consideration, where P = 0 or Q = N-1), then the condition is considered satisfied for that side of the hill/valley.
The king is wondering how many castles is he going to build. Can you help him?
For example, consider the following array A = [2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5].
﻿There are two hills: [3..3] and [11..11]. There are also two valleys: [0..1] and [8..9]. There are no other suitable places for castles.
Write a function:
class Solution { public int solution (int[] A); }
that, given an array A consisting of N integers, as explained above, returns the total number of hills and valleys.
For example, given array A as described above, the function should return 4.
Given array A = [-3, -3] describing segments with a terrain height below 0, segment [0..1] forms both a hill and a valley, and only one castle can be built, so the function should return 1.
Write an efficient algorithm for the following assumptions:
• N is an integer within the range [1..100,000];
• each element of array A is an integer within the range [-1,000,000,000..1,000,000,000].
**/

import java.util.*;

class Codility_Castles_Built_On_Hills_And_Valeys {
	public static int calculateCastles(int[] A) {
	    List<Integer> listOfElementsWithoutConsecutiveDuplicates = new ArrayList<>();

	    listOfElementsWithoutConsecutiveDuplicates = removeSuccessiveDuplicates(A);

	    if (listOfElementsWithoutConsecutiveDuplicates.size() == 1) {
	        return 1;
	    }
	    
	    int valeysBettweenTheFirstAndTheLastElement = 0;
	    int hillsBettweenTheFirstAndTheLastElement= 0;
	    
	    // checking the graph extremes for local maxima & minima
	    if (listOfElementsWithoutConsecutiveDuplicates.get(0) < listOfElementsWithoutConsecutiveDuplicates.get(1)) {
	    	valeysBettweenTheFirstAndTheLastElement++;
	    }

	    if (listOfElementsWithoutConsecutiveDuplicates.get(0) > listOfElementsWithoutConsecutiveDuplicates.get(1)) {
	    	hillsBettweenTheFirstAndTheLastElement++;
	    }

	    if (listOfElementsWithoutConsecutiveDuplicates.get(listOfElementsWithoutConsecutiveDuplicates.size() - 1) < listOfElementsWithoutConsecutiveDuplicates.get(listOfElementsWithoutConsecutiveDuplicates.size() - 2)) {
	    	valeysBettweenTheFirstAndTheLastElement++;
	    }

	    if (listOfElementsWithoutConsecutiveDuplicates.get(listOfElementsWithoutConsecutiveDuplicates.size() - 1) > listOfElementsWithoutConsecutiveDuplicates.get(listOfElementsWithoutConsecutiveDuplicates.size() - 2)) {
	    	hillsBettweenTheFirstAndTheLastElement++;
	    }

	    // checking the rest of the graph for local maxima & minima
	    for (int i = 1; i < listOfElementsWithoutConsecutiveDuplicates.size() - 1; i++) {
	        if (listOfElementsWithoutConsecutiveDuplicates.get(i + 1) < listOfElementsWithoutConsecutiveDuplicates.get(i) && listOfElementsWithoutConsecutiveDuplicates.get(i - 1) < listOfElementsWithoutConsecutiveDuplicates.get(i)) {
	        	hillsBettweenTheFirstAndTheLastElement++;
	        }
	        if (listOfElementsWithoutConsecutiveDuplicates.get(i + 1) > listOfElementsWithoutConsecutiveDuplicates.get(i) && listOfElementsWithoutConsecutiveDuplicates.get(i - 1) > listOfElementsWithoutConsecutiveDuplicates.get(i)) {
	        	valeysBettweenTheFirstAndTheLastElement++;
	        }
	    }
	    return hillsBettweenTheFirstAndTheLastElement + valeysBettweenTheFirstAndTheLastElement;
	}
	
	public static List<Integer> removeSuccessiveDuplicates(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return List.of(A[0]); // No duplicates to remove if the array has 0 or 1 elements
        }
        List<Integer> result = new ArrayList<>();
        result.add(A[0]); // Add the first element to the result
        for (int i = 1; i < n; i++) {
            if (A[i] != A[i - 1]) {
                // If the current element is not the same as the previous element, add it to the result
                result.add(A[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    	Codility_Castles_Built_On_Hills_And_Valeys solution = new Codility_Castles_Built_On_Hills_And_Valeys();

        int[] A1 = {2, 1, 3, 2, 1, 4, 5, 3, 2};
        System.out.println(solution.calculateCastles(A1));

        int[] A2 = {1, 2, 3, 4, 5};
        System.out.println(solution.calculateCastles(A2)); 

        int[] A3 = {5, 4, 3, 2, 1};
        System.out.println(solution.calculateCastles(A3)); 
        
        int[] A4 = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        System.out.println(solution.calculateCastles(A4)); 
        
//        int[] A5 = {};
//        System.out.println(solution.calculateCastles(A5)); 
        
        int[] A6 = {1};
        System.out.println(solution.calculateCastles(A6)); 
    }

}

package hackerank;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Draft {
	public int solution(int[] A) {
        int maxSwitchingLength = 1; // Initialize with at least 1 for single-element slice
        int currentSwitchingLength = 1; // Initialize with at least 1 for the first element

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                currentSwitchingLength++;
            } else {
                maxSwitchingLength = Math.max(maxSwitchingLength, currentSwitchingLength);
                currentSwitchingLength = 1;
            }
        }

        return Math.min(maxSwitchingLength, A.length);
    }

    public static void main(String[] args) {
    	Draft solution = new Draft();

        int[] A1 = {3, 2, 3, 2, 3};
        int result1 = solution.solution(A1);
        System.out.println(result1); // Expected output: 5

        int[] A2 = {7, 4, -2, 4, -2, -9};
        int result2 = solution.solution(A2);
        System.out.println(result2); // Expected output: 4

        int[] A3 = {7, -5, -5, -5, 7, -1, 7};
        int result3 = solution.solution(A3);
        System.out.println(result3); // Expected output: 3

        int[] A4 = {4};
        int result4 = solution.solution(A4);
        System.out.println(result4); // Expected output: 1
    }
}

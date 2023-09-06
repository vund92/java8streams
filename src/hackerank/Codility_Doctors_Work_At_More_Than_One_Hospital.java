package hackerank;

/**﻿
There are N hospitals, numbered from 0 to N-1. You are given a schedule of work in each of the hospitals for the following M days. The schedule is provided in the form of a two- dimensional array A containing N rows, each row representing the schedule of one hospital, and M columns, each column representing one day. Integer A[K][L] (for K within the range [0..N-1] and L within the range [0..M−1]) represents the ID of the doctor working at hospital K on day L. Note that sometimes an individual doctor may work at more than one hospital even on the same day.
Write a function:
class Solution { public int solution (int[][] A); }
that, given a matrix A consisting of N rows and M columns representing the hospitals' schedules, finds the number of doctors working at more than one hospital.
Examples:
1. Given A = [[1, 2, 2], [3, 1, 4] ], the function should return 1.
The doctor with ID 1 works at both hospitals. The doctor with ID 2 works only at hospital number 0, while the doctors with IDs 3 and 4 work only at hospital number 1.
2. Given A = [[1, 1, 5, 2, 3], [4, 5, 6, 4, 3], [9, 4, 4, 1, 5] ], the function should return 4.
The doctors with IDs 1, 3, 4 and 5 work at more than one hospital.
3. Given A = [[4, 3], [5, 5], [6, 2] ], the function should return 0.
Each doctor works only at one hospital.
Write an efficient algorithm for the following assumptions:
•	N and M are integers within the range [1..1,000];
•	each element of matrix A is an integer within the range [1..N*M].
**/

import java.util.*;

class Codility_Doctors_Work_At_More_Than_One_Hospital {
	public int solution(int[][] A) {
		int n = A.length; // Number of hospitals (row = x)
		int m = A[0].length; // Number of days (colum = y)

		List<HashSet<Integer>> doctorsSetOfEachHospital = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < n; i++) {
			HashSet<Integer> doctorsSetOfHospital = new HashSet<Integer>();
			for (int j = 0; j < m; j++) {
				doctorsSetOfHospital.add(A[i][j]); // get distinct Doctors.
			}
			doctorsSetOfEachHospital.add(doctorsSetOfHospital);
		}

		int count = 0;
		List<Integer> iDList = new ArrayList<>();  //create a List of Docs
		List<Integer> iDListOfDuplicatedRemoved = new ArrayList<>();  //if Doc duplicated, it is removed from iDList and moved to iDListOfDuplicatedRemoved for comparison
		for (HashSet<Integer> doctorSet : doctorsSetOfEachHospital) {
			for (Integer doctorID : doctorSet) {
				if (!iDListOfDuplicatedRemoved.contains(doctorID)) {
					if (iDList.contains(doctorID)) {
						count++;
						iDList.remove(doctorID);
						iDListOfDuplicatedRemoved.add(doctorID);
					} else {
						iDList.add(doctorID);
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Codility_Doctors_Work_At_More_Than_One_Hospital solution = new Codility_Doctors_Work_At_More_Than_One_Hospital();

		int[][] A1 = { { 1, 2, 2 }, { 3, 1, 4 } };
		System.out.println(solution.solution(A1)); // Expected output: 1

		int[][] A2 = { { 1, 1, 5, 2, 3 }, { 4, 5, 6, 4, 3 }, { 9, 4, 4, 1, 5 } };
		System.out.println(solution.solution(A2)); // Expected output: 4

		int[][] A3 = { { 4, 3 }, { 5, 5 }, { 6, 2 } };
		System.out.println(solution.solution(A3)); // Expected output: 0

		int[][] A4 = { { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 1 } };
		System.out.println(solution.solution(A4));
		
		int[][] A5 = { { }, { }, { }, { } };
		System.out.println(solution.solution(A5));
	}

}

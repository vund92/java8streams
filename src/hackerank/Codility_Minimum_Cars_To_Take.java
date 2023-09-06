package hackerank;

/**﻿

A group of friends is going on holiday together. They have come to a meeting point (the start of the journey) using N cars. There are P[K] people and S[K] seats in the K-th car for K in range [0..N-1]. Some of the seats in the cars may be free, so it is possible for some of the friends to change the car they are in. The friends have decided that, in order to be ecological, they will leave some cars parked at the meeting point and travel with as few cars as possible.
Write a function: 
class Solution { public int solution (int[] P, int[] S); }
that, given two arrays P and S, consisting of N integers each, returns the minimum number of cars needed to take all of the friends on holiday. 

Examples:
1. Given P = [1, 4, 1] and S = [1, 5, 1], the function should return 2. A person from car number 0 can travel in car number 1 instead. This way, car number 0 can be left parked at the meeting point.
2. Given P = [4, 4, 2, 4] and S = [5, 5, 2, 5], the function should return 3. One person from car number 2 can travel in car number 0 and the other person from car number 2 can travel in car number 3.
3. Given P = [2, 3, 4, 2] and S = [2, 5, 7, 2], the function should return 2. Passengers from car number 0 can travel in car number 1 and passengers from car number 3 can travel in car number 2.

**/

import java.util.*;

class Codility_Minimum_Cars_To_Take {
	public static int solution(int[] P, int[] S) {
		int sumOfP = sumofIntInArray(P);
		Arrays.sort(S);
		reverse(S);
		
		int coutOfCars = 0;
		for(int i = 0; i<S.length; i++) {
			sumOfP = sumOfP-S[i];
			if(sumOfP > 0 ) {
				coutOfCars++;
			}else{
				coutOfCars++;
				break;
			}
		}
		return coutOfCars;
	}
	
	public static void reverse(int[] array)
    {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
	
	public static int sumofIntInArray(int[] array) {
		
		int sum = 0;
		try {
			if (array.length < 1) {
				throw new Exception("No one");
			} else {
				for (int i = 0; i < array.length; i++) {
					sum += array[i];
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int [] P = {15, 9, 8};
		int [] S = {10, 6, 9};
		
		int numCar = solution(P,S);
		
		System.out.println(numCar);
	}

}

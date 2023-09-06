package hackerank;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Dequeue_Hackerank {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Deque deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			numList.add(num);
		}

		List<List<Integer>> subLists = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>();
		int uniqueCount = 0;
		for (int i = 0; i < numList.size() - m; i++) {
			for (int j = 0; j < m; j++) {
				subList.add(numList.get(i));
			}
			subLists.add(subList);
		}

		int count = 0;
		for (List<Integer> inte : subLists) {
			Set<Integer> uniqueInteger = new HashSet<Integer>();
			for (int i : inte) {
				uniqueInteger.add(i);
			}
			if (uniqueInteger.size() > count) {
				count = uniqueInteger.size();
			}

		}
		System.out.println(count);
	}
}

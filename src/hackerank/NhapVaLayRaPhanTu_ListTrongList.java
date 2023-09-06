package hackerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class NhapVaLayRaPhanTu_ListTrongList {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<List<Integer>> integerListinList = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> integerList = new ArrayList<Integer>();
			int m = scanner.nextInt();
			for (int j = 0; j < m; j++) {
				integerList.add(scanner.nextInt());
			}
			integerListinList.add(integerList);
		}

		int k = scanner.nextInt();
		for (int i = 0; i < k; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			int[] array = integerListinList.get(x - 1).stream().mapToInt(Integer::intValue).toArray();

			if (y <= array.length) {
				System.out.println(array[y - 1]);
			} else {
				System.out.println("ERROR!");
			}
		}
		scanner.close();
	}
}

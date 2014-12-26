package algorithm;

import java.util.Arrays;

/**
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers. Note:
 * 
 * <strong>Your solution should be in logarithmic complexity.</strong>
 * 
 * 
 * */
public class FindPeakElement {

	public static void main(String[] args) {

		int[] num = { 2, 1 };
		// QuickSort(num, 0, num.length - 1);
		System.out.println(findAPeek(num));
	}

	public static int findAPeek(int[] num) {
		int l = 0;
		int h = num.length - 1;
		while (l < h) {
			int mid = (h + l) / 2;
			if (num[mid] < num[mid + 1]) {
				l = mid + 1;
                 
			} else if (mid - 1 < 0 || num[mid] > num[mid - 1]) {
				return mid;
			} else {
				h = mid;
			}
		}
		return l;
	}

	public static int QuickSort(int[] num, int l, int h) {

		if (l < h) {
			int pivot = getPartition(num, l, h);
			QuickSort(num, l, pivot - 1);
			QuickSort(num, pivot + 1, h);
		}

		System.out.println(Arrays.toString(num));
		return -1;
	}

	public static int getPartition(int[] num, int l, int h) {

		// int[] temp = new int[num.length];
		// for (int i = 0; i < temp.length; i++) {
		// temp[i] = -1;
		// }
		int pivotKey = num[l];
		while (l < h) {
			while (l < h && num[h] >= pivotKey) {
				// temp[h] = num[h];
				h--;
			}
			num[l] = num[h];
			while (l < h && num[l] < pivotKey) {
				l++;
			}
			num[h] = num[l];
			// temp[l] = num[l];
		}
		num[l] = pivotKey;
		// if (l >= h && l == num.length - 1) {
		// return l;
		// }
		//
		// System.out.println(Arrays.toString(temp));
		return l;
	}
}

package com.leetcode.search;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author maocg
 */
public class BinarySearch {
    /**
     * 二分查找非递归
     * @param array
     * @param a
     * @return
     */
	public static int binSearch(int[] array, int a) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		int times =0;
		while (low <= high) {
            System.out.println(times++);
            mid = (low + high) / 2;
			if (array[mid] > a) {
                high = mid - 1;
			} else if (array[mid] < a) {
				low = mid + 1;
			} else {
				return mid;
			}
//            AtomicInteger
		}
		return -1;
	}

    /**
     * 二分查找，递归实现
     * @param array
     * @param a
     * @param low
     * @param high
     * @return
     */
	public static int binSearch1(int[] array, int a, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (a == array[mid]) {
				return mid;
			} else if (a > array[mid]) {
				return binSearch1(array, a, mid + 1, high);
			} else {
				return binSearch1(array, a, low, mid - 1);
			}
		}
		return -1;
	}
	@Test
	public void testBinSearch(){
		int [] a = new int[]{2,4,6,7,9,11,15};
		Assert.assertEquals(0,binSearch(a,2));
		Assert.assertEquals(2,binSearch(a,6));
		Assert.assertEquals(5,binSearch(a,11));
		Assert.assertEquals(6,binSearch(a,15));

		Assert.assertEquals(0,binSearch1(a,2,0,7));
		Assert.assertEquals(2,binSearch1(a,6,0,7));
		Assert.assertEquals(5,binSearch1(a,11,0,7));
		Assert.assertEquals(6,binSearch1(a,15,0,7));
	}

	@Test
	public void testBinSearchFirst() {

	}

}

package test;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSort {
	
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
	    }   
	} 
	
	public static void main(String[] args) {
		int nums[]=new int[]{6,1,4,2,9,3,7,8,0,5};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
		
		HashMap<String, String> map=new HashMap<>();
				map.put("12", "21");
				map.put("12", "31");
				System.out.println(map);
				
				
				
				
	}

}

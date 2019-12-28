package com.sort;

public class HeapSort {
	
	public static int[] swap(Integer num1,Integer num2) {
		return new int[] {num2,num1};
	}
	
	public static void heapify(int []list,int len,int curr) {
		
		int left = 2*curr + 1;
		int right = left + 1;
		int latest = curr;
		
		if(left < len && list[left] > list[curr])
			 latest = left;
		
		if(right < len && list[left] < list[right] && list[right] > list[curr])
			latest = right;
		
		if(latest != curr) {
			
			int temp = list[curr];
			list[curr] = list[latest];
			list[latest] = temp;
			
			heapify(list,len,latest);
		}
	}
	
	public static void heapSort(int list[]) {
		for(int i=list.length-1; i>=0; i--)
			heapify(list, list.length, i); // build heap first
		
		for(int i=list.length-1; i>=0; i--) {
			
			int temp = list[i];
			list[i] = list[0];
			list[0] = temp;
			
			heapify(list,i,0);
		}
	}
	
	public static void main(String[] args) {
		int[] list = { 34,78,45,12,23,87,76,56,43,21 };
		
		heapSort(list);
		
		for(int i=0; i<list.length; i++)
			System.out.println(list[i]);
	}
}

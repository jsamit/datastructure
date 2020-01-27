package com.hackerrank;

import java.util.List;

public class MinSwapForSort {
	public static void main(String[] args) {
		
		int [] arr = {2, 3, 4, 1, 5}; // {4,5,1,2,3};
		
		List <Integer[]> actual = new ArrayList<>();
		int ans = 0;
		
		// number against position 
		for(int i=0; i<arr.length; i++) {
			actual.add(new Integer[] {arr[i],i});
		}
		
		// number against position after sorting 
		actual.sort(new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] pair1, Integer[] pair2) {
				return pair1[0] - pair2[0];
			}
		});
		
		boolean visited [] = new boolean[arr.length];
		Arrays.fill(visited, false);
		
		for(int i=0; i<arr.length; i++) {
			if(visited[i] || actual.get(i)[1] == i)
				continue;
			
			int cycleSize = 0;
			int j = i;
			
			while(!visited[j]) {
				visited[j] = true;
				j = actual.get(j)[1];
				cycleSize++;
			}
			
			if(cycleSize > 0) {
				ans += cycleSize - 1;
			}
		}
		
		System.out.println(ans);
	}
}

package com.dynamic;

import java.util.Arrays;

public class CoinExchangeProblem {
	
	public static void main(String[] args) {
		
		int []coins = {2,3,5,10};
		int money = 15;
		
		int [][]tabulation = new int[coins.length+1][money+1];
		
		Arrays.fill(tabulation[0], 0);
		for(int j=1; j<coins.length+1; j++)
			tabulation[j][0] = 1;
		
		for(int j=1; j<coins.length+1; j++) {
			for(int i = 1; i < money+1; i++) {
				if(coins[j-1] > i)
					tabulation[j][i] = tabulation[j-1][i];
				else 
					tabulation[j][i] = tabulation[j-1][i] + tabulation[j][i - coins[j-1]];
			}
		}
		
		System.out.println("Total ways of exchange : " + tabulation[coins.length][money]);
	}

}

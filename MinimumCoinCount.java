package com.dynamic;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		
		int []coins = {1,5,9};
		int amount = 11;
		
		int [][] tabulation = new int [coins.length+1][amount+1];
		
		for(int j=0; j<=amount; j++) {
			tabulation[0][j] = j;
		}
		
		for(int i=1; i<=coins.length; i++) {
			for(int j=1; j<=amount; j++) {
				
				if(coins[i-1] > j)
					tabulation[i][j] = tabulation[i-1][j];
				else 
					tabulation[i][j] = Math.min(tabulation[i-1][j], 1 + tabulation[i][j - coins[i-1]]);
			}
		}
		
		int i = coins.length;
		int j = amount;
		
		Arrays.fill(tabulation[0], 0);
		
		while(i > 0 && j > 0) {
			if(tabulation[i-1][j] != tabulation[i][j]) {
				System.out.println(coins[i-1]);
				j = j - coins[i-1];
			}
			else i--;
		}
		

	}

}

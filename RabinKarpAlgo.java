package com.str;

public class RabinKarpAlgo {
	public static int calculateHash(String s) {
		int value = 0;
		for(int i=0; i<s.length(); i++) {
			value *= 10;
			value += (s.charAt(i) - 97 + 1);
		}
		return value;
	}
	
	public static boolean strstr(String src,String dest) {
		
		if(src.length() < dest.length()) return false;
		
		int hash = calculateHash(dest);
		int target = calculateHash(src.substring(0, dest.length()));
		
		for(int i=1; i<=src.length() - dest.length() + 1; i++) {
			if(target == hash)
				return true;
			
			target = 10 * (target - (int)Math.pow(10, dest.length()-1) * (src.charAt(i-1)-97 + 1)) + (src.charAt(i - 1 + dest.length()) - 97 + 1);
		}
		return false;
	}
	public static void main(String[] args) {
		
		System.out.println(strstr("abcde","bcde"));
	}
}

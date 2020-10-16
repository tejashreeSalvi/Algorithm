package DPLCS;

public class MinNoOfDeletionInStringToMakeItPalindrome {

	public static int LPS(char x[], char y[], int n, int m){
		int t[][] = new int[n+1][m+1];
		
		if(n == 0 || m == 0)
			return 0;
		for(int i = 1 ; i < n+1; i++){
			for(int j = 1; j < m+1; j++){
				if(x[i-1] == y[j-1])
					t[i][j] = 1 + t[i-1][j-1];
				else{
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]); 
				}
			}
		}
		return t[n][m];
	}
	
	public static String reverseString(String str){
		StringBuilder sb = new StringBuilder();
		return String.valueOf(sb.append(str).reverse());
	}
	
	public static void main(String[] args) {
		String s1 = "agbcba";
		String s2 = reverseString(s1);
		
		char x[] = s1.toCharArray();
		char y[] = s2.toCharArray();
		
		int n = x.length;
		int m = y.length;
		
		int LPSlen = LPS(x, y, n, m);
		System.out.println("Length of Longest Palindromic Subsequence:"+ LPSlen);
		
		int minDeletion = n - LPSlen;
		System.out.println("Minimum # of Deletion in String to make it Palindrome: "+minDeletion);
	}
}

public class LongestCommonSubsequence {
	
	public static int LCSRecursionMemo(char x[], char[] y, int n, int m){
		
		int t[][] = new int[n+1][m+1];
			
		if(n == 0 || m == 0){
			return 0;
		}
		if(t[n][m] != 0){
			return t[n][m];
		}
		
		if(x[n-1] == y[m-1]){
			t[n][m] = 1 + LCSRecursionMemo(x, y, n-1,m-1);  
		}else{
			t[n][m] = Math.max(LCSRecursionMemo(x, y, n-1, m), LCSRecursionMemo(x, y, n, m-1));
		}

		return t[n][m];
	}
	
	public static int LCSDP(char x[], char y[], int n, int m){
		
		int t[][] = new int[n+1][m+1];
		
		if(n == 0 || m == 0)
			return 0;
		
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < m+1; j++){
				
				if(x[i-1] == y[j-1]){
					t[i][j] = 1 + t[i-1][j-1];
				}else{
					t[i][j] = Math.max(t[n-1][m], t[n][m-1]);
				}
			}
		}
		return t[n][m];
	}
	
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		char x[] = "abcdefgh".toCharArray();
		char y[] = "abcdefgh".toCharArray();
		int xlen = x.length;
		int ylen = y.length;
		System.out.println("Bottom Up :"+LCSRecursionMemo(x, y, xlen, ylen));
		long time2 = System.currentTimeMillis();
		System.out.println("Time Taken :"+(time2 - time1));
		
		System.out.println("Top Down Approach : "+ LCSDP(x, y, xlen, ylen));
	}
}

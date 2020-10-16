public class PrintLCS {

	public static void LCS(char x[], char y[], int n, int m){
		int t[][] = new int[n+1][m+1];
		if(n == 0 || m == 0)
			return;
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < m+1; j++){
				if(x[i-1] == y[j-1])
					t[i][j] = 1 + t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		System.out.println("Length of Longest Common SubSequence: "+t[n][m]);
		
		printLCS(t, x, y, n, m);
	}
	
	public static void printLCS(int t[][], char x[], char y[], int n, int m){
		
		int i = n, j = m;
		StringBuilder str = new StringBuilder();
		while(i > 0 && j > 0){
			if(x[i-1] == y[j-1]){
				str.append(x[i-1]);
				i--;
				j--;
			}else{
				if(t[i-1][j] > t[i][j-1]){
					i--;
				}else{
					j--;
				}
			}
		}
		System.out.println("Longest Common Subsequence String: "+str.reverse());
	}
	
	public static String printLCS(String str){
		return String.valueOf(str);
	}
	 
	public static void main(String[] args) {
		String a = "xybczb";
		String b = "abdcbq";
		
		char x[] = a.toCharArray();
		char y[] = b.toCharArray();
		int n = x.length;
		int m = y.length;
		LCS(x, y, n, m);
	}

}

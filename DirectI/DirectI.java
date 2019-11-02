import java.util.*;
import java.text.*;
import java.io.*;

public class DirectI{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}

	public static int[] biggest_square(int[][] arr,int[] xcoord,int[] ycoord,int[] count){
		int m = arr.length;
		int n = arr[0].length;
		int[][] dp = new int[m+2][n+2];

		dp[1][1] = arr[0][0];
		for(int j = 2;j<=n;j++){
			dp[0][j] = arr[0][j-1];
			dp[0][j]+=dp[0][j-1];
		}

		for(int i = 2;i<=m;i++){
			dp[i][0] = arr[i-1][0];
			dp[i][0]+=dp[i-1][0];
		}

		for(int i = 2;i<=m;i++){
			for(int j = 2;j<=n;j++){
				dp[i][j] = arr[i-1][j-1];
				dp[i][j]+=(dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]);
			}
		}

		int q = count.length;
		int[] ans = new int[q];
		for(int i = 0;i<q;i++){
			ans[i] = helper(dp,xcoord[i],ycoord[i],count[i]);
		}
		return ans;
	}

	public static int helper(int[][] arr,int x,int y,int max){
		int m = arr.length-2;
		int n = arr[0].length-2;
		int max_x = Math.min(x,n-x+1);
		int max_y = Math.min(y,m-y+1);
		int max = Math.min(max_x,max_y);
		int count = 0;
		int offset = 0;
		for(int size = 1;size<=max;size+=2){
			offset = size/2;
			count = arr[x+offset][y+offset];
			count -= (arr[x-offset-1][y+offset] + arr[x+offset][y-offset-1] - arr[x-offset-1][y-offset-1]);
			if(count>max){
				return size*size;
			}
		}
		return ;
	}
}
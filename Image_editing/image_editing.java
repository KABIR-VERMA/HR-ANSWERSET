import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int largestMatrix(List<List<Integer>> arr) {
        // Write your code here
        int row = arr.size();
        int col = arr.get(0).size();
        int[][] sarr = new int[row][col];
        for(int i=0;i<row;++i)
        {
            sarr[i][0] = (arr.get(i)).get(0);
        } 
        for(int i=0;i<col;++i)
        {
            sarr[0][i] = (arr.get(0)).get(j);
        }
        int maxval =0;
        for(int i=1;i<row;++i)
        {
            for(int j=1;j<col;++j)
            {
                if(arr.get(i).get(j)==1)
                {
                    sarr[i][j] = 1+ Math.min(S[i][j-1],Math.min(S[i-1][j], S[i-1][j-1]));
                    maxval = Math.max(maxval, sarr[i][j]); 
                }
                else
                {
                    sarr[i][j] =0;
                }
            }
        }
        return maxval;         
    }

}
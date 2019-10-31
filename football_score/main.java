import java.io.*;
import java.lang.annotation.Retention;
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
     * Complete the 'counts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY teamA
     *  2. INTEGER_ARRAY teamB
     */

    static int fun(List<Integer> teamA, int ii, int jj, int k)
    {
        while(ii<=jj)
        {
            int mid = (ii+jj)/2;
            if(teamA.get(mid)<=k)
            {
                ii= mid+1;
            }
            else
            {
                jj= mid-1;
            }
        }
        return jj;
    }
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
    // Write your code here
        Collections.sort(teamA);
        List<Integer> l = new ArrayList<Integer>();
        for (int i=0; i<teamB.size(); i++) 
        { 
            int index = fun(teamA, 0, teamA.size()-1, teamB.get(i)); 
            l.add(index+1); 
        } 
        return l;
    }
}
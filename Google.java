import java.util.*;
import java.text.*;
import java.io.*;

public class Google{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    }

    public static void fruits(ArrayList<String> fruits,ArrayList<Integer> price){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        int idx;
        Fruit f;

        for(int i = 0;i<fruits.size();i++){
            if(map.containsKey(fruits.get(i))){
                idx = map.get(fruits.get(i));
                f = list.get(idx);
                f.update(price.get(i));
            }else{
                f = new Fruit(fruits.get(i));
                list.add(f);
                f.update(price.get(i));
                map.put(f.name,list.size()-1);
            }
        }

        Collections.sort(list,new Compy());
        for(int i = 0;i<list.size();i++){
            f = list.get(i);
            System.out.println(f.name + " " + f.min + " " + f.max + " " + f.avg);
        }
    }

    // https://ide.geeksforgeeks.org/dSftdKz3Ba
    public static int max_subset_sum(int[] arr,int k){
        int n = arr.length;
        int[][] dp = new int[k+1][n];
        for(int i = 0;i<=k;i++){
            for(int j = 0;j<n;j++){
                if(i==0){
                    dp[i][j] = 0;
                }else if(j==0){
                    if(arr[j]<=i){
                        dp[i][j] = arr[j];
                    }
                }else if(j==1){
                    dp[i][j] = dp[i][j-1];
                    if(arr[j]<=i){
                        dp[i][j] = Math.max(arr[j],dp[i][j]);
                    }
                }else{
                    dp[i][j] = dp[i][j-1];
                    if(arr[j]<=i){
                        dp[i][j] = Math.max(arr[j]+dp[i-arr[j]][j-2],dp[i][j]);
                    }
                }
            }
        }
        return dp[k][n-1];
    }

    public static int gcd_diff(ArrayList<Integer> nodes,int n){
        int i = 0;
        int j = 0;
        int n1,n2,gcd;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int idx = 1;
        for(i = 0;i<=n;i++){
            for(j = 0;j<(int)(Math.pow(2,i));j+=2){
                if(i==0){
                    continue;

                }
                n1 = nodes.get(idx);
                idx++;
                n2 = nodes.get(idx);
                idx++;
                if(n1==-1 || n2==-1){
                    continue;
                }
                gcd = gcd(n1,n2);
                min = Math.min(min,gcd);
                max = Math.max(max,gcd);
            }
        }
        if(min==Integer.MAX_VALUE && max==Integer.MIN_VALUE){
            min = Integer.MIN_VALUE;
        }
        return max-min;
    }

    public static int gcd(int a,int b){
        int n1 = Math.max(a,b);
        int n2 = Math.min(a,b);
        int rem = n1%n2;
        while(rem!=0){
            n1 = n2;
            n2 = rem;
            rem = n1%n2;
        }
        return n2;
    }

    public static int strawberry_bush(int[] arr,int cap){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[1] = arr[0];
        int max = 0;
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],arr[i]+dp[i-2]);
            if(dp[i]<=cap){
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}

class Fruit{
    public String name;
    public int count;
    public int sum;
    public int avg;
    public int min;
    public int max;

    public Fruit(String s){
        this.name = s;
        this.count = 0;
        this.sum = 0;
        this.avg = 0;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

    public void update(int val){
        this.sum+=val;
        this.count+=1;
        this.avg = (this.sum/this.count);
        this.min = Math.min(this.min,val);
        this.max = Math.max(this.max,val);
    }
}

class Compy implements Comparator<Fruit>{
    public int compare(Fruit f1,Fruit f2){
        return f1.name.compareTo(f2.name);
    }
}
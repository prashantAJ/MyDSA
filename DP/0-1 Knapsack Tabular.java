// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         //Tabulation
        int[][] dp=new int[wt.length][w+1];
        if(wt[0]<=w){
            for(int ii=wt[0];ii<=w;ii++)
                dp[0][ii]=val[0];
        }
        for(int j=1; j<wt.length;j++){
            for(int k=0; k<=w; k++){
                int pick=Integer.MIN_VALUE, notPick=0;
                if(k-wt[j]>=0)
                    pick=val[j]+dp[j-1][k-wt[j]];//find(i-1, w-wt[i], wt, val, dp);
                notPick=dp[j-1][k];//find(i-1, w, wt, val, dp);
                dp[j][k]=Math.max(pick, notPick);        
            }
        }
      return dp[wt.length-1][w];
    } 
}

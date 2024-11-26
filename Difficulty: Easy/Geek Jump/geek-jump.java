//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int n){
        //code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return minE(n-1,arr,dp);
    }
    
    
    public int minE(int i,int[] arr,int dp[]){
        if(i==0) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int jumpOne=minE(i-1,arr,dp)+Math.abs(arr[i]-arr[i-1]);
        int jumpTwo=Integer.MAX_VALUE;
        if(i>1){
            jumpTwo=minE(i-2,arr,dp)+Math.abs(arr[i]-arr[i-2]);
        }
        
    return dp[i]=Math.min(jumpOne,jumpTwo);
        
    }
}
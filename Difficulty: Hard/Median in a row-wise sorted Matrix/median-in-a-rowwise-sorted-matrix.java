//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static int upperBound(int[] mat,int target,int size){
        int low=0,high=size-1;
        int ans=size;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(mat[mid]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    private static int median(int[][] mat,int m,int n,int x){
        int count=0;
        for(int i=0;i<m;i++){
            count+=upperBound(mat[i],x,n);
        }
        return count;
    }
    int median(int matrix[][], int R, int C) {
        // code h
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        
        
        for(int i=0;i<R;i++){
            low=Math.min(low,matrix[i][0]);
            high=Math.max(high,matrix[i][C-1]);
        }
        int reqSize=(R*C)/2;
        while(low<=high){
            int mid=(low+high)/2;
            int cal=median(matrix,R,C,mid);
            
            if(cal<=reqSize){
                low=mid+1;
            }else{
                high=mid-1;
            }
            
        }
        
        return low;
    }
}
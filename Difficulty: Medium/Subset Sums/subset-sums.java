//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    
    void subSetSum(int ind,int sum,ArrayList<Integer> arr,int size,ArrayList<Integer> subsetSum){
        if(ind==size){
            subsetSum.add(sum);
            return;
        }
        subSetSum(ind+1,sum+arr.get(ind),arr,size,subsetSum);
        subSetSum(ind+1,sum,arr,size,subsetSum);
        
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> subSetList=new ArrayList<>();
        subSetSum(0,0,arr,n,subSetList);
        // Collections.sort()
        
        return subSetList;
    }
}
//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public int maxDistance(int[] arr) {
        
        
        // Code here
        //BF BY USING NESTED FORLOOPS
        //TC : O(N^2) , sc : 
        /*int maxDis=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[i]==arr[j]){
                    maxDis=Math.max(Math.abs(j-i),maxDis);
                }
            }
        }
        return maxDis;
    }*/
    
     HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDis = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // If the element is seen for the first time, store its index
            if (!firstOccurrence.containsKey(arr[i])) {
                firstOccurrence.put(arr[i], i);
            } else {
                // Calculate the distance from the first occurrence
                int distance = i - firstOccurrence.get(arr[i]);
                // Update maxDis if the current distance is larger
                maxDis = Math.max(maxDis, distance);
            }

        }
        return maxDis;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    class Item{
        int value;
        int weight;
        
        Item(int value,int weight){
            this.value=value;
            this.weight=weight;
        }
    }
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        List<Item> list=new ArrayList<>();
        
        for(int i=0;i<val.size();i++){
            list.add(new Item(val.get(i),wt.get(i)));
        }
        
        Collections.sort(list,new Comparator<Item>(){
        @Override
        public int compare(Item a,Item b){
           double r1=(double)a.value/a.weight;
           double r2=(double)b.value/b.weight;
           
           
           if(r1<r2){
               return 1;
           }
           
           return -1;
        }
        });
        
        double totalVal=0.000000;
        for(Item i:list){
            if(i.weight<=capacity){
                capacity-=i.weight;
                totalVal+=i.value;
            }else{
                totalVal+=(double)(i.value/(double)i.weight)*(double)capacity;
                capacity=0;
                break;
            }
        }
        return totalVal;
    }
}
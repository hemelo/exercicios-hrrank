import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaSubArrays {
    
    static LinkedList<ArrayList<Integer>> subarrays = new LinkedList<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] array = new int[n];
        
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        findSubArrays(array, 0, 0);
        
        int countNegatives = 0;
        
        for (ArrayList<Integer> subarray : subarrays) {
            if (subarray.stream().reduce(0, Integer::sum) < 0) countNegatives++;
        }
        
        System.out.println(countNegatives);
    }
    
    static void findSubArrays(int[] array, int start, int ending) {
        
        if (ending == array.length) return;
        else if (start > ending) findSubArrays(array, 0, ending + 1);
        else {
            
            subarrays.add(new ArrayList<>(ending - start));
            
            for (int i = start; i <= ending; i++) {
               subarrays.getLast().add(array[i]);
            }
            
            findSubArrays(array, start + 1, ending);
        }
        
        return; 
    }
}

package Medium.SortSearch;

import java.util.*;
import java.io.*;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {5,4,3,2,1,5,1};
		System.out.println(findPeakElement2(tc1));

	}
	
	public static int findPeakElement2(int[] a) {
        int max = Integer.MIN_VALUE;
        int iMax = 0;
        return findMax(a, 0, a.length-1);
   }
   
   public static int findMax(int[] a, int start, int end){
       int mid = (start+end)/2;
       if(start == end){
           return start;
       }else{
           if(a[mid]>a[mid+1]){
               return findMax(a, start, mid);
           }else{
               return findMax(a, mid+1, end);
           }
       }
   }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class MergeSort {

public static int counter = 0;

private static void mergesort(int[] input, int start, int end) {

	int mid = (start + end) / 2;
	if (start < end) {
		mergesort(input, start, mid);
		mergesort(input, mid + 1, end);
	}
	    
    int i = 0, first = start, last = mid + 1;
    int[] tmp = new int[end - start + 1];

    while (first <= mid && last <= end) {
    	if(input[first] < input[last])
    		tmp[i++]=input[first++];
    	else 
    		tmp[i++]=input[last++];
    	counter++;
    }
	    
    while (first <= mid) {
    	tmp[i++] = input[first++];
    }
    while (last <= end) {
    	tmp[i++] = input[last++];
    }
    i = 0;
    while (start <= end) {
    	input[start++] = tmp[i++];
    }
}
  
	public static int[] generateRandomArray(int state,int n){
		   
		 //state -1 descending 0 random 1 ascending
		 int[] list = new int[n];
		 	
		 if (state==1) {
			 for (int i = 0; i < n; i++)
			 	list[i]=i;
		 } else if (state==-1) {
			 for (int i = 0; i < n; i++)
				 list[i]=n-i;
		 } else {
			 Random random = new Random();
			 for (int i = 0; i < n; i++)
				 list[i]=random.nextInt(1000);		  
		 } 
		 return list;
	 } 
	 
	public static double func(int state,int n) {
		int[] input= generateRandomArray(state,n);
		double start=System.currentTimeMillis();
		mergesort(input,0,input.length-1);
		double end=System.currentTimeMillis();
		return end-start;	
	}
//		  
    public static void main(String args[]) { 
     	
    	System.out.println("Number of values\n");
    	for(int i=1000;i<=1000000;i=i*2)
    		System.out.print(i+" ");
    	System.out.println("\n");
    	
    	List<Double> Time_Ascending = new ArrayList<Double>();
    	List<Integer> comparison_Ascending = new ArrayList<Integer>();
        for(int i=1000;i<=1000000;i=i*2) {
        	counter=0;
        	double x=func(1,i);
        	Time_Ascending.add(x);
        	comparison_Ascending.add(counter);
        }
        
     	List<Double> Time_descending = new ArrayList<Double>();
     	List<Integer> comparison_descending = new ArrayList<Integer>();
        for(int i=1000;i<=1000000;i=i*2) {
        	counter=0;
        	double x=func(-1,i);
        	Time_descending.add(x);
        	comparison_descending.add(counter);
        }
        
     	List<Double> Time_random = new ArrayList<Double>();
     	List<Integer> comparison_random = new ArrayList<Integer>();
        for(int i=1000;i<=1000000;i=i*2) {
        	counter=0;
        	double x=func(0,i);
        	Time_random.add(x);
        	comparison_random.add(counter);
        }
        
        System.out.println("Time taken for Ascending order\n"+Time_Ascending);
        System.out.println("comparsions taken for Ascending order\n"+comparison_Ascending);
         
        System.out.println("Time taken for descending order\n"+Time_descending);
        System.out.println("comparsions taken for descending order\n"+comparison_descending);
        
        System.out.println("Time taken for random order\n"+Time_random);
        System.out.println("comparsions taken for random order\n"+comparison_random);
    } 
} 
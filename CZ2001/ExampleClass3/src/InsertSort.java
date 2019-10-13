import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InsertSort {

	private static int arraysize;
	public static long counter = 0;

	// the algorithm for insertion sort
	// input: 	a array of integers
	// n:		the size of the array
	public static void insertionSort(int[] input, int n) {
		int[] dataList = input;
		ArrayList<Long> list;
		for (int i = 1; i < n; i++) {  // outer loop
			for (int j = i; j > 0; j--) {  // inner loop
				counter++;
				if (dataList[j] < dataList[j - 1]) { // check if the two elements are out of order
					swap(dataList, j, j - 1);
				} else
					break;
			}
		}
	}

	private static void swap(int slot[], int i, int j) {
		int temp = slot[i];
		slot[i] = slot[j];
		slot[j] = temp;
	}

	public static int[] generateRandData(int state, int n) {
		int[] list = new int[n];
		arraysize = n;

		if (state == 1) { // ascending data
			for (int i = 0; i < n; i++) {
				list[i] = i;
			}
		} 
		else if (state == -1) { // descending data
			for (int i = 0; i < n; i++) {
				list[i] = n - i;
			}
		} 
		else { // random data
			Random random = new Random();
			for (int i = 0; i < n; i++) {
				list[i] = random.nextInt(1000);
			}
		}
		return list;
	}

	public static double func(int state, int n) {
		int input[] = generateRandData(state, n);
		double start = System.currentTimeMillis();
		insertionSort(input, input.length - 1);
		double end = System.currentTimeMillis();
		double estimate = end - start;
		return estimate;
	}

	public static void sortAscending() {
		List<Double> cpuTimeAscending = new ArrayList<Double>();
		List<Long> keyComparisonAscending = new ArrayList<Long>();
		int i = arraysize;
		double x = func(1, i);
		cpuTimeAscending.add(x);
		keyComparisonAscending.add(counter);

		System.out.println("CPU time taken for Ascending sort\n" + cpuTimeAscending + "\n");
		System.out.println("No. of key comparisons for Ascending sort\n" + keyComparisonAscending + "\n");
		menu();
	}
	
	public static void sortDescending() {
		List<Double> cpuTimeDescending = new ArrayList<Double>();
		List<Long> keyComparisonDescending = new ArrayList<Long>();
		int i = arraysize;
		double x = func(-1, i);
		cpuTimeDescending.add(x);
		keyComparisonDescending.add(counter);

		System.out.println("CPU time taken for Descending sort\n" + cpuTimeDescending + "\n");
		System.out.println("No. of key comparisons for Descending sort\n" + keyComparisonDescending + "\n");
		menu();
	}

	public static void sortRandom() {
		List<Double> cpuTimeRandom = new ArrayList<Double>();
		List<Long> keyComparisonRandom = new ArrayList<Long>();
		int i = arraysize;
		double x = func(0, i);
		cpuTimeRandom.add(x);
		keyComparisonRandom.add(counter);
		
		System.out.println("CPU time taken for Random sort\n" + cpuTimeRandom + "\n");
		System.out.println("No. of key comparisons for Random sort\n" + keyComparisonRandom + "\n");
		menu();
	}
	
	public static void updateArraySize() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		arraysize = sc.nextInt();
		System.out.println("");
		menu();
	}

	public static void menu() {
		counter=0;
		int option;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter option ('0' to exit): \n " + "1. Sort random dataset \n " + "2. Sort data in ascending order \n "
				+ "3. Sort data in descending order \n "
				+ "4. Change array size" );

		option = sc.nextInt();

		switch (option) {
		case 1:
			sortRandom();
			break;
		case 2:
			sortAscending();
			break;
		case 3:
			sortDescending();
			break;
		case 4:
			updateArraySize();
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter array size:");
		arraysize = sc.nextInt();
		System.out.println("");
		menu();
	}
}

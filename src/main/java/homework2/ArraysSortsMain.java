package homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class ArraysSortsMain {

	private static int[] arr1 = new int[1000];
	private static int[] arr2 = new int[1000];
	private static Thread thread1;
	private static Thread thread2 = new Thread();
	private static Thread thread3 = new Thread();
	
	public static void main(String[] args) {
		fillArray(arr1);
		fillArray(arr2);
		
		//Source arrays
		System.out.println("Source arrays:");
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		QuickSort quickSort = new QuickSort(arr1);
		thread1 = new Thread(quickSort);
		thread1.start();
		
		MergeSort mergeSort = new MergeSort(arr2);
		thread2 = new Thread(mergeSort);
		thread2.start();
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sorted arrays:");
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		MethOperations oper = new MethOperations(arr1, arr2);
		thread3 = new Thread(oper);
		thread3.start();
		
		writeSortedArrayToFile("QuickSort", arr1);
		writeSortedArrayToFile("MergeSort", arr2);
		
	}
	
	public static int randomNumber() {
		return (int)(Math.random() * 1000);
	}
	
	public static void fillArray(int[] array) {
		for (int i = 0; i<array.length; i++) {
			array[i] = randomNumber();
		}
	}
	
	public static void writeSortedArrayToFile(String sortName, int[]array) {
        try (Writer writer = new FileWriter(sortName + ".txt")) {
            writer.write(Arrays.toString(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

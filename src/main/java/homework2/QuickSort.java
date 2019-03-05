package homework2;

public class QuickSort implements Runnable {

	private int[] _arr;
	
	public QuickSort(int[] array) {
		_arr = array;
	}
	
	@Override
	public void run() {
		long startTime = System.nanoTime();
        
		quickSort(_arr, 0, _arr.length-1);

		long estimatedTime = System.nanoTime()-startTime;
        double estimatedTimeInSeconds = ((double) estimatedTime)/1000000000;
        System.out.println("QuickSort execution time: \n" + estimatedTimeInSeconds + 
        					" seconds \nor\n" + estimatedTime + " nanoseconds\n");
	}
	
	public static void quickSort(int[] arr, int start, int end){
		 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
    }

}

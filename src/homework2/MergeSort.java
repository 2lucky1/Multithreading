package homework2;

import java.util.Arrays;

public class MergeSort implements Runnable {

	private int[] _arr;
	
	public MergeSort(int[] array) {
		_arr = array;
	}
	
	@Override
	public void run() {
		long startTime = System.nanoTime();
        
		mergeSort(_arr, 0, _arr.length-1);

		long estimatedTime = System.nanoTime()-startTime;
        double estimatedTimeInSeconds = ((double) estimatedTime)/1000000000;
        System.out.println("MergeSort execution time: \n" + estimatedTimeInSeconds + 
        					" seconds \nor\n" + estimatedTime + " nanoseconds\n");
	}
	
	private void mergeSort(int[] a, int lo, int hi) {

	    if (hi <= lo)
	        return;
	    int mid = lo + (hi - lo) / 2;
	    mergeSort(a, lo, mid);
	    mergeSort(a, mid + 1, hi);

	    int[] buf = Arrays.copyOf(a, a.length);

	    for (int k = lo; k <= hi; k++)
	        buf[k] = a[k];

	    int i = lo, j = mid + 1;
	    for (int k = lo; k <= hi; k++) {

	        if (i > mid) {
	            a[k] = buf[j];
	            j++;
	        } else if (j > hi) {
	            a[k] = buf[i];
	            i++;
	        } else if (buf[j] < buf[i]) {
	            a[k] = buf[j];
	            j++;
	        } else {
	            a[k] = buf[i];
	            i++;
	        }
	    }
	}
}

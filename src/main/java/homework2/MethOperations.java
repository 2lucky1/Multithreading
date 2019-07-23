package main.java.homework2;

public class MethOperations implements Runnable {

	private int[] _arr1;
	private int[] _arr2;

	public MethOperations(int[] array1, int[] array2) {
		_arr1 = array1;
		_arr2 = array2;
	}

	@Override
	public void run() {
		int sumOf10 = 0;
		int sumOf100 = 0;
		for (int i = _arr1.length - 1; i > _arr1.length - 11; i--) {
			sumOf10 += _arr1[i];
		}

		for (int i = 0; i < 100; i++) {
			sumOf100 += _arr2[i];
		}
		System.out.println();
		System.out.println("sum of 10 = " + sumOf10);
		System.out.println("sum of 100 = " + sumOf100);
		System.out.println();
		double average10 = (double) sumOf10 / 10;
		double average100 = (double) sumOf100 / 100;

		System.out.println("average of the 10 largest elements from first array = " + average10);
		System.out.println("average of the 100 smallest elements from second array = " + average100);

	}

}

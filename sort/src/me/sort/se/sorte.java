package me.sort.se;

public class sorte {

	static int arraySize = 10000;
	static int[] oneArray = new int[arraySize];

	static void randomizeArray() {
		for (int i = 0; i < arraySize; i++)
			oneArray[i] = (int) (Math.random() * arraySize);
		
		
	}
	
	static void bubbleSort(int[] arr) // arr = array
	{
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void insertionSort(int array[]) {
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}

	public static void main(String[] args) {

		System.out.println("Array Before Bubble Sort");
		for (int i = 0; i < oneArray.length; i++) {
			System.out.print(oneArray[i] + " ");

		}
		System.out.println();

		bubbleSort(oneArray);

		System.out.println("Array After Bubble Sort");
		for (int i = 0; i < oneArray.length; i++) {
			System.out.print(oneArray[i] + " ");
			// System.out.println(); = många nollor
		}
		System.out.println();

		System.out.println("Array Before insertion");
		for (int i = 0; i < oneArray.length; i++) {
			System.out.print(oneArray[i] + " ");
		}
		System.out.println();

		insertionSort(oneArray);

		System.out.println("Array After insertion");
		for (int i = 0; i < oneArray.length; i++) {
			System.out.print(oneArray[i] + " ");
		}

	}
}

package day23;

public class ArrayUtils {

	 public static <T> void swap(T[] array, int index1, int index2) {
	        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
	            throw new IllegalArgumentException("Invalid indices");
	        }

	        T temp = array[index1];
	        array[index1] = array[index2];
	        array[index2] = temp;
	    }

	    public static <T> void printArray(T[] array) {
	        for (T element : array) {
	            System.out.print(element + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // Integer array
	        Integer[] intArray = {1, 2, 3, 4, 5};
	        System.out.print("Original Integer Array: ");
	        printArray(intArray);
	        swap(intArray, 1, 3);
	        System.out.print("Array after swapping elements at index 1 and 3: ");
	        printArray(intArray);

	        // String array
	        String[] strArray = {"apple", "banana", "cherry", "date"};
	        System.out.print("\nOriginal String Array: ");
	        printArray(strArray);
	        swap(strArray, 0, 2);
	        System.out.print("Array after swapping elements at index 0 and 2: ");
	        printArray(strArray);

	        // Double array
	        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
	        System.out.print("\nOriginal Double Array: ");
	        printArray(doubleArray);
	        swap(doubleArray, 2, 3);
	        System.out.print("Array after swapping elements at index 2 and 3: ");
	        printArray(doubleArray);
	    }
}

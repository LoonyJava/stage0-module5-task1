package com.epam.mjc.stage0;


/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] ints = new int[length];
        int count = 1;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = count;
            count++;
        }
        return ints;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reversedArray = new String[arr.length];
        int count = arr.length - 1;
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = arr[count];
            count--;
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        ArrayTasks arrayTasks = new ArrayTasks();
        String[] arr = {"pineapple", "apple", "pen"};
        arrayTasks.reverseArray(arr);
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int count = 0;
        for (int a : arr) {
            if (a > 0) count++;
        }
        int[] arr2 = new int[count];
        int position = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr2[position] = arr[i];
                position++;
            }
        }
        return arr2;
    }


    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        boolean sorted = false;
        int[] temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].length > arr[i + 1].length) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        boolean sorted2 = false;
        int max;
        int[] include;
        while (!sorted2) {
            sorted2 = true;
            for (int i = 0; i < arr.length; i++) {
                include = arr[i];
                for (int j = 0; j < include.length - 1; j++) {
                    if (include[j] > include[j + 1]) {
                        max = include[j];
                        include[j] = include[j + 1];
                        include[j + 1] = max;
                        arr[i] = include;
                        sorted2 = false;
                    }
                }
            }
        }
        int[][] newArr = arr;
        return newArr;
    }
}

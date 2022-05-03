package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    static int[] numbers = {5, 6, 8, 96, 15, 1, 9, 4, 44, 89, 19};

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter No : ");
//        int number = scanner.nextInt();

        //System.out.println(simpleSearch(numbers, number));
        //System.out.println(binarySearch(number));
//        mergeSort();
//        System.out.println(Arrays.toString(numbers));
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        for (int number: numbers) {
            binarySearchTree.insert(number);
        }

        BinarySearchTree.Node node = searchBitarraysTree(15, binarySearchTree);

        if (node != null)
            System.out.println(node.value);

    }

    public static int simpleSearch(int find) {
        for (int i = 0; i < numbers.length; i++) {
            if (Objects.equals(numbers[i], find)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int find) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (Objects.equals(numbers[mid], find)) {
                return mid;
            }

            if (numbers[mid] < find) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void selectionSort() {
        int unsortedLength = numbers.length;
        while (unsortedLength > 0) {
            int maxIndex = 0;
            int max = numbers[maxIndex];
            for (int i = 0; i < unsortedLength; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                    maxIndex = i;
                }
            }
            numbers[maxIndex] = numbers[unsortedLength - 1];
            numbers[unsortedLength - 1] = max;
            unsortedLength--;
        }
    }

    public static void bubbleSort() {
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers [j] = tmp;
                }
            }
        }
    }

    public static void merge (int[] nums, int start, int mid, int end) {
        int leftLen = mid - start + 1;
        int rightLen = end - mid;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            left[i] = nums[start + i];
        }
        for (int i = 0; i < rightLen; i++) {
            right[i] = nums[mid + i];
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int i = 0, j = 0, k = 0;

        while (i < leftLen && j < rightLen) {
            if (left[i] >= right[j]) {
                nums[k] = right[j];
                j++;
            } else {
                nums[k] = left[i];
                i++;
            }
            k++;
        }

        while (i < leftLen) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public static void sort (int[] nums, int start, int end) {
        if (end>start) {

            int mid = (start + end) / 2;

            sort(nums, start, mid);
            sort(nums, mid + 1, end);

            merge(nums, start, mid, end);
        }
    }

    //not working
    public static void mergeSort() {
        sort(numbers, 0, numbers.length - 1);
    }

    public static BinarySearchTree.Node searchBitarraysTree(int find, BinarySearchTree bst) {

        BinarySearchTree.Node node = bst.getRootNode();

        while (node != null) {
            if (node.value == find) {
                return node;
            } else if (find < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

}

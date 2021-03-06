package com.study.algorithm.search.binary_search;

import java.util.NoSuchElementException;

public class BinarySearch {

    public int stringSearch(String[] arr, String target) {
        int start = 0;
        int end = arr.length - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;
            if (target.compareTo(arr[middle]) == 0) {
                return middle;
            }else if (target.compareTo(arr[middle]) < 0) {
                end = middle - 1;
            }else if (target.compareTo(arr[middle]) > 0) {
                start = middle + 1;
            }
        }
        throw new NoSuchElementException("can't find target.");
    }

    public int intSearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            }else if (arr[mid] < target) {
                start = mid + 1;
            }else if (target < arr[mid]) {
                end = mid - 1;
            }
        }
        throw new NoSuchElementException("can't find target.");
    }

    public int lowerBoundary(int[] arr, int target) {
//        if (arr[arr.length - 1] < target)
//            throw new NoSuchElementException("can't find target.");
        if (arr.length == 0)
            throw new IndexOutOfBoundsException("length is zero.");

        int start = 0;
        int end = arr.length;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;
            if (target <= arr[mid]) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int upperBoundary(int[] arr, int target) {
//        if (target < arr[0] || arr[arr.length - 1] < target)
//            throw new NoSuchElementException("can't find target.");
        if (arr.length == 0)
            throw new IndexOutOfBoundsException("length is zero.");

        int start = 0;
        int end = arr.length;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }
}

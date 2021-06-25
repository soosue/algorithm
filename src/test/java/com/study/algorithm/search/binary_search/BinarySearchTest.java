package com.study.algorithm.search.binary_search;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BinarySearchTest {

    @Test
    void searchStringTest() {
        int idxFound = new BinarySearch().stringSearch(new String[]{"a", "b", "c", "e", "g", "i"}, "i");
        assertThat(idxFound).isEqualTo(5);
    }

    @Test
    void searchIntTest() {
        int idxFound = new BinarySearch().intSearch(new int[]{1, 2, 3, 6, 7, 8, 9, 13}, 9);
        assertThat(idxFound).isEqualTo(6);
    }

    @Test
    void noSearchIntTest() {
        //ref. https://www.baeldung.com/assertj-exception-assertion
        assertThatThrownBy(() -> {
            new BinarySearch().intSearch(new int[]{1, 2, 3, 6, 7, 8, 9, 13}, 10);
        }).isInstanceOf(NoSuchElementException.class)
        .hasMessageContaining("can't find target.");
    }

    @Test
    void lowerBoundaryTest() {
        int idxFound = new BinarySearch().lowerBoundary(new int[]{1, 2, 3, 3, 3, 5, 6, 7}, 3);
        assertThat(idxFound).isEqualTo(2);
    }
    @Test
    void lowerBoundaryTest2() {
        int idxFound = new BinarySearch().lowerBoundary(new int[]{1, 2, 2, 3, 3, 5, 6, 7}, 3);
        assertThat(idxFound).isEqualTo(3);
    }
    @Test
    void lowerBoundaryTest3() {
        int idxFound = new BinarySearch().lowerBoundary(new int[]{1, 2, 2, 3, 3, 5, 6, 7}, 4);
        assertThat(idxFound).isEqualTo(5);
    }
    @Test
    void lowerBoundaryNoFoundTest() {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 5, 6};
        assertThat(new BinarySearch().lowerBoundary(arr, 7)).isEqualTo(arr.length);
//        assertThatThrownBy(() -> {
//            new BinarySearch().lowerBoundary(arr, 7);
//        }).isInstanceOf(NoSuchElementException.class)
//                .hasMessageContaining("can't find target.");
    }
    @Test
    void lowerBoundaryNoFoundTest2() {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 5, 6};
        assertThat(new BinarySearch().lowerBoundary(arr, 0)).isEqualTo(0);
    }

    @Test
    void upperBoundaryTest() {
        int idxFound = new BinarySearch().upperBoundary(new int[]{1, 2, 3, 3, 3, 5, 6, 7}, 3);
        assertThat(idxFound).isEqualTo(5);
    }
    @Test
    void upperBoundaryTest2() {
        int idxFound = new BinarySearch().upperBoundary(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 3);
        assertThat(idxFound).isEqualTo(4);
    }

    @Test
    void upperBoundaryTest3() {
        int idxFound = new BinarySearch().upperBoundary(new int[]{1, 2, 3, 3, 5, 6, 7, 7}, 4);
        assertThat(idxFound).isEqualTo(4);
    }
    @Test
    void upperBoundaryNoFoundTest() {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 5, 6};
        int idxFound = new BinarySearch().upperBoundary(arr, 7);
        assertThat(idxFound).isEqualTo(arr.length);
    }
}
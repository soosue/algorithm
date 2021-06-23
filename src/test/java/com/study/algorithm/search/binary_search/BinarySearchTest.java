package com.study.algorithm.search.binary_search;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BinarySearchTest {

    @Test
    void searchStringTest() {
        int idxFinded = new BinarySearch().stringSearch(new String[]{"a", "b", "c", "e", "g", "i"}, "i");
        assertThat(idxFinded).isEqualTo(5);
    }

    @Test
    void searchIntTest() {
        int idxFinded = new BinarySearch().intSearch(new int[]{1, 2, 3, 6, 7, 8, 9, 13}, 9);
        assertThat(idxFinded).isEqualTo(6);
    }

    @Test
    void noSearchIntTest() {
        //ref. https://www.baeldung.com/assertj-exception-assertion
        assertThatThrownBy(() -> {
            new BinarySearch().intSearch(new int[]{1, 2, 3, 6, 7, 8, 9, 13}, 10);
        }).isInstanceOf(NoSuchElementException.class)
        .hasMessageContaining("can't find target.");
    }
}
package com.tomtom.paterncounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePhrasesPatternCounterTest {
    private PatternCounter patternCounter;

    @BeforeEach
    void init() {
        patternCounter = new UniquePhrasesPatternCounter();
    }

    @Test
    void countOccurrences() {
        List<String> inputData = List.of("hello world from 2023");

        Map<String, Integer> expectedOutput = Map.of(
                "hello world from", 1,
                "world from 2023", 1
        );

        Map<String, Integer> actualOutput = patternCounter.countOccurrences(inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertThat(actualOutput).containsKey("hello world from");
        assertThat(actualOutput).containsEntry("world from 2023", 1);
        assertThat(actualOutput).doesNotContainKey("2023");
        assertThat(actualOutput).doesNotContainKey("word");
    }

    @Test
    void givenStringWithLengthSmallerThan3_returnEmptyMap() {
        List<String> inputData = List.of("hello world ");

        Map<String, Integer> expectedOutput = Map.of();

        Map<String, Integer> actualOutput = patternCounter.countOccurrences(inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
    }
}
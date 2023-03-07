package com.tomtom.paterncounter;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueNumbersPatternCounterTest {

    @Test
    void countOccurrences() {
        List<String> inputData = List.of("hello world from 2023");

        PatternCounter patternCounter = new UniqueNumbersPatternCounter();

        Map<String, Integer> expectedOutput = Map.of("2023", 1);

        Map<String, Integer> actualOutput = patternCounter.countOccurrences(inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertThat(actualOutput).doesNotContainKey("hello");
        assertThat(actualOutput).containsEntry("2023", 1);
    }
}
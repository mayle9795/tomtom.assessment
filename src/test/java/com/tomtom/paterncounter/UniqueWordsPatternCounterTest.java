package com.tomtom.paterncounter;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueWordsPatternCounterTest {

    @Test
    void countOccurrences() {
        List<String> inputData = List.of("hello world from 2023");

        PatternCounter patternCounter = new UniqueWordsPatternCounter();

        Map<String, Integer> expectedOutput = Map.of(
                "hello", 1,
                "word", 1,
                "from", 1
        );

        Map<String, Integer> actualOutput = patternCounter.countOccurrences(inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertThat(actualOutput).containsKey("hello");
        assertThat(actualOutput).containsEntry("world", 1);
        assertThat(actualOutput).doesNotContainKey("2023");
    }
}
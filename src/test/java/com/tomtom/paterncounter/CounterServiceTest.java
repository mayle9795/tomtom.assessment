package com.tomtom.paterncounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CounterServiceTest {
    private CounterService counterService;

    @BeforeEach
    void init() {
        counterService = new CounterService();
    }

    @Test
    void givenOption1_returnUniqueWordsPattern() {
        assertTrue(counterService.getCounter(1) instanceof UniqueWordsPatternCounter);
    }

    @Test
    void givenOption2_returnUniqueNumbersPattern() {
        assertTrue(counterService.getCounter(2) instanceof UniqueNumbersPatternCounter);
    }

    @Test
    void givenOption3_returnUniquePhrasesPattern() {
        assertTrue(counterService.getCounter(3) instanceof UniquePhrasesPatternCounter);
    }

    @Test
    void givenOption4_throwsIllegalArgumentException() {
        try {
            counterService.getCounter(4);

            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid option. Valid options are from 1 to 3", ex.getMessage());
        }
    }

    @Test
    void countPhraseOccurrences() {
        List<String> inputData = List.of("hello world from 2023");

        Map<String, Integer> expectedOutput = Map.of(
                "hello world from", 1,
                "world from 2023", 1
        );

        Map<String, Integer> actualOutput = counterService.execute(3, inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertThat(actualOutput).containsKey("hello world from");
        assertThat(actualOutput).containsEntry("world from 2023", 1);
        assertThat(actualOutput).doesNotContainKey("2023");
        assertThat(actualOutput).doesNotContainKey("word");
    }

    @Test
    void countNumberOccurrences() {
        List<String> inputData = List.of("hello world from 2023");

        Map<String, Integer> expectedOutput = Map.of("2023", 1);

        Map<String, Integer> actualOutput = counterService.execute(2, inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertThat(actualOutput).doesNotContainKey("hello");
        assertThat(actualOutput).containsEntry("2023", 1);
    }

    @Test
    void countWordsOccurrences() {
        List<String> inputData = List.of("hello world from 2023");

        Map<String, Integer> expectedOutput = Map.of(
                "hello", 1,
                "word", 1,
                "from", 1
        );

        Map<String, Integer> actualOutput = counterService.execute(1, inputData);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertThat(actualOutput).containsKey("hello");
        assertThat(actualOutput).containsEntry("world", 1);
        assertThat(actualOutput).doesNotContainKey("2023");
    }
}
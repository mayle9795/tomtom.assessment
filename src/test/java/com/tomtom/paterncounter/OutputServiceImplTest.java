package com.tomtom.paterncounter;

import com.tomtom.paterncounter.impl.OutputServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputServiceImplTest {
    private OutputService outputService;

    @BeforeEach
    void init() {
        outputService = new OutputServiceImpl();
    }

    @Test
    void printOutput() {
        Map<String, Integer> outputMap = Map.of(
                "a", 2,
                "big", 2
        );

        String expectedStr = "a, 2\nbig, 2";

        assertEquals(expectedStr, outputService.printOutput(outputMap));
    }
}
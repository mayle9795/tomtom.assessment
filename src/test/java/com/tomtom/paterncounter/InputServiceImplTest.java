package com.tomtom.paterncounter;

import com.tomtom.paterncounter.impl.InputServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputServiceImplTest {
    private InputService inputService;

    @BeforeEach
    void init() {
        inputService = new InputServiceImpl();
    }

    @Test
    void givenPathFileName_returnContentOfInputSource() {
        List<String> lines = inputService.getInputSource("Input.txt");

        assertEquals(2, lines.size());
        assertEquals("1000 a big surprise 2000 hello is a big surprise 1000", lines.get(0));
        assertEquals("1002 a big surprise 2000 hello is a big surprise 1002", lines.get(1));
    }

    @Test
    void givenPathFileName_returnContentNull() {
        List<String> lines = inputService.getInputSource("InvalidInput.txt");

        assertTrue(lines.isEmpty());
    }
}
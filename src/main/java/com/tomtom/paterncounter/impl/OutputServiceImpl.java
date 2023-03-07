package com.tomtom.paterncounter.impl;

import com.tomtom.paterncounter.OutputService;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputServiceImpl implements OutputService {
    private static final String DELIMITER = ", ";
    private static final String NEW_LINE_DELIMITER = "\n";

    @Override
    public String printOutput(Map<String, Integer> outputs) {
        return outputs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
    }

}

package com.tomtom.paterncounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueNumbersPatternCounter implements PatternCounter {
    private static final String DELIMITER = " ";
    private static final String PATTERN = "[0-9]+";

    @Override
    public Map<String, Integer> countOccurrences(List<String> input) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : input) {
            String[] strArr = s.split(DELIMITER);

            for (String str : strArr) {
                if (str.matches(getPattern())) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
        }

        return map;
    }

    protected String getPattern() {
        return PATTERN;
    }
}

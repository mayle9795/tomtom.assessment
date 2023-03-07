package com.tomtom.paterncounter;

import java.util.List;
import java.util.Map;

public interface PatternCounter {
    Map<String, Integer> countOccurrences(List<String> input);
}

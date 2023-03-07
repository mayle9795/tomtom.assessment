package com.tomtom.paterncounter;

import java.util.List;
import java.util.Map;

public class CounterService {
    public Map<String, Integer> execute(int choice, List<String> inputSource) {
        return getCounter(choice).countOccurrences(inputSource);
    }

    PatternCounter getCounter(int choice) {
        switch (choice) {
            case 1:
                return new UniqueWordsPatternCounter();
            case 2:
                return new UniqueNumbersPatternCounter();
            case 3:
                return new UniquePhrasesPatternCounter();
        }

        throw new IllegalArgumentException("Invalid option. Valid options are from 1 to 3");
    }
}

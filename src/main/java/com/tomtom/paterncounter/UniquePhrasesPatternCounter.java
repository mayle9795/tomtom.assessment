package com.tomtom.paterncounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquePhrasesPatternCounter implements PatternCounter {
    private static final String DELIMITER = " ";

    @Override
    public Map<String, Integer> countOccurrences(List<String> input) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : input) {
            String[] strArr = s.split(DELIMITER);

            int left = 0;

            while (left < strArr.length - 2) {
                int i = left;
                int right = left + 2;

                StringBuilder stringBuilder = new StringBuilder();

                while (i <= right) {
                    stringBuilder.append(strArr[i]).append(" ");

                    i++;
                }

                map.put(stringBuilder.toString().trim(), map.getOrDefault(stringBuilder.toString().trim(), 0) + 1);

                left++;
            }
        }

        return map;
    }
}

package com.tomtom.paterncounter;

public class UniqueWordsPatternCounter extends UniqueNumbersPatternCounter {
    private static final String PATTERN = "[a-zA-Z]+";

    @Override
    protected String getPattern() {
        return PATTERN;
    }
}

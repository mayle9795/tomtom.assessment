package com.tomtom.paterncounter;

import com.tomtom.paterncounter.impl.InputServiceImpl;
import com.tomtom.paterncounter.impl.OutputServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PatternCounterApplication {
    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Invalid arguments. Valid arguments include fileName and choice of pattern ");
        }

        System.out.println("Processing request with parameters: " + Arrays.toString(args));
        
        InputService inputService = new InputServiceImpl();

        CounterService coreService = new CounterService();

        OutputService outputService = new OutputServiceImpl();

        List<String> inputData = inputService.getInputSource(args[0]);

        Map<String, Integer> outputs = coreService.execute(parseOption(args[1]), inputData);

        System.out.println("Outputs: " + outputService.printOutput(outputs));

    }

    private static int parseOption(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Option must be a number");
        }
    }

}

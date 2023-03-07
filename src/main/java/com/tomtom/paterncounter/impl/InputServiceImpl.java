package com.tomtom.paterncounter.impl;

import com.tomtom.paterncounter.InputService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InputServiceImpl implements InputService {

    @Override
    public List<String> getInputSource(String pathFileName) {
        try {
            URL resource = getClass().getClassLoader().getResource(pathFileName);

            if (resource != null) {
                return Files.readAllLines(Path.of(resource.toURI()));
            }

            return readFile(pathFileName);
        } catch (IOException | URISyntaxException e) {

            return readFile(pathFileName);
        }
    }

    private static List<String> readFile(String pathFileName) {
        try {
            return Files.readAllLines(Paths.get(pathFileName));
        } catch (IOException e) {
            System.out.println("Unable to read the file: " + pathFileName);
        }

        return List.of();
    }
}

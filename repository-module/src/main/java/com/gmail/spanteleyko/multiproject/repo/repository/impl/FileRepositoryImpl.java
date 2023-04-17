package com.gmail.spanteleyko.multiproject.repo.repository.impl;

import com.gmail.spanteleyko.multiproject.repo.exceptions.CustomException;
import com.gmail.spanteleyko.multiproject.repo.exceptions.FileNotExistsException;
import com.gmail.spanteleyko.multiproject.repo.repository.FileRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRepositoryImpl implements FileRepository {

    private static final Logger logger = LogManager.getLogger(FileRepositoryImpl.class);
    private static FileRepository fileRepository;

    public static FileRepository getInstance() {
        if (fileRepository == null) {
            fileRepository = new FileRepositoryImpl();
        }
        return fileRepository;
    }

    @Override
    public List<String> get(String fileName) throws Exception {
        return readFile(fileName);
    }

    private List<String> readFile(String fileName) throws Exception {
        List<String> lineArray = new ArrayList<>();

        File file = new File(fileName);

        try (Scanner myReader = new Scanner(file)) {

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lineArray.add(data);
            }

        } catch (FileNotFoundException e) {
            String errorMessage = String.format("File not exists: %s", file.getPath());
            logger.error(errorMessage);
            throw new FileNotExistsException(errorMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }

        return lineArray;
    }
}

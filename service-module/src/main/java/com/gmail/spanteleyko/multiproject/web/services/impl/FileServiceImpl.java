package com.gmail.spanteleyko.multiproject.web.services.impl;

import com.gmail.spanteleyko.multiproject.repo.repository.FileRepository;
import com.gmail.spanteleyko.multiproject.repo.repository.impl.FileRepositoryImpl;
import com.gmail.spanteleyko.multiproject.web.services.FileService;
import com.gmail.spanteleyko.multiproject.web.services.NumericService;

import java.util.List;

public class FileServiceImpl implements FileService {

    private  static FileService fileService;
    private FileRepository fileRepository = FileRepositoryImpl.getInstance();
    private NumericService numericService = NumericServiceImpl.getInstance();

    public static FileService getInstance(){
        if(fileService == null) {
            fileService = new FileServiceImpl();
        }
        return fileService;
    }

    public int calculateTotal(String fileName) throws Exception {

        List<String> lines = fileRepository.get(fileName);

        int total = 0;

        for (String line: lines) {
            total += numericService.add(line);
        }

        return total;
    }
}

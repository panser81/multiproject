package com.gmail.spanteleyko.multiproject.repo.repository;

import java.util.List;

public interface FileRepository {
    List<String> get(String fileName) throws Exception;
}

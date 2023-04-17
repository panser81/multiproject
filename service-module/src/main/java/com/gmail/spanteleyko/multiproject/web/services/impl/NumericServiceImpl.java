package com.gmail.spanteleyko.multiproject.web.services.impl;

import com.gmail.spanteleyko.multiproject.web.services.NumericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumericServiceImpl implements NumericService {
    private static final Logger logger = LogManager.getLogger(NumericServiceImpl.class);
    private static String[] separatorsArray = {",", ":", "|"};
    private static NumericService numericService;

    public static NumericService getInstance() {
        if (numericService == null) {
            numericService = new NumericServiceImpl();
        }
        return numericService;
    }

    public int add(String numbers) {
        if (numbers == null && numbers.equals("")) {
            return 0;
        }

        int total = 0;
        for (String separator : separatorsArray) {
            if (numbers.contains(separator)) {
                String[] numbersArray = numbers.split(separator);

                for (int i = 0; i < numbersArray.length; i++) {
                    try {
                        total += Integer.parseInt(numbersArray[i]);
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        }

        return total;
    }
}

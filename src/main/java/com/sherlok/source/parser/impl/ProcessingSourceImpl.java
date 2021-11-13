package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.ProcessingSource;
import org.apache.log4j.Logger;

public class ProcessingSourceImpl implements ProcessingSource {

    private static final Logger log = Logger.getLogger(ProcessingStringImpl.class);

    @Override
    public String[] split(String str) {
        String[] words = str.split("\\s{1,}");
        log.info("Разбиваем на слова");
        return words;
    }

}

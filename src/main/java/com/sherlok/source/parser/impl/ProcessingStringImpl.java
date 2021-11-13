package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.ProcessingString;
import org.apache.log4j.Logger;

public class ProcessingStringImpl implements ProcessingString {

    private static final Logger log = Logger.getLogger(ProcessingStringImpl.class);

    @Override
    public String replaceSigns(String str) {
        String regex = "[\\[|\\]\\?|\\(|\\)|\\*|\\:|\\;|\"|.|\\=|,|!|{|}|+|-|/|#|\\d+]";
        String text = str.replaceAll(regex, " ");
        log.info("Исключаем разделители...");
        return text.toUpperCase();
    }

}

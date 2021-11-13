package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.inface.PreprocessingSource;
import org.apache.log4j.Logger;

public class PreprocessingSourceImpl implements PreprocessingSource{

    private static final Logger log = Logger.getLogger(ProcessingStringImpl.class);

    @Override
    public String[] split(String str) {
        return str.split(" ");
    }

}

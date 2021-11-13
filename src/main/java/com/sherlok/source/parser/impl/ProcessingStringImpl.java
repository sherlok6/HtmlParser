package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.inface.ProcessingString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessingStringImpl implements ProcessingString {

    @Override
    public void removeHtmlTags(StringBuffer buf) {

    }

    @Override
    public void replaceSyntacticSigns(StringBuffer buf) {
        String regex = "/\\p{Lu} \\P{Lu}*/gu";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(buf);
        System.out.println(matcher.toMatchResult().toString());
    }
}

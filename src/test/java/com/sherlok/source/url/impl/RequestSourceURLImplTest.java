package com.sherlok.source.url.impl;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RequestSourceURLImplTest extends TestCase {
    Map<String, Boolean> urlMap = new TreeMap<>();
    RequestSourceURLImpl requestSourceURL = new RequestSourceURLImpl();

    public void initTest(){
        urlMap.put("http://proglang.su/java/url-processing", true);
        urlMap.put("", false);
        urlMap.put("https://javarush.ru/quests/lectures/questsyntaxpro.level15.lecture06", true);
        urlMap.put("просто url ХD", false);
    }

    public void testGetHtml() throws IOException {
        initTest();
        for(Map.Entry<String, Boolean> entry: urlMap.entrySet()){
            if (entry.getValue()){
                URL url = new URL(entry.getKey());
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(url.openStream()));
                BufferedReader test = requestSourceURL.getBuffHtml(entry.getKey());
                System.out.println(Arrays.toString(test.lines().toArray()));
                System.out.println(Arrays.toString(reader.lines().toArray()));
            }
        }
    }

    public void testIsURL() {
        initTest();
        for(Map.Entry<String, Boolean> entry: urlMap.entrySet()){
            boolean t= requestSourceURL.isURL(entry.getKey());
            boolean v= entry.getValue();
            System.out.println("test = "+ t + " value= " + v);
        }
    }
}
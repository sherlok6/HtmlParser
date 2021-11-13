package com.sherlok.source.url.impl;

import junit.framework.TestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public class RequestSourceURLImplTest extends TestCase {
    Map<String, Boolean> urlMap = new TreeMap<>();
    SourceURLImpl requestSourceURL = new SourceURLImpl();

    public void initTest(){
        urlMap.put("http://proglang.su/java/url-processing", true);
        urlMap.put("", false);
        urlMap.put("https://javarush.ru/quests/lectures/questsyntaxpro.level15.lecture06", true);
        urlMap.put("просто url ХD", false);
    }

    public void testURL(){
        try {
            URL url = new URL("http://proglang.su/java/url-processing");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            Document document = Jsoup.parse(url, 3000);
            String testContent = new String(document.body().text());
            System.out.println(testContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetHtml() throws IOException {
        initTest();
        for(Map.Entry<String, Boolean> entry: urlMap.entrySet()){
            if (entry.getValue()){
                URL url = new URL(entry.getKey());
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
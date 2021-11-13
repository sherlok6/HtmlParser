package com.sherlok.source;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Application {
    private static final Logger log = Logger.getLogger(Application.class);

    public static void main(String args[]) throws MalformedURLException {
        Scanner scanner = new Scanner(System.in);
        AnalyzerText analyzerText = new AnalyzerText();

        System.out.println("Укажите URL:");
        URL url = new URL(scanner.next());

        analyzerText.initDict(url.toString());

        log.info("Был введен следующий url:" + url.toString());

        Dictionary dictionary = Dictionary.getInstance();

        System.out.println(dictionary.toString());
    }
}

package com.sherlok.source;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**Класс с которого приложение начинает работу содержит <b>log</b>{@link Logger} и метод для запуска.
 * Программа считывает с консоли url адрес страницы, обрабатывает её с помощью объекта класса {@link AnalyzerText}
 * и выводит результат анализа, хранящийся в объекте-одиночке{@link Dictionary}.
 *
 * @author sherlok6
 * @version 1.0
 * **/
public class Application {

    /** Объект для логирования, полученный методом {@link Logger#getLogger(Class)}**/
    private static final Logger log = Logger.getLogger(Application.class);

    public static void main(String args[]) throws MalformedURLException {
        Scanner scanner = new Scanner(System.in);
        AnalyzerText analyzerText = new AnalyzerText();

        System.out.println("Укажите URL:");
        URL url = new URL(scanner.next());

        analyzerText.start(url.toString());

        log.info("Был введен следующий url:" + url.toString());

        Dictionary dictionary = Dictionary.getInstance();

        System.out.println(dictionary.toString());
    }
}

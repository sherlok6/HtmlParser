package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.ProcessingSource;
import org.apache.log4j.Logger;

/** Класс реализует интерфейс {@link ProcessingSource} и содержит объект {@param log}
 *  класса {@link Logger} для логирования
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public class ProcessingSourceImpl implements ProcessingSource {

    /** Объект для логирования, полученный методом {@link Logger#getLogger(Class)}**/
    private static final Logger log = Logger.getLogger(ProcessingStringImpl.class);

    /** Разбивает строку {@param str} на массив строк с помощью метода {@link String#split(String)}.
     * В качестве регулярного выражения для разбиения было выбрано \s{1,}.
     * Также происходит запись в лог файл через объект {@link ProcessingSourceImpl#log}, для отслеживания
     * @return массив строк, вычисленный путем разбиения этой строки на совпадения с заданным регулярным выражением
     * **/
    @Override
    public String[] split(String str) {
        String[] words = str.split("\\s{1,}");
        log.info("Разбиваем на слова");
        return words;
    }

}

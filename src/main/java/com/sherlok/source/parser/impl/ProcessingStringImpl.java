package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.ProcessingSource;
import com.sherlok.source.parser.ProcessingString;
import org.apache.log4j.Logger;

/** Класс реализует интерфейс {@link ProcessingString},содержит объект {@param log} и свойство <b>regex</b>.
 *  класса {@link Logger} для логирования
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public class ProcessingStringImpl implements ProcessingString {

    /** Объект для логирования, полученный методом {@link Logger#getLogger(Class)}**/
    private static final Logger log = Logger.getLogger(ProcessingStringImpl.class);

    /**Содержит шаблон по которому будут находится элементы для замены**/
    private static String regex = "[\\[|\\]\\?|\\(|\\)|\\*|\\:|\\;|\"|.|\\=|,|!|{|}|+|-|/|#|\\d+]";

    /** Заменяет все подходящие под шаблон {@link ProcessingStringImpl#regex} на пробел
     * @return Строку без лишних разделителей указанных в {@link ProcessingStringImpl#regex} в верхнем регистре,
     * используя метод {@link String#toUpperCase()}
     * **/
    @Override
    public String replaceSigns(String str) {
        String text = str.replaceAll(regex, " ");
        log.info("Исключаем разделители...");
        return text.toUpperCase();
    }

}

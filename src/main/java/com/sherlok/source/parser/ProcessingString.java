package com.sherlok.source.parser;

/** Интерфейс определяет каким образом в исходном тексте {@param buf} будут заменены разделители
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public interface ProcessingString {

    /** Изменяет входной текст {@param buf} и возвращает текст без разделителей**/
    String replaceSigns(String buf);
}

package com.sherlok.source.parser;

/** Интерфейс определяет каким образом исходный текст {@param str} будет разбит на слова
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public interface ProcessingSource {

    /**Разбивает текст, не содержащий разделителей {@link ProcessingString}, на массив слов**/
    String[] split(String str);
}

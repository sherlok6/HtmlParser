package com.sherlok.source;

import com.sherlok.source.model.Word;
import com.sherlok.source.parser.ProcessingSource;
import com.sherlok.source.parser.ProcessingString;
import com.sherlok.source.parser.impl.ProcessingSourceImpl;
import com.sherlok.source.parser.impl.ProcessingStringImpl;
import com.sherlok.source.url.SourceURL;
import com.sherlok.source.url.impl.SourceURLImpl;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

/**Класс, анализирующий получаемый из <b>sourceURL</b>{@link SourceURL},
 *   обработанный с помощью <b>processingString</b>{@link ProcessingString}
 *   и <b>processingSource</b>{@link ProcessingSource} и хранимый в <b>text</b>.
 * Содержит ссылку на "одиночку"<b>dictionary</b>{@link Dictionary} и объект для логирования <b>log</b>
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public class AnalyzerText {

    /** Объект для логирования, полученный методом {@link Logger#getLogger(Class)}**/
    private static final Logger log = Logger.getLogger(AnalyzerText.class);

    /**Ссылка на одиночку**/
    Dictionary dictionary;

    /**Для обработки URL-запроса**/
    private SourceURL sourceURL = new SourceURLImpl();

    /**Свойство для текста страницы**/
    private String text;

    /**Для обработки текста,замена разделителей**/
    private ProcessingString processingString = new ProcessingStringImpl();

    /**Для разбиения на слова**/
    private ProcessingSource processingSource = new ProcessingSourceImpl();

    /**Констуктор для создания нового объекта**/
    public AnalyzerText(){};

    /**Запускает анализ по указанному пути {@param path}. Делает запись в лог-файле о получении текста**/
    public void start(String path){
            text = sourceURL.getBuffHtml(path);
            log.info("Получили текст страницы");
            text = processingString.replaceSigns(text);
            fillDict(processingSource.split(text));
    }

    /**Метод заполняет словарь словами из массива слов{@param words}. Для определения кол-ва дубликтов
     * использовался {@link Collections#frequency(Collection, Object)} в качестве коллекции использовался
     * объект класса {@link LinkedList}. Делает запись в лог о количестве слов в тексте**/
    private void fillDict(String[] words){
        int count = words.length;

        dictionary = Dictionary.getInstance();
        dictionary.setWordCount(count);

        log.info("Слов на странице: " + dictionary.getWordCount());

        LinkedList<String> wordsList = new LinkedList<>(Arrays.asList(words));

        Stream<String> stream = wordsList.stream();
        stream.forEach((str)->{
            Word w = new Word(str, Collections.frequency(wordsList, str));
            if(!dictionary.containWord(w)) {
                dictionary.addWord(w);
            }
        });
    }

}

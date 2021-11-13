package com.sherlok.source;

import com.sherlok.source.model.Word;
import com.sherlok.source.parser.ProcessingSource;
import com.sherlok.source.parser.ProcessingString;
import com.sherlok.source.parser.impl.ProcessingSourceImpl;
import com.sherlok.source.parser.impl.ProcessingStringImpl;
import com.sherlok.source.url.SourceURL;
import com.sherlok.source.url.impl.SourceURLImpl;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public class AnalyzerText {

    private static final Logger log = Logger.getLogger(AnalyzerText.class);

    Dictionary dictionary;

    private SourceURL sourceURL = new SourceURLImpl();

    String text;

    private ProcessingString processingString = new ProcessingStringImpl();
    private ProcessingSource processingSource = new ProcessingSourceImpl();

    public AnalyzerText(){};

    public void initDict(String path) throws MalformedURLException {
            text = sourceURL.getBuffHtml(path);
            log.info("Получили текст страницы");
            text = processingString.replaceSigns(text);
            toDict(processingSource.split(text));
    }

    private void toDict(String[] words){
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
                dictionary.incCount(w.getCount());
            }
        });
    }

}

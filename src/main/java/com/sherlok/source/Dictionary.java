package com.sherlok.source;

import com.sherlok.source.model.Word;
import org.apache.log4j.Logger;

import java.util.Set;
import java.util.TreeSet;

public class Dictionary {

    private static final Logger log = Logger.getLogger(Dictionary.class);

    private static Dictionary instance;

    private Set<Word> wordSet;

    private int wordCount;

    private Dictionary(){
        this.wordSet = new TreeSet<>();
    }

    public static Dictionary getInstance(){
        if (instance == null){
            instance = new Dictionary();
            log.info("Инициализирован словарь");
        }
        return instance;
    }

    public void setWordCount(int wCount){
        this.wordCount = wCount;
    }

    public void incCount(int diff){
        wordCount -= diff;
    }

    public void addWord(Word w){
        this.wordSet.add(w);
    }

    public boolean containWord(Word w){
        return wordSet.contains(w);
    }

    public int getWordCount(){
        return wordCount;
    }

    @Override
    public String toString() {
        if(wordSet!=null){
            StringBuilder dict = new StringBuilder(" ");
            for (Word w : wordSet) {
                dict.append(w.getName());
                dict.append(" - ");
                dict.append(w.getCount()).append("\n ");
            }
            return dict.toString();
        }
        return "Пусто";
    }
}

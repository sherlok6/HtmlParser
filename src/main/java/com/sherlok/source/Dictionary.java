package com.sherlok.source;

import com.sherlok.source.model.Word;
import org.apache.log4j.Logger;

import java.util.Set;
import java.util.TreeSet;

/**Ялвяется lazy-реализацией Singleton, содержит объект для логирования, свойство для хранения объекта-одиночки,
 * коллекцию <b>wordSet</b>, и свойство <b>wordCount</b>.
 * Хранит информацию о тексте: о общем количестве слов в тексте и инфформацию о каждом слове
 * {@link Word}, хранящихся в <b>wordSet</b>
 *
 * @author sherlok6
 * @version 1.0
 * **/
public class Dictionary {

    /** Объект для логирования, полученный методом {@link Logger#getLogger(Class)}**/
    private static final Logger log = Logger.getLogger(Dictionary.class);

    /**Свойство для хранения объекта-одиночки**/
    private static Dictionary instance;

    /**{@link TreeSet} для хранения объектов класса {@link Word}**/
    private TreeSet<Word> wordSet;

    /**Свойство - общее количество слов**/
    private int wordCount;

    /**Конструктор для создания одиночного объекта и инициализации пустого wordSet**/
    private Dictionary(){
        wordSet = new TreeSet<>();
    }

    /**Метод для извлечения уже созданного объекта,если создан, иначе создаёт,делает запись в лог-файл,
     * такой и возвращает его
     * @return instance
     **/
    public static Dictionary getInstance(){
        if (instance == null){
            instance = new Dictionary();
            log.info("Инициализирован словарь");
        }
        return instance;
    }

    /** Задает количество слов в тексте, которое можно получить при помощи метода {@link #getWordCount()}
     @param wCount Новое значение wordCount*/
    public void setWordCount(int wCount){
        this.wordCount = wCount;
    }

    /**Метод для добавления нового слова в wordSet**/
    public void addWord(Word w){
        this.wordSet.add(w);
    }

    /**Проверяет находится ли {@param w} в wordSet
     * @return false-нет,true-да
     **/
    public boolean containWord(Word w){
        return wordSet.contains(w);
    }

    /**Получает значение свойства wordCount, которое можно задать с помощью метода {@link #setWordCount(int)}}
     @return Значение свойства wordCount**/
    public int getWordCount(){
        return wordCount;
    }

    /**Выводит всю информацию о найденных словах,если wordSet не пуст**/
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

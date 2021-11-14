package com.sherlok.source.model;

/**Класс служит для хранения слова <b>name</b> и его частоты <b>count</b> в тексте.
 * Также реализует интерфейс {@link Comparable}, т.к. не является стандартным.
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public class Word implements Comparable<Word>{

    /**Свойство - name**/
    private String name;

    /**Свойство - count**/
    private int count;

    /**Конструктор для создания нового объекта с конкретными значениями
     * @param name - слово
     * @param count - частота его вхождений в тексте**/
    public Word(String name, int count){
        this.name = name;
        this.count = count;
    };

    /**Получает значение свойства name, которое можно задать с помощью метода {@link #setName(String)}
     @return Значение свойства name**/
    public String getName() {
        return name;
    }

    /** Задает значение свойства name, которое можно получить при помощи метода {@link #getName()}
     @param name Новое значение свойства name*/
    public void setName(String name) {
        this.name = name;
    }

    /**Получает значение свойства count, которое можно получить при помощи метода {@link #setCount(int)}
     * @return Значение свойства count**/
    public int getCount() {
        return count;
    }

    /** Задает значение свойства count, которое можно получить при помощи метода {@link #getCount()}
     @param count Новое значение свойства count*/
    public void setCount(int count) {
        this.count = count;
    }

    /**Переопределяет метод {@link Object#hashCode()}**/
    @Override
    public int hashCode() { return name.hashCode(); }

    /**Переопределяет метод {@link Object#equals(Object)}**/
    @Override
    public boolean equals(Object obj){ return name.equals(((Word)obj).name); }

    /**Реализует метод {@link Comparable#compareTo(Object)}**/
    @Override
    public int compareTo(Word o) {
        return name.compareTo(o.getName());
    }
}

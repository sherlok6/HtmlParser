package com.sherlok.source.model;

public class Word implements Comparable<Word>{

    private String name;
    private int count;

    public Word(String name, int count){
        this.name = name;
        this.count = count;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() { return name.hashCode(); }

    @Override
    public boolean equals(Object obj){ return name.equals(((Word)obj).name);}

    @Override
    public int compareTo(Word o) {
        return name.compareTo(o.getName());
    }
}

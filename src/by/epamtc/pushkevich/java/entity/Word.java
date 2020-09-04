package by.epamtc.pushkevich.java.entity;

import java.io.Serializable;
import java.util.Objects;

public class Word implements Serializable, Content {
    public static final long serialVersionUID = 1L;
    String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String getContent() {
        return word;
    }
}

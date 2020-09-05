package by.epamtc.pushkevich.java.entity;

import java.io.Serializable;
import java.util.Objects;

public class Sentence implements Serializable, Content {
    public static final long SerialVersionUID = 1L;
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence() {
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                '}';
    }

    @Override
    public String getContent() {
        return sentence;
    }
}

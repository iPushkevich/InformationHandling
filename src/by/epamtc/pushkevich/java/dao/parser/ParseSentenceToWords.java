package by.epamtc.pushkevich.java.dao.parser;

import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class ParseSentenceToWords implements TextParser {
    public List<Content> parse(String sentence) {
        String pattern = "[\\p{Punct}\\s]+";
        List<Content> words = new ArrayList<>();
        String[] wordsArray = sentence.split(pattern);

        for (String s : wordsArray) {
            words.add(new Word(s));
        }

        return words;
    }
}

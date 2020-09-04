package by.epamtc.pushkevich.java.dao.parser;

import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.entity.Sentence;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ParseTextToSentences implements TextParser {

    public List<Content> parse(String text) {
        List<Content> sentences = new ArrayList<>();
        BreakIterator bi = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        bi.setText(text);
        int start = 0;
        int end;

        while ((end = bi.next()) != BreakIterator.DONE) {
            String sentence = text.substring(start, end);
            start = end;
            sentences.add(new Sentence(sentence));
        }

        return sentences;
    }
}

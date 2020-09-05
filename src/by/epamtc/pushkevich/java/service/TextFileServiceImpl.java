package by.epamtc.pushkevich.java.service;

import by.epamtc.pushkevich.java.dao.TextFileDao;
import by.epamtc.pushkevich.java.dao.impl.TextFileDAOImpl;
import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.entity.Word;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileServiceImpl implements TextFileService {
    private final TextFileDao dao = new TextFileDAOImpl();

    @Override
    public String getText(File file) throws IOException {
        return dao.getText(file);
    }

    @Override
    public List<Content> getAllSentences(String textFile) {
        return dao.getAllSentences(textFile);
    }

    @Override
    public List<Content> getAllWords(String textFile) {
        return dao.getAllWords(textFile);
    }

    @Override
    public List<Content> getWordsFromInterrogativeSentence(String textFile) {
        List<Content> sentences = getAllSentences(textFile);
        List<Content> words = new ArrayList<>();

        for (Content c : sentences) {
            if (c.getContent().endsWith("?")) {
                String[] tmpWords = c.getContent().split("[\\p{Punct}\\s]+");
                for (String s : tmpWords) {
                    words.add(new Word(s));
                }
            }
        }

        return words;
    }

    @Override
    public List<Content> getReversOrderedSentences(String textFile) {
        List<Content> sentences = getAllSentences(textFile);
        List<Content> reversedSentences = new ArrayList<>();

        for (int i = sentences.size() - 1; i >= 0; i--) {
            reversedSentences.add(sentences.get(i));
        }

        return reversedSentences;
    }

}

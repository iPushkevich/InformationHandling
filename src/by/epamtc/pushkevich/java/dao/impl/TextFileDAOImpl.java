package by.epamtc.pushkevich.java.dao.impl;

import by.epamtc.pushkevich.java.dao.TextFileDao;
import by.epamtc.pushkevich.java.dao.parser.ParseSentenceToWords;
import by.epamtc.pushkevich.java.dao.parser.ParseTextToSentences;
import by.epamtc.pushkevich.java.dao.parser.TextParser;
import by.epamtc.pushkevich.java.entity.Content;

import java.io.*;
import java.util.List;

public class TextFileDAOImpl implements TextFileDao {
    private TextParser parser;

    @Override
    public String getText(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder stringBuilder = new StringBuilder();
        String text;

        while ((text = reader.readLine()) != null) {
            stringBuilder.append(text);
        }

        return String.valueOf(stringBuilder);
    }

    @Override
    public List<Content> getAllSentences(String textFile) {
        parser = new ParseTextToSentences();
        return parser.parse(textFile);
    }

    @Override
    public List<Content> getAllWords(String textFile) {
        parser = new ParseSentenceToWords();
        return parser.parse(textFile);
    }
}


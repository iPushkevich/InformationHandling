package by.epamtc.pushkevich.java.dao;

import by.epamtc.pushkevich.java.entity.Content;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface TextFileDao {
    String getText(File file) throws IOException;

    List<Content> getAllSentences(String textFile);

    List<Content> getAllWords(String textFile);
}

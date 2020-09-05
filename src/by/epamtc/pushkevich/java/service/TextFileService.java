package by.epamtc.pushkevich.java.service;

import by.epamtc.pushkevich.java.entity.Content;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface TextFileService {
    String getText(File file) throws IOException;

    List<Content> getAllSentences(String textFile);

    List<Content> getAllWords(String textFile);

    List<Content> getWordsFromInterrogativeSentence(String textFile);

    List<Content> getReversOrderedSentences(String textFile);

}

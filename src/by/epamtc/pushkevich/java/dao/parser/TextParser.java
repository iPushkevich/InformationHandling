package by.epamtc.pushkevich.java.dao.parser;

import by.epamtc.pushkevich.java.entity.Content;

import java.util.List;

public interface TextParser {
    List<Content> parse(String text);
}

package by.epamtc.pushkevich.java.controller.command;

import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.service.TextFileService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WordsFromInterrogativeSentenceCommand implements Command {

    @Override
    public List<Content> execute(File file) throws IOException {
        TextFileService service = getService();
        String text = service.getText(file);

        return service.getWordsFromInterrogativeSentence(text);
    }
}

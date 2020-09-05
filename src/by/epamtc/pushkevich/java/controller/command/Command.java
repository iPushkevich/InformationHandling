package by.epamtc.pushkevich.java.controller.command;

import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.service.TextFileService;
import by.epamtc.pushkevich.java.service.TextFileServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Command {
    List<Content> execute(File file) throws IOException;

    default TextFileService getService(){
        return new TextFileServiceImpl();
    }
}

package by.epamtc.pushkevich.java;

import by.epamtc.pushkevich.java.dao.impl.TextFileDAOImpl;
import by.epamtc.pushkevich.java.entity.RequestDTO;
import by.epamtc.pushkevich.java.service.TextFileServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 6666;
        try (ServerSocket ss = new ServerSocket(port);
             Socket socket = ss.accept()) {


            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectInputStream inputStream = new ObjectInputStream(in);
            ObjectOutputStream outputStream = new ObjectOutputStream(out);

            RequestDTO requestDTO = (RequestDTO) inputStream.readObject();
            File requestFile = requestDTO.getFile();

            String textFile = new TextFileDAOImpl().getText(requestFile);

            outputStream.writeObject(new TextFileServiceImpl().getWordsFromInterrogativeSentence(textFile));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


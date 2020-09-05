package by.epamtc.pushkevich.java;

import by.epamtc.pushkevich.java.controller.command.Command;
import by.epamtc.pushkevich.java.controller.command.CommandProvider;
import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.entity.RequestDTO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

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
            String request = requestDTO.getAction();

            Command command = getCommand(request);

            List<Content> content = command.execute(requestFile);
            outputStream.writeObject(content);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Command getCommand(String commandName) {
        CommandProvider provider = new CommandProvider();
        return provider.getCommand(commandName);
    }
}

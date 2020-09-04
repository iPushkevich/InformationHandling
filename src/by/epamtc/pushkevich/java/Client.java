package by.epamtc.pushkevich.java;

import by.epamtc.pushkevich.java.entity.Content;
import by.epamtc.pushkevich.java.entity.RequestDTO;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int serverPort = 6666;

        try (Socket socket = new Socket()) {

            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), serverPort));

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectOutput outputStream = new ObjectOutputStream(out);
            ObjectInputStream inputStream = new ObjectInputStream(in);

            outputStream.writeObject(new RequestDTO(new File("resources/request.txt"), "op"));
            List<Content> resp = (List<Content>) inputStream.readObject();

            writeResponse(resp);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void writeResponse(List<Content> response) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resources/response.txt")));

        for (Content s : response) {
            writer.write(s.getContent() + "\n");
            writer.flush();
        }
    }
}


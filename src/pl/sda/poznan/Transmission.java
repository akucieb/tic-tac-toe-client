package pl.sda.poznan;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Transmission {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public Transmission(Socket socket) throws IOException {
        this.socket = socket;
//    this.inputStream = new ObjectInputStream(socket.getInputStream());
//    this.outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendObject(Object obj) throws IOException {
        if (outputStream == null) {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }
        outputStream.writeObject(obj);
        outputStream.flush();
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        if (inputStream == null) {
            inputStream = new ObjectInputStream(socket.getInputStream());
        }
        return inputStream.readObject();
    }
}
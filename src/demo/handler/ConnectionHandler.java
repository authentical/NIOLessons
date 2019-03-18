package demo.handler;

import demo.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


// I don't like the name of this class since it's
// Handling a connection specifically in order to do 1 thing,
// return text in a particular way but I can't figure out what
// to call it

public class ConnectionHandler implements Handler<Socket> {

    // Take in text via telnet and echo to the same socket
    // with alpha capitalization flipped.
    @Override
    public void handle(Socket clientSocket) throws IOException {

        try (
                clientSocket;
                /* Checked exceptions are problematic with lambdas so wrap these with UncheckedIOException */
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream();
        ) {

            int data;
            while ((data = in.read()) != -1) {

                out.write(Util.xorAlphas(data));
            }
        }
    }
}

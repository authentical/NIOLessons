package NonBlocking.handler;

import Blocking.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


//Decorator for Stream data
public class StreamHandler implements Handler<Socket> {

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
                if(data=='%') throw new IOException("Somethings wrong");
                out.write(Util.xorAlphas(data));
            }
        }
    }
}

package demo.server;

import demo.handler.*;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;


public class MultiThreadedBlockingServer {

    // == Fields ==


    // == MAIN ==

    public static void main(String[] args) throws IOException {


        ServerSocket serverSock = new ServerSocket(8010);
        Handler<Socket> handler =
                new ThreadedHandler<>(
                        new PrintingHandler<>(
                                new ConnectionHandler()
                        )
                );


        while (true) {

            Socket clientSocket = serverSock.accept();

            handler.handle(clientSocket);
        }
    }
}

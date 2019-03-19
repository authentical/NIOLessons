package Blocking.server;

import Blocking.handler.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiThreadedBlockingServer {

    // == Fields ==


    // == MAIN ==

    public static void main(String[] args) throws IOException {


        ServerSocket serverSock = new ServerSocket(8010);
        Handler<Socket> handler =
                new ThreadedHandler<>(
                        new PrintingHandler<>(
                                new StreamHandler()
                        )
                );


        while (true) {

            Socket clientSocket = serverSock.accept();

            handler.handle(clientSocket);
        }
    }
}

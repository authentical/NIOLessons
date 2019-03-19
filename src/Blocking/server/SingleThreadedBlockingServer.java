package Blocking.server;

import Blocking.handler.StreamHandler;
import Blocking.handler.Handler;
import Blocking.handler.PrintingHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSock = new ServerSocket(8010);

        Handler<Socket> handler = new PrintingHandler<>(
                new StreamHandler()
        );


        while(true){

            Socket client = serverSock.accept();
            handler.handle(client);
        }
    }


}

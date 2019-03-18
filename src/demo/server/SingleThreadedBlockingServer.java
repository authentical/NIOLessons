package demo.server;

import demo.handler.ConnectionHandler;
import demo.handler.Handler;
import demo.handler.PrintingHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSock = new ServerSocket(8010);
        Handler<Socket> handler = new PrintingHandler<>(
                new ConnectionHandler()
        );


        while(true){

            Socket client = serverSock.accept();
            handler.handle(client);
        }
    }


}

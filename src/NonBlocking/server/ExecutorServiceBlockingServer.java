package NonBlocking.server;

import NonBlocking.handler.ExecutorServiceHandler;
import NonBlocking.handler.Handler;
import NonBlocking.handler.PrintingHandler;
import NonBlocking.handler.StreamHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;


public class ExecutorServiceBlockingServer {

    // == Fields ==


    // == MAIN ==

    public static void main(String[] args) throws IOException {


        ServerSocket serverSock = new ServerSocket(8010);

        Handler<Socket> handler =
                new ExecutorServiceHandler<>(
                        new PrintingHandler<>(
                                new StreamHandler()
                        ),
                        Executors.newCachedThreadPool(),
                        (t,e) -> System.out.println("Uncaught: " + t +" with error " + e)

                );


        while (true) {

            Socket clientSocket = serverSock.accept();

            handler.handle(clientSocket);
        }
    }
}

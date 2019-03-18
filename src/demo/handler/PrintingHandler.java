package demo.handler;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintingHandler<S> implements Handler<S> {

    private final Handler<S> connectionHandler;

    private static AtomicInteger clientCount = new AtomicInteger(0);

    public PrintingHandler(Handler<S> connectionHandler) {
        this.connectionHandler = connectionHandler;
    }


    @Override
    public void handle(S clientSocket) throws IOException {

        System.out.println("CLIENT " + clientCount.incrementAndGet() + " connected to " + clientSocket);
        try{
            connectionHandler.handle(clientSocket);
        } finally {
            System.out.println(clientSocket + " disconnected.");
        }
    }
}

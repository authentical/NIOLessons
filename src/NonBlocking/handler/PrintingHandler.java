package NonBlocking.handler;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


//Decorator for Printing information
public class PrintingHandler<S> extends DecoratorHandler<S> {

    private static AtomicInteger clientCount = new AtomicInteger(0);

    public PrintingHandler(Handler<S> otherHandler) {
        super(otherHandler);
    }

    @Override
    public void handle(S clientSocket) throws IOException {

        System.out.println("CLIENT " + clientCount.incrementAndGet() + " connected to " + clientSocket);
        try{
            super.handle(clientSocket);
        } finally {
            System.out.println(clientSocket + " disconnected.");
        }
    }
}

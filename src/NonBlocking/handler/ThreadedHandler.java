package NonBlocking.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedHandler<S>
        extends UncheckedIOExceptionConvertorHandler<S> {

    public ThreadedHandler(Handler<S> otherHandler) {
        super(otherHandler);
    }

    @Override
    public void handle(S s) {
        // Create a new thread and call UncheckedIOExceptionConvertorHandler's
        // handle()


        new Thread(()-> super.handle(s)).start();
    }
}

package Blocking.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class ExecutorServiceHandler<S>
        extends DecoratorHandler<S> {


    private final ExecutorService execService;
    private Thread.UncaughtExceptionHandler exceptionHandler;


    public ExecutorServiceHandler(
            Handler<S> otherHandler,
            ExecutorService execService,
            Thread.UncaughtExceptionHandler exceptionHandler
            ) {

        super(otherHandler);
        this.execService = execService;
        this.exceptionHandler = exceptionHandler;

    }

    @Override
    public void handle(S s) {

        // Submit a (Runnable)FutureTask that can expose it's exception and throw it
        execService.submit(             // Callable        Result
                new FutureTask<>(()-> { super.handle(s);  return null; })
                {
                    /* void setExcetion(Throwable t)   from JAVADOC
                    Causes this future to report an {@link ExecutionException}
                    with the given throwable as its cause, unless this future has
                    already been set or has been cancelled.

                    This method is invoked internally by the run method
                    upon failure of the computation. */
                    protected void setException(Throwable t){
                        exceptionHandler.uncaughtException(Thread.currentThread(), t);
                    }

                });

    }
}

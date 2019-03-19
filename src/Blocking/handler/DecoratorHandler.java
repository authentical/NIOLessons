package Blocking.handler;

import java.io.IOException;

// Decorator common abstract super class
public abstract class DecoratorHandler<S> implements Handler<S>{

    private final Handler<S> encapsulatedHandler;

    protected DecoratorHandler(Handler<S> encapsulatedHandler) {
        this.encapsulatedHandler = encapsulatedHandler;
    }

    @Override
    public void handle(S s) throws IOException {
        encapsulatedHandler.handle(s);
    }
}

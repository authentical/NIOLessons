package Blocking.handler;

import java.io.IOException;
import java.io.UncheckedIOException;


//Decorator for In-Thread stream management
public class UncheckedIOExceptionConvertorHandler<S> extends DecoratorHandler<S> {

    public UncheckedIOExceptionConvertorHandler( Handler<S> otherHandler) {
        super(otherHandler);
    }

    @Override
    public void handle(S s) {

        try{
            super.handle(s);

        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}

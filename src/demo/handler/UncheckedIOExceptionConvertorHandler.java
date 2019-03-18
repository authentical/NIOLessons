package demo.handler;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIOExceptionConvertorHandler<S>
        implements Handler<S> {


    private final Handler<S> otherHandler;


    public UncheckedIOExceptionConvertorHandler(Handler<S> otherHandler) {
        this.otherHandler = otherHandler;
    }

    @Override
    public void handle(S s) {

        try{
            otherHandler.handle(s);

        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}

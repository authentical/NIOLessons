package Blocking.handler;

import java.io.IOException;


// Decorator Component
public interface Handler<S> {

    // Instructor remark: Exceptions and Generics don't play together very well

    void handle(S s) throws IOException;
}

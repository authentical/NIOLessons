package demo.handler;

import java.io.IOException;

public interface Handler<S> {

    // Instructor remark: Exceptions and Generics don't play together very well

    void handle(S s) throws IOException;
}

package demo;

import java.io.IOException;
import java.net.Socket;

public class NastyClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket[] sockets = new Socket[50000];
        for(int i=0; i< sockets.length; i++){
            sockets[i] = new Socket("localhost", 8010);
        }

        Thread.sleep(1_000_000);
    }
}

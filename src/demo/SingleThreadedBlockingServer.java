package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSock = new ServerSocket(8010);

        while(true){

            Socket clientSock = serverSock.accept();
            InputStream in = clientSock.getInputStream();
            OutputStream out = clientSock.getOutputStream();


        }
    }
}

package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSock = new ServerSocket(8010);

        while(true){

            Socket client = serverSock.accept();

            handle(client);
        }
    }

    private static void handle(Socket client) throws IOException{


        System.out.println("Connected to " + client);

        try(client;
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            )
        {

            int data;

            while ((data = in.read()) != -1) {

                out.write(xorAlphas(data));  // Write transmogrified data
            }

        } finally {
            System.out.println(client + " disconnected.");
        }
    }

    private static int xorAlphas(int data){

        return Character.isLetter(data) ? data ^ ' ' : data;
        // If its a letter, return data XOR ' ', if not letter, return data

    }
}

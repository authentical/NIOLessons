package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBlockingServer {


    public static void main(String[] args) throws IOException {

        ServerSocket serverSock = new ServerSocket(8010);

        while (true) {

            Socket client = serverSock.accept();

            handle(client); // New thread for each client
        }
    }

    private static void handle(Socket client) throws IOException {


        new Thread(() -> {

            System.out.println("Connected to " + client);

            try (
                    client;
                 /* Checked exceptions are problematic with lambdas so wrap these with UncheckedIOException */
                 InputStream in = client.getInputStream();
                 OutputStream out = client.getOutputStream();
            ) {

                int data;

                while ((data = in.read()) != -1) {

                    out.write(xorAlphas(data));  // Write transmogrified data
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } finally {
                System.out.println(client + " disconnected.");
            }
        }).start();


    }

    static int i = 1;

    private static int xorAlphas(int data) {

        System.out.println(i + " clients connected.");

        return Character.isLetter(data) ? data ^ ' ' : data;
        // If its a letter, return data XOR ' ', if not letter, return data

    }
}

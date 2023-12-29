// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, Exception{
        ServerSocket serverSocket = new ServerSocket(4900);
        System.out.println("The server is ready for connections.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            Thread clientListener = new Thread(new ClientListener(dis));
            clientListener.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Me: ");
                String message = br.readLine();
                String encryptedMessage = CryptoUtil.encrypt(message);
                dos.writeUTF(encryptedMessage);
            }
        }
    }

    private static class ClientListener implements Runnable {

        public ClientListener(DataInputStream dis) {
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
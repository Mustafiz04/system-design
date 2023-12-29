import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author fgc
 */
public class MyClient {
    public static void main(String[] args) throws IOException, Exception {
        Socket socket = new Socket("localhost", 4900);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Thread serverListener = new Thread(new ServerListener(dis));
        serverListener.start();

        while (true) {
            System.out.print("Me  : ");
            String message = br.readLine();
            String encryptedMessage = CryptoUtil.encrypt(message);
            dos.writeUTF(encryptedMessage);
        }
    }

    private static class ServerListener implements Runnable {

        public ServerListener(DataInputStream dis) {
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
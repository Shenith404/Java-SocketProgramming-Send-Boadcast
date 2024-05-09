import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client {
    private static final int BROADCAST_PORT = 8888;

    public static void main(String[] args) {
        // Start a thread to listen for servers
        System.out.println("Starting");
        new Thread(Client::listenForServers).start();

        // Implement your client application logic here
        // For example, display discovered servers to the user and allow them to connect
    }

    private static void listenForServers() {
        try {
            DatagramSocket socket = new DatagramSocket(BROADCAST_PORT);
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received broadcast: " + message);
                // Parse the server information from the broadcast message and display it to the
                // user
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

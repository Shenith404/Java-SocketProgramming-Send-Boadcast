import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class Server {
    private static final int SERVER_PORT = 1234;
    private static final int BROADCAST_PORT = 8888;

    public static void main(String[] args) {
        new Thread(Server::broadcastServerPresence).start();
        // Start the server
        startServer();

        // Start a thread to broadcast server presence

    }

    private static void startServer() {
        try {
            // Implement your server logic here
            // For example, create a ServerSocket and accept incoming connections
            // You can use the SERVER_PORT constant to specify the port
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            // Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Handle client connection (e.g., create a new thread to handle the client)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcastServerPresence() {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);

            // Get LAN IP address
            String lanIpAddress = getLocalIpAddress();

            while (true) {
                String message = "Server: " + lanIpAddress + ":" + SERVER_PORT;
                DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),
                        InetAddress.getByName("255.255.255.255"), BROADCAST_PORT);
                socket.send(packet);

                Thread.sleep(1000); // Broadcast every second
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress() && address instanceof Inet4Address) {
                        return address.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
}

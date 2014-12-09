//package chat;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{
    DatagramSocket socket = null;

    public static void main(String[] args) throws IOException {
        
        try {
            DatagramSocket socket;
            
            socket = new DatagramSocket(2000);
            byte[] incomingData = new byte[1024];
            while (true) {
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                socket.receive(incomingPacket);
                String message = new String(incomingPacket.getData());
                System.out.println("Received message from client: " + message);
                InetAddress IPAddress = incomingPacket.getAddress();
                int port = incomingPacket.getPort();
                String reply = "Thank you for the message";
                byte[] data = reply.getBytes();
                DatagramPacket replyPacket =
                        new DatagramPacket(data, data.length, IPAddress, port);
                socket.send(replyPacket);
                Thread.sleep(2000);
            }
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur
 */
public class Chat {
    
    public static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket();
            
            InetAddress IPAddress = InetAddress.getByName("localhost");
            
            byte[] incomingData = new byte[1024];
            
            String sentence = "This is a message from client";
            
            byte[] data = sentence.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 2000);
            
            socket.send(sendPacket);
            
            System.out.println("Message sent from client");
            
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);

            socket.receive(incomingPacket);
	
            String response = new String(incomingPacket.getData());
	
            System.out.println("Response from server:" + response);
        } catch (SocketException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
		
    }
}

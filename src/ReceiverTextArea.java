/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */

import java.net.*;
import java.lang.*;
import javax.swing.*;

public class ReceiverTextArea extends JTextArea implements Runnable {
    
    public void run()
    {
        DatagramSocket socket;
        try{
            socket = new DatagramSocket(2000);
            byte[] incomingData = new byte[1024];
            while (true) {
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                socket.receive(incomingPacket);
                String message = new String(incomingPacket.getData());
                this.setText(this.getText() + "\nHim: " + message);
            }
        }
        catch(Exception ex)
        {
            this.setText(this.getText() + "\nERROR Receiving Message");
        }
    }
    
}

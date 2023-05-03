/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.client;

import model.Property;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author giang
 */
public class Client {

    public static void main(String[] args) throws Exception {
        DatagramSocket udpSocket = new DatagramSocket(); // Create a UDP socket
        InetAddress serverAddress = InetAddress.getByName("localhost"); // Get the server's address
        int serverPort = 5000; // Specify the server's port
        String post = "POST";
        String provery = "Property";        
        DatagramPacket packet = new DatagramPacket(post.getBytes(), post.getBytes().length, serverAddress, serverPort);
        udpSocket.send(packet); // Send the packet to the server
        packet = new DatagramPacket(provery.getBytes(), provery.getBytes().length, serverAddress, serverPort);
        udpSocket.send(packet);
        udpSocket.close(); // Close the socket
    }
    private static byte[] serialize(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }
}

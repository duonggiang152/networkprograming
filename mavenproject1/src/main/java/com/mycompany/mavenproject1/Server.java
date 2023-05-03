/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Property;
import model.Room;

/**
 *
 * @author giang
 */
public class Server {

    public static void main(String[] args) throws Exception {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
        DatagramSocket udpSocket = new DatagramSocket(5000); // Create a UDP socket on port 5000

        byte[] buffer = new byte[1024]; // Create a buffer for receiving data

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            udpSocket.receive(packet); // Receive data from a client
            String receivedString = converString(packet);
            if (receivedString.compareTo("POST") == 0) {
                udpSocket.receive(packet);
                String repo = converString(packet);
                if (repo.compareTo("Property") == 0) {
                    System.out.println("ok");
                }
                if (repo.compareTo("Room") == 0) {
                    udpSocket.receive(packet);
                    Room room = convertRoom(packet);
                    if (room.getId() == null) {
                        System.out.println("roomID: " + String.valueOf(room.getId()));
                        System.out.println("name: " + String.valueOf(room.getName()));
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                        EntityManager em = emf.createEntityManager();
                        em.getTransaction().begin();
                        em.persist(room);

                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                    }
                    if (room.getId() != null) {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                        EntityManager em = emf.createEntityManager();

                        Room roomP = em.find(Room.class, room.getId());
                        roomP.setName(room.getName());
                        roomP.setDescripe(room.getDescripe());
                        roomP.setIsDelete(room.getIsDelete());
                        em.getTransaction().begin();
                        em.merge(room);
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                    }
                }
            }
            if (receivedString.compareTo("GET") == 0) {
                udpSocket.receive(packet);
                String repo = converString(packet);
                if (repo.compareTo("Property") == 0) {

                }
                if (repo.compareTo("Room") == 0) {
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                    EntityManager em = emf.createEntityManager();
                    List<Room> rooms = em.createQuery("SELECT r FROM Room r Where isDelete = false", Room.class)
                            .getResultList();
                    em.close();
                    emf.close();

                    ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
                    objectOutStream.writeObject(rooms);
                    byte[] objectBytes = byteOutStream.toByteArray();
                    DatagramPacket responsePacket = new DatagramPacket(objectBytes, objectBytes.length, packet.getAddress(), packet.getPort());
                    udpSocket.send(responsePacket);
                }
            }
        }
    }

    private static Object deserialize(byte[] bytes) throws Exception {
        return new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
    }

    private static Property convertProperty(DatagramPacket packet) throws Exception {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        Property property = (Property) objectStream.readObject();
        packet.setData(new byte[1024]);
        return property;
    }

    private static Room convertRoom(DatagramPacket packet) throws Exception {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        Room property = (Room) objectStream.readObject();
        packet.setData(new byte[1024]);
        return property;
    }

    private static String converString(DatagramPacket packet) throws Exception {
        String receivedString = new String(packet.getData(), 0, packet.getLength());
        packet.setData(new byte[1024]);
        return receivedString;
    }
}

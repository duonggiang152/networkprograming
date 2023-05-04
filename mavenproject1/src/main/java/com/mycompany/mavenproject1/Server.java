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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Property;
import model.Room;
import model.Search;

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
                    udpSocket.receive(packet);
                    Property property = convertProperty(packet);
                    if (property.getId() == null) {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                        EntityManager em = emf.createEntityManager();
                        em.getTransaction().begin();
                        em.persist(property);

                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                    }
                    if (property.getId() != null) {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                        EntityManager em = emf.createEntityManager();

                        Property property1P = em.find(Property.class, property.getId());
                        property1P.setName(property.getName());
                        property1P.setType(property.getType());
                        property1P.setRoomId(property.getRoomId());
                        property1P.setPrice(property.getPrice());
                        property1P.setIsDelete(property.getIsDelete());
                        em.getTransaction().begin();
                        em.merge(property1P);
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                    }

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
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
                    EntityManager em = emf.createEntityManager();
                    List<Property> properties = em.createQuery("SELECT r FROM Property r Where isDelete = false", Property.class)
                            .getResultList();
                    em.close();
                    emf.close();

                    ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
                    objectOutStream.writeObject(properties);
                    byte[] objectBytes = byteOutStream.toByteArray();
                    DatagramPacket responsePacket = new DatagramPacket(objectBytes, objectBytes.length, packet.getAddress(), packet.getPort());
                    udpSocket.send(responsePacket);
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
                if (repo.compareTo("Search") == 0) {

                    udpSocket.receive(packet);
                    Search search = convertSearch(packet);
                    List<Property> properties = searchProperties(search);
                    for(int i = 0; i < properties.size(); i++) {
                        System.out.println(properties.get(i).getName());
                    }
                    ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
                    objectOutStream.writeObject(properties);
                    byte[] objectBytes = byteOutStream.toByteArray();
                    DatagramPacket responsePacket = new DatagramPacket(objectBytes, objectBytes.length, packet.getAddress(), packet.getPort());
                    udpSocket.send(responsePacket);
                }
            }
        }
    }

    public static List<Property> searchProperties(Search search) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();

    String query = "SELECT p FROM Property p WHERE 1=1";
    if (search.getRoomId() != null) {
        query += " AND p.roomId = :roomId";
    }
    if (search.getPriceGte() != null) {
        query += " AND p.price >= :priceGte";
    }
    if (search.getPriceLte() != null) {
        query += " AND p.price <= :priceLte";
    }

        TypedQuery<Property> typedQuery = em.createQuery(query, Property.class);

    if (search.getRoomId() != null) {
        typedQuery.setParameter("roomId", search.getRoomId());
    }
    if (search.getPriceGte() != null) {
        typedQuery.setParameter("priceGte", search.getPriceGte());
    }
    if (search.getPriceLte() != null) {
        typedQuery.setParameter("priceLte", search.getPriceLte());
    }

    List<Property> results = typedQuery.getResultList();

    em.close();
    emf.close();

    return results;
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

    private static Search convertSearch(DatagramPacket packet) throws Exception {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        Search search = (Search) objectStream.readObject();
        packet.setData(new byte[1024]);
        return search;
    }

    private static String converString(DatagramPacket packet) throws Exception {
        String receivedString = new String(packet.getData(), 0, packet.getLength());
        packet.setData(new byte[1024]);
        return receivedString;
    }
}

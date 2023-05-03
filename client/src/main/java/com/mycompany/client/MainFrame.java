/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Room;

/**
 *
 * @author giang
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        modelRoomTable = (DefaultTableModel) tableRoom.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabphong = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roomID = new javax.swing.JTextField();
        roomName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        addRoom = new javax.swing.JButton();
        updateRoom = new javax.swing.JButton();
        deleteRoom = new javax.swing.JButton();
        updatatable = new javax.swing.JButton();
        tabtaisan = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Phòng", "Tên phòng", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRoom);

        jLabel1.setText("Mã Phòng");

        jLabel2.setText("Tên phòng ");

        jLabel3.setText("Mô tả");

        roomID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                roomIDInputMethodTextChanged(evt);
            }
        });
        roomID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomIDActionPerformed(evt);
            }
        });
        roomID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roomIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                roomIDKeyTyped(evt);
            }
        });

        roomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNameActionPerformed(evt);
            }
        });

        descriptionText.setColumns(20);
        descriptionText.setRows(5);
        jScrollPane2.setViewportView(descriptionText);

        addRoom.setText("thêm");
        addRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoomMouseClicked(evt);
            }
        });
        addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomActionPerformed(evt);
            }
        });

        updateRoom.setText("sửa");
        updateRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateRoomMouseClicked(evt);
            }
        });

        deleteRoom.setText("xóa");
        deleteRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteRoomMouseClicked(evt);
            }
        });

        updatatable.setText("Cập nhật");
        updatatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatatableMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tabphongLayout = new javax.swing.GroupLayout(tabphong);
        tabphong.setLayout(tabphongLayout);
        tabphongLayout.setHorizontalGroup(
            tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabphongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabphongLayout.createSequentialGroup()
                        .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(roomID)
                                .addComponent(roomName, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabphongLayout.createSequentialGroup()
                        .addComponent(addRoom)
                        .addGap(18, 18, 18)
                        .addComponent(updateRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(updatatable)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabphongLayout.setVerticalGroup(
            tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabphongLayout.createSequentialGroup()
                .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabphongLayout.createSequentialGroup()
                        .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(roomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(259, 259, 259)
                        .addGroup(tabphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addRoom)
                            .addComponent(updateRoom)
                            .addComponent(deleteRoom)
                            .addComponent(updatatable)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phòng", tabphong);

        javax.swing.GroupLayout tabtaisanLayout = new javax.swing.GroupLayout(tabtaisan);
        tabtaisan.setLayout(tabtaisanLayout);
        tabtaisanLayout.setHorizontalGroup(
            tabtaisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        tabtaisanLayout.setVerticalGroup(
            tabtaisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tài sản", tabtaisan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tìm kiếm", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameActionPerformed

    private void addRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addRoomActionPerformed

    private void roomIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_roomIDInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_roomIDInputMethodTextChanged

    private void roomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomIDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_roomIDActionPerformed

    private void roomIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomIDKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_roomIDKeyPressed

    private void roomIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomIDKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_roomIDKeyTyped

    private void roomIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomIDKeyReleased
        // TODO add your handling code here:
        String roomId = roomID.getText().toString();
        if (roomId != null && roomId.isBlank() == false && roomId.isEmpty() == false) {
            addRoom.setEnabled(false);
            updateRoom.setEnabled(true);
            deleteRoom.setEnabled(true);
        } else {
            addRoom.setEnabled(true);
            updateRoom.setEnabled(false);
            deleteRoom.setEnabled(false);
        }
    }//GEN-LAST:event_roomIDKeyReleased

    private void addRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoomMouseClicked
        // TODO add your handling code here:
        String name = roomName.getText().toString();
        String description = descriptionText.getText();
        Room room = new Room(null, name, description);
        try {
            DatagramSocket udpSocket = new DatagramSocket(); // Create a UDP socket
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Get the server's address
            int serverPort = 5000; // Specify the server's port
            String post = "POST";
            String provery = "Room";
            DatagramPacket packet = new DatagramPacket(post.getBytes(), post.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            packet = new DatagramPacket(provery.getBytes(), provery.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet);
            byte[] roomByte = serialize(room);
            packet = new DatagramPacket(roomByte, roomByte.length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            udpSocket.close();
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }//GEN-LAST:event_addRoomMouseClicked

    private void updatatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatatableMouseClicked
        // TODO add your handling code here:
        String name = roomName.getText().toString();
        String description = descriptionText.getText();
        try {
            DatagramSocket udpSocket = new DatagramSocket(); // Create a UDP socket
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Get the server's address
            int serverPort = 5000; // Specify the server's port
            String get = "GET";
            String relation = "Room";
            DatagramPacket packet = new DatagramPacket(get.getBytes(), get.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            packet = new DatagramPacket(relation.getBytes(), relation.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet);

    
            byte[] buffer = new byte[1024 * 100];
            DatagramPacket packetReceice = new DatagramPacket(buffer, buffer.length);
            udpSocket.receive(packetReceice);
      
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = new ObjectInputStream(bais);
            List<Room> rooms = (List<Room>) ois.readObject();
            modelRoomTable.setRowCount(0);
            for (Room roomT : rooms) {
                modelRoomTable.addRow(new Object[] {
                    roomT.getId(), roomT.getName(), roomT.getDescripe()
                });
//                System.out.println(roomT.getId());
            }
            
            udpSocket.close();
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }//GEN-LAST:event_updatatableMouseClicked

    private void updateRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateRoomMouseClicked
        // TODO add your handling code here:
        Integer id = Integer.parseInt(roomID.getText().toString());
        String name = roomName.getText().toString();
        String description = descriptionText.getText();
        Room room = new Room(id, name, description);
        try {
            DatagramSocket udpSocket = new DatagramSocket(); // Create a UDP socket
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Get the server's address
            int serverPort = 5000; // Specify the server's port
            String post = "POST";
            String provery = "Room";
            DatagramPacket packet = new DatagramPacket(post.getBytes(), post.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            packet = new DatagramPacket(provery.getBytes(), provery.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet);
            byte[] roomByte = serialize(room);
            packet = new DatagramPacket(roomByte, roomByte.length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            udpSocket.close();
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }//GEN-LAST:event_updateRoomMouseClicked

    private void deleteRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRoomMouseClicked
        // TODO add your handling code here:
        Integer id = Integer.parseInt(roomID.getText().toString());
        String name = roomName.getText().toString();
        String description = descriptionText.getText();
        Room room = new Room(id, name, description, true);
        try {
            DatagramSocket udpSocket = new DatagramSocket(); // Create a UDP socket
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Get the server's address
            int serverPort = 5000; // Specify the server's port
            String post = "POST";
            String provery = "Room";
            DatagramPacket packet = new DatagramPacket(post.getBytes(), post.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            packet = new DatagramPacket(provery.getBytes(), provery.getBytes().length, serverAddress, serverPort);
            udpSocket.send(packet);
            byte[] roomByte = serialize(room);
            packet = new DatagramPacket(roomByte, roomByte.length, serverAddress, serverPort);
            udpSocket.send(packet); // Send the packet to the server
            udpSocket.close();
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }//GEN-LAST:event_deleteRoomMouseClicked
    private static byte[] serialize(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    private List<Room> roomsG;
    private DefaultTableModel modelRoomTable;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRoom;
    private javax.swing.JButton deleteRoom;
    private javax.swing.JTextArea descriptionText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField roomID;
    private javax.swing.JTextField roomName;
    private javax.swing.JTable tableRoom;
    private javax.swing.JPanel tabphong;
    private javax.swing.JPanel tabtaisan;
    private javax.swing.JButton updatatable;
    private javax.swing.JButton updateRoom;
    // End of variables declaration//GEN-END:variables
}
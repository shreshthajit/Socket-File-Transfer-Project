 
package chat;

import static chat.chat_client.dout;
import static chat.chat_client.msg;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

 
public class chat_server extends javax.swing.JFrame {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dout;
    static String[] filesList;

    public chat_server() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setBackground(new java.awt.Color(51, 255, 51));
        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Server");

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(refresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        msg_area.setText("");
    }//GEN-LAST:event_refreshActionPerformed

    public static void main(String args[]) {

        try {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new chat_server().setVisible(true);
                }
            });
            ss = new ServerSocket(3333);
            s = ss.accept();
            dis = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (true) {
                String fileName = dis.readUTF();
                if (fileName.equals("files-on-server")) {
                    File fileDir = new File("/home/shreshthajit/Downloads/Compressed/File-Transfer-System-main/src/ReceiveFile/");
                    File[] listOfFiles = fileDir.listFiles();
                    dout.writeUTF(String.valueOf(listOfFiles.length));
                    FileInputStream fin;
                    for (int i = 0; i < listOfFiles.length; i++) {
                        fin = new FileInputStream(listOfFiles[i]);
                        String singleFileName = listOfFiles[i].getName();
                        //System.out.println("Servers File Name : "+singleFileName);
                        byte[] fileNameBytes = singleFileName.getBytes();
                        byte[] fileBytes = new byte[(int) listOfFiles[i].length()];
                        fin.read(fileBytes);
                        dout.writeInt(fileNameBytes.length);
                        dout.write(fileNameBytes);
                        dout.writeInt(fileBytes.length);
                        dout.write(fileBytes);
                        fin.close();
                    }
                } else if (fileName.equals("remove")) {
                    String fileNameToDelete = dis.readUTF();
                    System.out.println("Remove File : " + fileNameToDelete);
                    File removeFile = new File("/home/shreshthajit/Downloads/Compressed/File-Transfer-System-main/src/ReceiveFile/" + fileNameToDelete);
                    if (removeFile.delete()) {
                        msg_area.append(fileNameToDelete + " File successfully Deleted\n");
                        dout.writeUTF("file-deleted");
                    } else {
                        msg_area.append("Something went wrong\n");
                    }
                } else {
                    File f = new File("/home/shreshthajit/Downloads/Compressed/File-Transfer-System-main/src/ReceiveFile/" + fileName);
                    FileOutputStream fout = new FileOutputStream(f);
                    if (!fileName.isEmpty()) {
                        int ch;
                        String temp;
                        do {
                            temp = dis.readUTF();
                            ch = Integer.parseInt(temp);
                            if (ch != -1) {
                                fout.write(ch);
                            }
                        } while (ch != -1);
                        fout.close();
                        if (ch == -1) {
                            msg_area.append(fileName + " New File Successfully Received\n");
                            }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(chat_server.class.getName()).log(Level.SEVERE, null, ex);
            msg_area.append("Something went wrong\n");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}

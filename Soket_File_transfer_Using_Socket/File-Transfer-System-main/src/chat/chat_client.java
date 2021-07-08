 
package chat;

import static chat.chat_server.dout;
import static chat.chat_server.ss;
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
import javax.swing.JFileChooser;
import chat.MyFile;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

 
public class chat_client extends javax.swing.JFrame {

    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dout;
    static int port;
    static String msg = "";
    final File[] fileToSend = new File[1];
    FileInputStream fin;
    static ArrayList<MyFile> myFiles = new ArrayList<>();
    static boolean connected = false;

    
    public chat_client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        ip_address = new javax.swing.JTextField();
        connect = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        filechooser = new javax.swing.JButton();
        uploadFile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        portNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setBackground(new java.awt.Color(51, 255, 0));
        msg_area.setColumns(20);
        msg_area.setRows(5);
        msg_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(msg_area);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("       IP :");

        ip_address.setBackground(new java.awt.Color(0, 255, 51));
        ip_address.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ip_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        connect.setBackground(new java.awt.Color(51, 255, 255));
        connect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connect.setText("Connect");
        connect.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 153, 153)));
        connect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 153));
        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Server's File");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        filechooser.setBackground(new java.awt.Color(0, 153, 153));
        filechooser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filechooser.setForeground(new java.awt.Color(255, 255, 255));
        filechooser.setText("Choose File to upload");
        filechooser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        filechooser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filechooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filechooserActionPerformed(evt);
            }
        });

        uploadFile.setBackground(new java.awt.Color(0, 153, 153));
        uploadFile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uploadFile.setForeground(new java.awt.Color(255, 255, 255));
        uploadFile.setText("Upload File in the Server");
        uploadFile.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        uploadFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFileActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("  PORT :");

        portNumber.setBackground(new java.awt.Color(0, 255, 51));
        portNumber.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        portNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ip_address, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(portNumber))
                                .addGap(18, 18, 18)
                                .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uploadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ip_address)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filechooser, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(uploadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        try {
            // TODO add your handling code here:
            String IP = ip_address.getText().trim();
            String StringPort = portNumber.getText().trim();
            if (!IP.isEmpty() && !StringPort.isEmpty()) {
                int PORT = Integer.parseInt(StringPort);
                s = new Socket(IP, PORT);
                dis = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                connected = true;
                connect.hide();
                ip_address.setText("");
                portNumber.setText("");
                msg_area.setText("\nConnected!");
                ip_address.setEnabled(false);
                portNumber.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Please Provide IP Address and Port number ", "Alert", JOptionPane.WARNING_MESSAGE);
                connected = false;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IP AddressOr Port Is Invalid !", "Alert", JOptionPane.WARNING_MESSAGE);
            connected = false;
            Logger.getLogger(chat_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (connected) {
            ServersAllFile();
            new ServersFile(myFiles, dout, dis).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please established your socket connection !", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void filechooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filechooserActionPerformed
        if (connected) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Choose a file to send.");
            if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileToSend[0] = jFileChooser.getSelectedFile();
                msg_area.append("The file you want to send is: " + fileToSend[0].getName());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please established your socket connection !", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_filechooserActionPerformed

    private void uploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFileActionPerformed

        if (connected) {
            if (fileToSend[0] == null) {
                msg_area.append("\nPlease choose a file to send first!");
                JOptionPane.showMessageDialog(null, "Please choose a file to send first!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    fin = new FileInputStream(fileToSend[0]);
                    String fileName = fileToSend[0].getName();
                    dout.writeUTF(fileName);
                    int ch;
                    do {
                        ch = fin.read();
                        dout.writeUTF(String.valueOf(ch));
                    } while (ch != -1);
                    fin.close();
                    if (ch == -1) {
                        msg_area.append("\nFile Successfully Uploaded");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please established your socket connection !", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_uploadFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_client().setVisible(true);
            }
        });
    }

    public static String getFileExtension(String fileName) {
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            return fileName.substring(i + 1);
        } else {
            return "No extension found.";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect;
    private javax.swing.JButton filechooser;
    private javax.swing.JTextField ip_address;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JTextField portNumber;
    private javax.swing.JButton uploadFile;
    // End of variables declaration//GEN-END:variables

    private void ServersAllFile() {
        try {
            dout.writeUTF("files-on-server");
            myFiles.clear();
            String templistofFiles = dis.readUTF();
            int listofFiles = Integer.parseInt(templistofFiles);
            for (int i = 0; i < listofFiles; i++) {
                int fileNameLength = dis.readInt();
                if (fileNameLength > 0) {
                    byte[] fileNameBytes = new byte[fileNameLength];
                    dis.readFully(fileNameBytes, 0, fileNameBytes.length);
                    String fileName = new String(fileNameBytes);
                    int fileContentLength = dis.readInt();
                    byte[] fileContentBytes = null;
                    if (fileContentLength > 0) {
                        fileContentBytes = new byte[fileContentLength];
                        dis.readFully(fileContentBytes, 0, fileContentBytes.length);
                    }
                    MyFile myfile = new MyFile(i, fileName, fileContentBytes, getFileExtension(fileName));
                    myFiles.add(myfile);
                    //System.out.println(myfile.getId() + " " + myfile.getName() + " " + myfile.getData() + " " + myfile.getFileExtension());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(chat_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

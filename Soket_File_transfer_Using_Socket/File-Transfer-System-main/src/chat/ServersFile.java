/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import chat.MyFile;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ismail
 */
public class ServersFile extends javax.swing.JFrame {

    /**
     * Creates new form ServersFile
     */
    ArrayList<MyFile> myfiles;
    int id = -1;
    static DataOutputStream dout;
    static DefaultTableModel model;
    static DataInputStream dis;
    static int totalfile_row;
    int count = 0;

    private ServersFile() {
        initComponents();
    }

    public ServersFile(ArrayList<MyFile> myfiles, DataOutputStream dout, DataInputStream dis) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        totalfile_row = myfiles.size();
        System.out.println(myfiles.size());
        count = 1;
        this.myfiles = myfiles;
        this.dout = dout;
        this.dis = dis;
        model = (DefaultTableModel) table.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, centerRenderer);
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        if (count > 1) {
               model.insertRow(5, new Object[]{myfiles.get(5).getId(), myfiles.get(5).getName()});
        }
        for (MyFile myfile : myfiles) {
            count++;
            model.addRow(new Object[]{myfile.getId(), myfile.getName()});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        download = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setAutoCreateRowSorter(true);
        table.setBackground(new java.awt.Color(102, 255, 255));
        table.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                File Id", "                File Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
        }

        download.setBackground(new java.awt.Color(51, 255, 255));
        download.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        download.setText("Download");
        download.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(51, 255, 255));
        remove.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        remove.setText("Remove");
        remove.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        id = table.getSelectedRow();
        System.out.println(table.getSelectedRow() + " " + table.getSelectedColumn());
    }//GEN-LAST:event_tableMouseClicked

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        // TODO add your handling code here:
        if (table.getRowCount() != 0) {
            if (id != -1) {
                for (MyFile myFile : myfiles) {
                    if (myFile.getName() == model.getValueAt(id, 1)) {
                        JFrame jfPreview = createFrame(myFile.getName(), myFile.getData(), myFile.getFileExtension());
                        jfPreview.setVisible(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a file first", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Table is empty !", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_downloadActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        if (table.getRowCount() != 0) {
            if (id != -1) {
                for (MyFile myFile : myfiles) {
                    if (myFile.getName() == model.getValueAt(table.getSelectedRow(), 1)) {
                        JFrame jfRemove = createFrameToRemove(myFile.getName(), myFile.getData(), myFile.getFileExtension());
                        jfRemove.setVisible(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a file first", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Table is empty !", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServersFile().setVisible(true);
            }
        });
    }

    public static JFrame createFrame(final String fileName, final byte[] fileData, String fileExtension) {

        final JFrame jFrame = new JFrame("File Downloader");
        jFrame.setSize(500, 400);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JLabel jlTitle = new JLabel("Download File : " + fileName);
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlTitle.setFont(new Font("Courgette", Font.BOLD, 25));
        jlTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
        JLabel jlPrompt = new JLabel("Are you sure you want to download " + fileName + "?");
        jlPrompt.setFont(new Font("Courgette", Font.BOLD, 20));
        jlPrompt.setBorder(new EmptyBorder(20, 0, 10, 0));
        jlPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton jbYes = new JButton("Yes");
        jbYes.setPreferredSize(new Dimension(100, 50));
        jbYes.setFont(new Font("Courgette", Font.BOLD, 20));
        JButton jbNo = new JButton("No");
        jbNo.setPreferredSize(new Dimension(100, 50));
        jbNo.setFont(new Font("Courgette", Font.BOLD, 20));
        JLabel jlFileContent = new JLabel();
        jlFileContent.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel jpButtons = new JPanel();
        jpButtons.setBorder(new EmptyBorder(20, 0, 10, 0));
        jpButtons.add(jbYes);
        jpButtons.add(jbNo);
        if (fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg")
                || fileExtension.equalsIgnoreCase("gif") || fileExtension.equalsIgnoreCase("tiff")) {
            jlFileContent.setIcon(new ImageIcon(fileData));
        }

        jbYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("choosertitle");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                File fileToDownload = null;
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(chooser.getSelectedFile());
                    fileToDownload = new File(chooser.getSelectedFile() + "/" + fileName);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(fileToDownload);
                        fileOutputStream.write(fileData);
                        fileOutputStream.close();
                        jFrame.dispose();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("No Selection ");
                }

            }
        });
        jbNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        jPanel.add(jlTitle);
        jPanel.add(jlPrompt);
        jPanel.add(jlFileContent);
        jPanel.add(jpButtons);
        jFrame.add(jPanel);
        return jFrame;

    }

    public static JFrame createFrameToRemove(final String fileName, final byte[] fileData, String fileExtension) {

        final JFrame jFrame = new JFrame("File Remover");
        jFrame.setSize(500, 400);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JLabel jlTitle = new JLabel("Remove File : " + fileName);
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlTitle.setFont(new Font("Courgette", Font.BOLD, 25));
        jlTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
        JLabel jlPrompt = new JLabel("Are you sure you want to remove " + fileName + "?");
        jlPrompt.setFont(new Font("Courgette", Font.BOLD, 20));
        jlPrompt.setBorder(new EmptyBorder(20, 0, 10, 0));
        jlPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton jbYes = new JButton("Yes");
        jbYes.setPreferredSize(new Dimension(100, 50));
        jbYes.setFont(new Font("Courgette", Font.BOLD, 20));
        JButton jbNo = new JButton("No");
        jbNo.setPreferredSize(new Dimension(100, 50));
        jbNo.setFont(new Font("Courgette", Font.BOLD, 20));
        JLabel jlFileContent = new JLabel();
        jlFileContent.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel jpButtons = new JPanel();
        jpButtons.setBorder(new EmptyBorder(20, 0, 10, 0));
        jpButtons.add(jbYes);
        jpButtons.add(jbNo);
        if (fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg")
                || fileExtension.equalsIgnoreCase("gif") || fileExtension.equalsIgnoreCase("tiff")) {
            jlFileContent.setIcon(new ImageIcon(fileData));
        }

        jbYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dout.writeUTF("remove");
                    dout.writeUTF(fileName);
                    String back_message = dis.readUTF();
                    if (back_message.equals("file-deleted")) {
                        model.removeRow(table.getSelectedRow());
                    }
                    jFrame.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(ServersFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jbNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        jPanel.add(jlTitle);
        jPanel.add(jlPrompt);
        jPanel.add(jlFileContent);
        jPanel.add(jpButtons);
        jFrame.add(jPanel);
        return jFrame;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton download;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

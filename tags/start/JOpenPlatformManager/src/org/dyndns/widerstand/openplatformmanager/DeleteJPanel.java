/*
 * DeleteJPanel.java
 *
 * Created on 21. Februar 2005, 09:26
 */

package org.dyndns.widerstand.openplatformmanager;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import org.dyndns.widerstand.OpenPlatform.*;
import java.util.*;

/**
 *
 * @author  Widerstand
 */
public class DeleteJPanel extends javax.swing.JPanel {
    
    private MainJFrame parent;
    private ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>(10);
    
    /** Creates new form DeleteJPanel */
    public DeleteJPanel(MainJFrame parent) {
        this.parent = parent;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        setBorder(new javax.swing.border.CompoundBorder(null, new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Delete Application"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5)))));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.GridLayout(0, 5));

        jPanel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Card Manager"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5))));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 36));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 36));
        jPanel7.add(jPanel2);

        jPanel1.setLayout(new java.awt.GridLayout(0, 5));

        jPanel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Executable Load Files"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5))));
        jPanel7.add(jPanel1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Applications"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5))));
        jPanel4.setLayout(new java.awt.GridLayout(0, 5));

        jPanel4.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Security Domains"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5))));
        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(0, 5));

        jPanel5.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Applications"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5))));
        jPanel3.add(jPanel5);

        jPanel7.add(jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(jPanel7, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel6.setAlignmentY(0.0F);
        jButton1.setText("Delete Application(s)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.add(jButton1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(jPanel6, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel8);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        byte[][] AIDs;
        int i=0;
        
        for (int j=0; j<checkBoxList.size(); j++) {
            if (((JCheckBox)checkBoxList.get(j)).isSelected()) i++;
        }
        AIDs = new byte[i][];
        i=0;
        byte[] AID;
        for (int j=0; j<checkBoxList.size(); j++) {
            JCheckBox checkBox = (JCheckBox)checkBoxList.get(j);
            if (checkBox.isSelected()) {
                AID = OPSPUtil.bytesFromHexString(checkBox.getText());
                AIDs[i++] = AID;
            }
        }
        int approve = javax.swing.JOptionPane.showConfirmDialog(this, "Do you really want delete the application(s)?",
                "Delete confirmation", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (approve != javax.swing.JOptionPane.YES_OPTION)
            return;
        
        try {
            Class parameterTypes[] = new Class[] {Long.TYPE, OPSPSecurityInfo.class,
                    OPSPCardConnectionInfo.class, byte[][].class};
                    Object parameters[] = new Object[] {parent.session.cardHandle,
                            parent.session.secInfo, parent.session.cardInfo,
                            AIDs};
                            
                            OPSPReceiptData receiptData[] = (OPSPReceiptData[])WaitForMethodJDialog.showDialog(parent,
                                    "org.dyndns.widerstand.OpenPlatform.OPSPWrapper", "deleteApplet", null, parameterTypes, parameters);
                            if (receiptData != null) {
                                for (int j=0; j < receiptData.length; j++) {
                                    final JFileChooser fc = new JFileChooser();
                                    int ret = fc.showSaveDialog(this);
                                    if (ret == JFileChooser.APPROVE_OPTION) {
                                        try {
                                            File file = fc.getSelectedFile();
                                            OPSPUtil.saveOPSPReceiptData(file, receiptData[j]);
                                        } catch (IOException e) {
                                            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(),
                                                    "I/O Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                            parent.refreshStatus();
                                            return;
                                        }
                                    }
                                }
                            }
                            
        } catch (Exception e) {
            for (int j=0; j<AIDs.length; j++) {
                byte[][] AIDsTemp = new byte[1][];
                AIDsTemp[0] = AIDs[j];
                try {
                    Class parameterTypes[] = new Class[] {Long.TYPE, OPSPSecurityInfo.class,
                            OPSPCardConnectionInfo.class, byte[][].class};
                            Object parameters[] = new Object[] {parent.session.cardHandle,
                                    parent.session.secInfo, parent.session.cardInfo,
                                    AIDsTemp};
                                    
                                    OPSPReceiptData receiptData[] = (OPSPReceiptData[])WaitForMethodJDialog.showDialog(parent,
                                            "org.dyndns.widerstand.OpenPlatform.OPSPWrapper", "deleteApplet", null, parameterTypes, parameters);
                                    if (receiptData != null) {
                                        for (int k=0; k < receiptData.length; k++) {
                                            final JFileChooser fc = new JFileChooser();
                                            int ret = fc.showSaveDialog(this);
                                            if (ret == JFileChooser.APPROVE_OPTION) {
                                                try {
                                                    File file = fc.getSelectedFile();
                                                    OPSPUtil.saveOPSPReceiptData(file, receiptData[k]);
                                                } catch (IOException ex) {
                                                    javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                                                            "I/O Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                                                    parent.refreshStatus();
                                                    return;
                                                }
                                            }
                                        }
                                    }
                } catch (OPSPException ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Open Platform Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    parent.refreshStatus();
                    return;
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Generel Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    parent.refreshStatus();
                    return;
                }
            }
        }
        parent.refreshStatus();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void refresh() {
        JCheckBox checkBox;
        jPanel2.removeAll();
        jPanel1.removeAll();
        jPanel4.removeAll();
        jPanel5.removeAll();
        checkBoxList.clear();
        for (OPSPApplicationData appData : parent.session.cardManager) {
            checkBox = new JCheckBox(OPSPUtil.toHexString(appData.getAID()));
            jPanel2.add(checkBox);
            checkBoxList.add(checkBox);
        }
        for (OPSPApplicationData appData : parent.session.loadFiles) {
            checkBox = new JCheckBox(OPSPUtil.toHexString(appData.getAID()));
            jPanel1.add(checkBox);
            checkBoxList.add(checkBox);
        }
        for (OPSPApplicationData appData : parent.session.securityDomains) {
            checkBox = new JCheckBox(OPSPUtil.toHexString(appData.getAID()));
            jPanel4.add(checkBox);
            checkBoxList.add(checkBox);
        }
        for (OPSPApplicationData appData : parent.session.applications) {
            checkBox = new JCheckBox(OPSPUtil.toHexString(appData.getAID()));
            jPanel5.add(checkBox);
            checkBoxList.add(checkBox);
        }
        jPanel8.revalidate();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}

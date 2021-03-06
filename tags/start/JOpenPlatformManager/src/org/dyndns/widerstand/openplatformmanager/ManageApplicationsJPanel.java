/*
 * ManageApplicationsJPanel.java
 *
 * Created on 23. Februar 2005, 09:04
 */

package org.dyndns.widerstand.openplatformmanager;

/**
 *
 * @author  Widerstand
 */
public class ManageApplicationsJPanel extends javax.swing.JPanel {
    
    private MainJFrame parent;
    
    /** Creates new form ManageApplicationsJPanel */
    public ManageApplicationsJPanel(MainJFrame parent) {
        this.parent = parent;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelStatus = new StatusJPanel(parent);
        jPanelDelete = new DeleteJPanel(parent);
        jPanelInstall = new InstallJPanel(parent);

        setLayout(new java.awt.BorderLayout());

        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder("Manage Applications"), new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5))));
        jTabbedPane1.addTab("Status", jPanelStatus);

        jTabbedPane1.addTab("Delete", jPanelDelete);

        jTabbedPane1.addTab("Install", jPanelInstall);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents
    
    public void refresh() {
       ((StatusJPanel)jPanelStatus).refresh();
       ((InstallJPanel)jPanelInstall).refresh();
       ((DeleteJPanel)jPanelDelete).refresh();        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelDelete;
    private javax.swing.JPanel jPanelInstall;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    
}

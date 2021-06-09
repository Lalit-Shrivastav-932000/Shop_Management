package com.employee;

import com.Postgre;
import java.sql.Connection;
import javax.swing.JFrame;

public class EmpFrame extends javax.swing.JFrame {

    /**
     * Creates new form EmpFrame
     */
    String username;
    Connection conn;

    public EmpFrame(Connection x, String username) {
        initComponents();
        this.username = username;
        this.conn = x;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmchangePassw = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        menuTask = new javax.swing.JMenu();
        menuItemSale = new javax.swing.JMenuItem();
        menuItemViewProducts = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dp.setInheritsPopupMenu(true);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        menuMenu.setText("MENU");
        menuMenu.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jMenuItem4.setText("VIEW PROFILE");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuMenu.add(jMenuItem4);

        jmchangePassw.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jmchangePassw.setText("CHANGE PASSWORD");
        jmchangePassw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmchangePasswActionPerformed(evt);
            }
        });
        menuMenu.add(jmchangePassw);

        logout.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        menuMenu.add(logout);

        exit.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        menuMenu.add(exit);

        jMenuBar1.add(menuMenu);

        menuTask.setText("TASK");
        menuTask.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        menuItemSale.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        menuItemSale.setText("SALES");
        menuItemSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaleActionPerformed(evt);
            }
        });
        menuTask.add(menuItemSale);

        menuItemViewProducts.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        menuItemViewProducts.setText("PRODUCTS");
        menuItemViewProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemViewProductsActionPerformed(evt);
            }
        });
        menuTask.add(menuItemViewProducts);

        jMenuBar1.add(menuTask);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dp)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void jmchangePasswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmchangePasswActionPerformed
        // TODO add your handling code here
        ChangeEmpPassw c = new ChangeEmpPassw(conn, username);
        c.setVisible(true);
        dp.add(c);

    }//GEN-LAST:event_jmchangePasswActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_logoutActionPerformed

    private void menuItemSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaleActionPerformed
        EmpSales r = new EmpSales(conn, username);
        dp.add(r);
        r.setSize(dp.getSize());
        r.setVisible(true);

    }//GEN-LAST:event_menuItemSaleActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        EmpProfile v = new EmpProfile(conn, username);
        v.setVisible(true);
        dp.add(v);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuItemViewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemViewProductsActionPerformed
        // TODO add your handling code here:
        OurProducts op = new OurProducts(conn);
        op.setVisible(true);
        op.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }//GEN-LAST:event_menuItemViewProductsActionPerformed

    public static void main(String[] args) {
        Connection c = new Postgre().connectDB();

        EmpFrame ef = new EmpFrame(c, "ls9");
        ef.setVisible(true);
        ef.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jmchangePassw;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenuItem menuItemSale;
    private javax.swing.JMenuItem menuItemViewProducts;
    private javax.swing.JMenu menuMenu;
    private javax.swing.JMenu menuTask;
    // End of variables declaration//GEN-END:variables
}

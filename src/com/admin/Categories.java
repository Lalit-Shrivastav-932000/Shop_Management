package com.admin;

import com.Postgre;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Categories extends javax.swing.JInternalFrame {

    Connection x;
    String username;

    public Categories(Connection x, String uname) {
        initComponents();
        this.x = x;
        this.username = uname;
        showAll();
        setPosition();
    }

    private void setPosition() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screen = new Dimension(t.getScreenSize());
        Dimension currentWindow = this.getBounds().getSize();
        int y = ((screen.height - currentWindow.height) / 2) - 20;
        int x = (screen.width - currentWindow.width) / 2;
        this.setLocation(x, y);
    }

    void clear() {
        txtcid.setText("");
        txtcname.setText("");
        txtdesc.setText("");
        txttax.setText("");
    }

    void showAll() {
        Vector heading = new Vector();
        heading.add("CATEGORY ID");
        heading.add("CATEGORY NAME");
        heading.add("TAX (in %)");
        heading.add("DESCRIPTION");

        try {
            String q = "select * from categories ";
            PreparedStatement ps = x.prepareStatement(q);
            Vector data = new Vector();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("category_id"));
                row.add(rs.getString("category_name"));
                row.add(rs.getString("tax_charge"));
                row.add(rs.getString("description"));

                data.add(row);

            }

            DefaultTableModel tm = new DefaultTableModel(data, heading);
            jTable1.setModel(tm);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void Add() {
        String category_id = txtcid.getText().trim();
        String category_name = txtcname.getText().trim();
        String tax = txttax.getText().trim();
        String description = txtdesc.getText().trim();

        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            String sql = "Select * from categories where category_name= ?";
            ps=x.prepareStatement(sql);
            ps.setString(1, category_name);
            rs = ps.executeQuery();
            if(rs.next()){
                exist = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
        }finally{
            new Postgre().closeConn(null, ps, rs);
        }
        
        if(exist){
            JOptionPane.showMessageDialog(this, "Category Exist! So, you will not add this again.");
            return;
        }

        try {

            String q = "insert into categories(category_id, category_name, tax_charge, description) values(?,?,?,?)";
            ps = x.prepareStatement(q);
            ps.setString(1, category_id);
            ps.setString(2, category_name);
            ps.setString(3, tax);
            ps.setString(4, description);

            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + "data inserted !!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            new Postgre().closeConn(null, ps, rs);   
        }
    }

    void Modify() {
        try {
            String category_id = txtcid.getText();
            String category_name = txtcname.getText();
            String tax = txttax.getText();
            String description = txtdesc.getText();

            String q = "update categories set category_name=?, description=?, tax_charge=? where category_id=?";
            PreparedStatement ps = x.prepareStatement(q);

            ps.setString(1, category_name);
            ps.setString(2, description);
            ps.setString(3, tax);
            ps.setString(4, category_id);

            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + "data modified");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void Delete() {
        try {
            String category_id = txtcid.getText();

            int op = JOptionPane.showConfirmDialog(this, "With the deletion of category, products under that category also deleted. Are you sure to delete Category with Category ID ->  " + category_id + " ?  ", "Delete Record", JOptionPane.YES_NO_OPTION,
                  JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                String q = "delete from categories  where category_id=?";
                PreparedStatement ps = x.prepareStatement(q);

                ps.setString(1, category_id);
                int count = ps.executeUpdate();
                if (count > 0) {
                    JOptionPane.showMessageDialog(this, count + "Data deleted ");
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcid = new javax.swing.JTextField();
        txtcname = new javax.swing.JTextField();
        btnaddc = new javax.swing.JButton();
        btnmodifyc = new javax.swing.JButton();
        btndeletec = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txttax = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdesc = new javax.swing.JTextArea();
        btnclr = new javax.swing.JButton();

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");

        setClosable(true);
        setIconifiable(true);
        setTitle("Categories");
        setMaximumSize(getPreferredSize());
        setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CATEGORY ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 140, 160, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIPTION");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 160, 40));

        txtcid.setEditable(false);
        txtcid.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtcid.setText("Auto Generated");
        txtcid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtcid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcidActionPerformed(evt);
            }
        });
        jPanel1.add(txtcid, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 141, 260, 40));

        txtcname.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtcname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 211, 260, 50));

        btnaddc.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnaddc.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnaddc.setText("ADD");
        btnaddc.setPreferredSize(new java.awt.Dimension(150, 50));
        btnaddc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddcActionPerformed(evt);
            }
        });
        jPanel1.add(btnaddc, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 570, -1, -1));

        btnmodifyc.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnmodifyc.setText("MODIFY");
        btnmodifyc.setPreferredSize(new java.awt.Dimension(150, 50));
        btnmodifyc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifycActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodifyc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, -1));

        btndeletec.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btndeletec.setText("DELETE");
        btndeletec.setPreferredSize(new java.awt.Dimension(150, 50));
        btndeletec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletecActionPerformed(evt);
            }
        });
        jPanel1.add(btndeletec, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 570, -1, -1));

        btnback.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnback.setText("BACK");
        btnback.setPreferredSize(new java.awt.Dimension(150, 50));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 652, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Catagories");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, 70));

        txttax.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txttax.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txttax, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 291, 260, 50));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CATEGORY NAME");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, 180, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TAX (in %)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 295, 180, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 18, 736, 714));

        txtdesc.setColumns(20);
        txtdesc.setRows(5);
        txtdesc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(txtdesc);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 260, 151));

        btnclr.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnclr.setText("CLEAR");
        btnclr.setPreferredSize(new java.awt.Dimension(150, 50));
        btnclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclrActionPerformed(evt);
            }
        });
        jPanel1.add(btnclr, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 570, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndeletecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletecActionPerformed
        Delete();
        showAll();// TODO add your handling code here:
    }//GEN-LAST:event_btndeletecActionPerformed

    private void btnaddcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddcActionPerformed
        Add();
        clear();
        showAll();
    }//GEN-LAST:event_btnaddcActionPerformed

    private void btnmodifycActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifycActionPerformed
        Modify();
        clear();
        showAll();

    }//GEN-LAST:event_btnmodifycActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        TableModel tm = jTable1.getModel();
        txtcid.setText((String) tm.getValueAt(row, 0));
        txtcname.setText((String) tm.getValueAt(row, 1));
        txttax.setText((String) tm.getValueAt(row, 2));
        txtdesc.setText((String) tm.getValueAt(row, 3));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclrActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnclrActionPerformed

    private void txtcidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddc;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnclr;
    private javax.swing.JButton btndeletec;
    private javax.swing.JButton btnmodifyc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcid;
    private javax.swing.JTextField txtcname;
    private javax.swing.JTextArea txtdesc;
    private javax.swing.JTextField txttax;
    // End of variables declaration//GEN-END:variables
}

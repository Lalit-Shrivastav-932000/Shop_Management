package com.admin;


import com.MyData;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author a
 */
public class Products extends javax.swing.JInternalFrame {

    /**
     * Creates new form Products
     */
    Connection x;
    String username;

    public Products(Connection x, String uname) {
        initComponents();
        this.x = x;
        this.username = uname;
        fillCategories();
        showAll();
        setPosition();
    }

    private void setPosition(){        
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screen = new Dimension(t.getScreenSize());
        Dimension currentWindow = this.getBounds().getSize();
        int y = ((screen.height - currentWindow.height)/2)-20;
        int x = (screen.width - currentWindow.width)/2;
        this.setLocation(x, y);        
    }
    

    void clearData() {
        txtpid.setText("");
        txtpname.setText("");
        txtprice.setText("");
        txtstock.setText("");
        txtdescription.setText("");
        cbavail.setSelected(false);
        cmbcat.setSelectedItem(null);
    }

    
    void showAll() {
        Vector heading = new Vector();
        heading.add("Product id");
        heading.add("Product name");
        heading.add("Price");
        heading.add("Category");
        heading.add("Stock");
        heading.add("Description");
        heading.add("Available");

        try {
            String q = "select * from products";
            PreparedStatement ps = x.prepareStatement(q);
            Vector data = new Vector();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("product_id"));
                row.add(rs.getString("product_name"));
                row.add(rs.getString("price_per_unit"));
                row.add(rs.getString("category_id"));
                row.add(rs.getString("stock_units"));
                row.add(rs.getString("description"));
                row.add(rs.getBoolean("avail"));


                data.add(row);
            }

            DefaultTableModel tm = new DefaultTableModel(data, heading);
            jTable1.setModel(tm);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    
    void fillCategories() {

        try {
            cmbcat.removeAllItems();
            
            String q = "select * from categories order by category_name";
            PreparedStatement y = x.prepareStatement(q);
            ResultSet rs = y.executeQuery();

            while (rs.next()) {
                MyData g = new MyData();
                g.code = rs.getString("category_id");
                g.name = rs.getString("category_name");
                cmbcat.addItem(g);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
            ex.printStackTrace();
        }

    }
    

    void insert() {
        try {
            String Product_id = txtpid.getText();
            String Product_name = txtpname.getText();
            String Price = txtprice.getText();
            MyData m = (MyData) cmbcat.getSelectedItem();
            String category = m.code;
             String Stock = txtstock.getText();
            String Description = txtdescription.getText();
            Boolean avail = cbavail.isSelected();


            String q = "insert into products (product_id,product_name,category_id,price_per_unit,description,stock_units,avail) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = x.prepareStatement(q);
            ps.setObject(1, Product_id);
            ps.setString(2, Product_name);
            ps.setString(3, category);
            ps.setString(4, Price);
            ps.setString(5, Description);
            ps.setString(6, Stock);
            ps.setBoolean(7, avail);

            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + " item added !!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    void Update() {
        try {
            String Product_id = txtpid.getText();
            String Product_name = txtpname.getText();
            String Price = txtprice.getText();

            MyData m = (MyData) cmbcat.getSelectedItem();
            String category = m.code;

            String Stock = txtstock.getText();
            String Description = txtdescription.getText();

            String q = "update products set product_id=?, product_name=?, category_id=?, price_per_unit=?,  description=?, stock_units=? where product_id=?";
            PreparedStatement ps = x.prepareStatement(q);

            ps.setObject(1, Product_id);
            ps.setString(2, Product_name);
            ps.setString(3, category);
            ps.setString(4, Price);
            ps.setString(5, Description);
            ps.setString(6, Stock);
            ps.setString(7, initialProductID);

            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + " product data updated");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }

    
    void Delete() {
        try {
            String Product_id = initialProductID;

            String q = "delete from products where product_id=?";
            PreparedStatement ps = x.prepareStatement(q);
            ps.setString(1, Product_id);
            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + " product data deleted !!!");
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

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jtab = new javax.swing.JTabbedPane();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnpback = new javax.swing.JButton();
        btnpadd = new javax.swing.JButton();
        btnpupdate = new javax.swing.JButton();
        btnpdelete = new javax.swing.JButton();
        txtstock = new javax.swing.JTextField();
        txtpid = new javax.swing.JTextField();
        txtpname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        cmbcat = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbavail = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PRODUCTS");
        setToolTipText("");
        setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jtab.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
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
        jScrollPaneTable.setViewportView(jTable1);

        jtab.addTab("Table", jScrollPaneTable);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUCT ID");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCT NAME");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORY");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRICE/UNIT (in Rs.)");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("STOCK");

        btnpback.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpback.setText("BACK");
        btnpback.setPreferredSize(new java.awt.Dimension(150, 50));
        btnpback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpbackActionPerformed(evt);
            }
        });

        btnpadd.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpadd.setText("ADD");
        btnpadd.setPreferredSize(new java.awt.Dimension(150, 50));
        btnpadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaddActionPerformed(evt);
            }
        });

        btnpupdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpupdate.setText("UPDATE");
        btnpupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpupdateActionPerformed(evt);
            }
        });

        btnpdelete.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnpdelete.setText("DELETE");
        btnpdelete.setPreferredSize(new java.awt.Dimension(150, 50));
        btnpdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdeleteActionPerformed(evt);
            }
        });

        txtstock.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        txtpid.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtpid.setToolTipText("");

        txtpname.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        txtprice.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        txtdescription.setColumns(20);
        txtdescription.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtdescription.setRows(5);
        txtdescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtdescription);

        cmbcat.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PRODUCTS");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DESCRIPTION");

        cbavail.setBackground(new java.awt.Color(0, 0, 0));
        cbavail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cbavail.setForeground(new java.awt.Color(255, 255, 255));
        cbavail.setText("AVAILABLE");

        btnClear.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setPreferredSize(new java.awt.Dimension(150, 50));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbavail)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtpname)
                                .addComponent(txtprice)
                                .addComponent(cmbcat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnpadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnpback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnpupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnpdelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(433, 433, 433))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(227, Short.MAX_VALUE)
                        .addComponent(cbavail)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbcat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpdelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jtab.addTab("Details", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpbackActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnpbackActionPerformed

    private void btnpupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpupdateActionPerformed
        Update();
        showAll();// TODO add your handling code here:
    }//GEN-LAST:event_btnpupdateActionPerformed

    private void btnpdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdeleteActionPerformed
        Delete();
        showAll();// TODO add your handling code here:
    }//GEN-LAST:event_btnpdeleteActionPerformed

    private void btnpaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaddActionPerformed
        insert();
        showAll();// TODO add your handling code here:
    }//GEN-LAST:event_btnpaddActionPerformed

    
    String initialProductID;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
        TableModel tm = jTable1.getModel();
         initialProductID =  (String) tm.getValueAt(row, 0);
         
        txtpid.setText((String) tm.getValueAt(row, 0));
        txtpname.setText((String) tm.getValueAt(row, 1));
        txtprice.setText((String) tm.getValueAt(row, 2));
        String catid = (String) tm.getValueAt(row, 3);
        txtstock.setText((String) tm.getValueAt(row, 4));
        txtdescription.setText((String) tm.getValueAt(row, 5));
        cbavail.setSelected((Boolean) tm.getValueAt(row, 6));


        for (int i = 0; i < cmbcat.getItemCount(); i++) {
            MyData m = (MyData) cmbcat.getItemAt(i);
            if (m.code.equals(catid)) {
                cmbcat.setSelectedIndex(i);
                break;
            }
        }

        jtab.setSelectedIndex(1);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnpadd;
    private javax.swing.JButton btnpback;
    private javax.swing.JButton btnpdelete;
    private javax.swing.JButton btnpupdate;
    private javax.swing.JCheckBox cbavail;
    private javax.swing.JComboBox cmbcat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTabbedPane jtab;
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}

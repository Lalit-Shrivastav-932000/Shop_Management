package com.admin;

//This file is made by Lalit


import com.Postgre;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lalit
 */
public class AdminProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form AdminProfile
     */
    Connection conn;
    String username;

    public AdminProfile(Connection c, String uname) {
        this.conn = c;
        this.username = uname;
        initComponents();
        this.showData();
        this.setPosition();
    }
    
    
    private void setPosition(){        
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screen = new Dimension(t.getScreenSize());
        Dimension currentWindow = this.getBounds().getSize();
        int y = ((screen.height - currentWindow.height)/2)-20;
        int x = (screen.width - currentWindow.width)/2;
        this.setLocation(x, y);        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsername2 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        lblUsername3 = new javax.swing.JLabel();
        lblPassword1 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        txtcontact = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        lblPassword2 = new javax.swing.JLabel();
        lblUsername4 = new javax.swing.JLabel();
        txtgender = new javax.swing.JTextField();
        lblPassword3 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        lblUsername5 = new javax.swing.JLabel();
        txtaddress = new java.awt.TextArea();
        lblUsername6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtcountry = new javax.swing.JTextField();
        lblPassword4 = new javax.swing.JLabel();
        lblPassword5 = new javax.swing.JLabel();
        lblPassword6 = new javax.swing.JLabel();
        txtcity = new javax.swing.JTextField();
        txtstate = new javax.swing.JTextField();
        txtpincode = new javax.swing.JTextField();
        lblPassword7 = new javax.swing.JLabel();
        lblUsername7 = new javax.swing.JLabel();

        lblUsername8.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        lblUsername8.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername8.setText("Profile");

        setClosable(true);
        setIconifiable(true);
        setTitle("Profile");
        setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 850));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 778));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername2.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        lblUsername2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername2.setText("PROFILE VIEW");
        jPanel1.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 290, 50));

        txtfname.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 300, 50));

        lblUsername3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername3.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername3.setText("First Name");
        jPanel1.add(lblUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 176, 34));

        lblPassword1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword1.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword1.setText("Last Name");
        jPanel1.add(lblPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, -1, -1));

        txtlname.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 300, 50));

        txtcontact.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 300, 50));

        txtemail.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 300, 50));

        lblPassword2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword2.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword2.setText("E-Mail");
        jPanel1.add(lblPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 80, -1));

        lblUsername4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername4.setText("Contact");
        jPanel1.add(lblUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 130, 33));

        txtgender.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 300, 50));

        lblPassword3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword3.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword3.setText("Age");
        jPanel1.add(lblPassword3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 80, -1));

        txtage.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 300, 50));

        lblUsername5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername5.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername5.setText("Gender");
        jPanel1.add(lblUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 149, 33));

        txtaddress.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 300, 140));

        lblUsername6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername6.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername6.setText("Address");
        jPanel1.add(lblUsername6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 161, 33));

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 300, 50));

        txtcountry.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtcountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 680, 300, 50));

        lblPassword4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword4.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword4.setText("Country");
        jPanel1.add(lblPassword4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 680, 80, 58));

        lblPassword5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword5.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword5.setText("State");
        jPanel1.add(lblPassword5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, 80, -1));

        lblPassword6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword6.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword6.setText("City");
        jPanel1.add(lblPassword6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 80, -1));

        txtcity.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 300, 50));

        txtstate.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 300, 50));

        txtpincode.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(txtpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 680, 300, 50));

        lblPassword7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword7.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword7.setText("Pincode");
        jPanel1.add(lblPassword7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 142, 55));

        lblUsername7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername7.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername7.setText("Username");
        jPanel1.add(lblUsername7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 118, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showData() {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            sql = "select * from admindetails where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                txtUsername.setText(rs.getString("username"));
                txtfname.setText(rs.getString("fname"));
                txtlname.setText(rs.getString("lname"));
                txtgender.setText(rs.getString("gender"));
                txtage.setText((rs.getObject("age")).toString());
                txtcontact.setText(rs.getString("contactno"));
                txtemail.setText(rs.getString("email"));
                txtaddress.setText(rs.getString("address"));
                txtpincode.setText(rs.getString("pincode"));
                txtcity.setText(rs.getString("city"));
                txtstate.setText(rs.getString("state_name"));
                txtcountry.setText(rs.getString("country"));                

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        } finally {
            Postgre p = new Postgre();
            p.closeConn(null, ps, rs);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblPassword3;
    private javax.swing.JLabel lblPassword4;
    private javax.swing.JLabel lblPassword5;
    private javax.swing.JLabel lblPassword6;
    private javax.swing.JLabel lblPassword7;
    private javax.swing.JLabel lblUsername2;
    private javax.swing.JLabel lblUsername3;
    private javax.swing.JLabel lblUsername4;
    private javax.swing.JLabel lblUsername5;
    private javax.swing.JLabel lblUsername6;
    private javax.swing.JLabel lblUsername7;
    private javax.swing.JLabel lblUsername8;
    private javax.swing.JTextField txtUsername;
    private java.awt.TextArea txtaddress;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txtcountry;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtgender;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtpincode;
    private javax.swing.JTextField txtstate;
    // End of variables declaration//GEN-END:variables
}

package com.employee;

//This file is made by Lalit


import com.Postgre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lalit
 */
public class EmpProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProfileAdmin
     */
    Connection conn;
    String username;

    public EmpProfile(Connection c, String uname) {
        this.conn = c;
        this.username = uname;
        initComponents();
        this.showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsername2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
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
        txtHireDate = new javax.swing.JTextField();
        lblUsername7 = new javax.swing.JLabel();
        txtcountry = new javax.swing.JTextField();
        lblPassword4 = new javax.swing.JLabel();
        lblPassword5 = new javax.swing.JLabel();
        lblPassword6 = new javax.swing.JLabel();
        txtcity = new javax.swing.JTextField();
        txtstate = new javax.swing.JTextField();
        txtpincode = new javax.swing.JTextField();
        lblPassword7 = new javax.swing.JLabel();
        lblUsername8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Profile");
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 850));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 800));

        lblUsername2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername2.setText("Username");

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        txtfname.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblUsername3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername3.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername3.setText("First Name");

        lblPassword1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword1.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword1.setText("Last Name");

        txtlname.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        txtcontact.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        txtemail.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblPassword2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword2.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword2.setText("E-Mail");

        lblUsername4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername4.setText("Contact No.");

        txtgender.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblPassword3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword3.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword3.setText("Age");

        txtage.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblUsername5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername5.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername5.setText("Gender");

        txtaddress.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblUsername6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername6.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername6.setText("Address");

        txtHireDate.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblUsername7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUsername7.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername7.setText("Hire Date");

        txtcountry.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblPassword4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword4.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword4.setText("Country");

        lblPassword5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword5.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword5.setText("State");

        lblPassword6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword6.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword6.setText("City");

        txtcity.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        txtstate.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        txtpincode.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        lblPassword7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPassword7.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword7.setText("Pincode");

        lblUsername8.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        lblUsername8.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername8.setText("Profile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblUsername5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblUsername6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblPassword7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpincode, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblUsername4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUsername7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblUsername3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword1)
                        .addGap(18, 18, 18)
                        .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsername8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblUsername8)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblUsername6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPassword7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpincode, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPassword4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    void showData() {
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            sql = "select * from employeedetails where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                txtHireDate.setText(rs.getString("hire_date"));
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
    private javax.swing.JTextField txtHireDate;
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

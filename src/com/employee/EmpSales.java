package com.employee;


import com.MyData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EmpSales extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmpSales
     */
    Connection conn;
    String username;
    public EmpSales(Connection x, String uname) {
        initComponents();
        this.conn = x;
        this.username = uname;

        fillProducts();
    }

    void fillProducts() {
        cmbproduct.removeAllItems();
        try {
            String sql = "select product_id, product_name from products";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MyData m = new MyData();
                m.code = rs.getString("product_id");
                m.name = rs.getString("product_name");

                cmbproduct.addItem(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
    }

    boolean isValidData(){        
        String fname = txtfname.getText().trim();
        String lname = txtlname.getText().trim();
        String contact = txtcontact.getText().trim();
        String mail = txtmail.getText().trim();
        String address = txtaddress.getText().trim();
        String city = txtcity.getText().trim();
        String state = txtstate.getText().trim();
        String country = txtcountry.getText().trim();
        
        if(!com.Validation.isValidName(fname)){
            return false;
        }
        if(!com.Validation.isValidName(lname)){
            return false;
        }
        if(!com.Validation.isValidName(city)){
            return false;
        }
        if(!com.Validation.isValidName(state)){
            return false;
        }
        if(!com.Validation.isValidName(country)){
            return false;
        }
        if(!com.Validation.isValidContactNo(contact)){
            return false;
        }
        if(!com.Validation.isValidMail(mail)){
            return false;
        }
        
        return true;
    }
    
    int save() {        
        MyData product = (MyData) cmbproduct.getSelectedItem();
        String product_id = product.code;
        
        String price = txtPrice.getText();
        String quan =String.valueOf(spinnerQuantity.getValue());        
        String total = txtTotal.getText();
        String discount = txtDiscount.getText();
        String tax = txtTax.getText();
        String amt = txtAmount.getText();    
        
        
        String fname = txtfname.getText();
        String lname = txtlname.getText();
        String contact = txtcontact.getText();
        String mail = txtmail.getText();
        String address = txtaddress.getText();
        String city = txtcity.getText();
        String state = txtstate.getText();
        String country = txtcountry.getText();
        
        if(!isValidData()){
            return 0;
        }

        String sql = "insert into sales(product_id, product_price, quantity, total_price, discount, tax, final_amount, customer_fname, customer_lname, customer_contactno,  customer_email,  customer_address,  customer_city,  customer_state,  customer_country) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, product_id);
            ps.setString(2, price);
            ps.setString(3, quan);
            ps.setString(4, total);
            ps.setString(5, discount);
            ps.setString(6, tax);
            ps.setString(7, amt);
            ps.setString(8, fname);
            ps.setString(9, lname);
            ps.setString(10, contact);
            ps.setString(11, mail);
            ps.setString(12, address);
            ps.setString(13, city);
            ps.setString(14, state);
            ps.setString(15, country);            
            
            int count = ps.executeUpdate();
            if(count>0){
                JOptionPane.showMessageDialog(this, count + " record added");
            }           
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
        
        return 1;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        saleItemIF = new javax.swing.JInternalFrame();
        saleItem = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbproduct = new javax.swing.JComboBox();
        txtPrice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtTax = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLlabel12 = new javax.swing.JLabel();
        btnItemProceed = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLlabel13 = new javax.swing.JLabel();
        spinnerQuantity = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLlabel14 = new javax.swing.JLabel();
        btnclr = new javax.swing.JButton();
        customerIF = new javax.swing.JInternalFrame();
        customerDetail = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        txtcontact = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        lblPassword6 = new javax.swing.JLabel();
        lblPassword5 = new javax.swing.JLabel();
        txtstate = new javax.swing.JTextField();
        txtcountry = new javax.swing.JTextField();
        lblPassword4 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnGenerateSale = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SALES");
        setMaximumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        saleItemIF.setBorder(null);
        saleItemIF.setTitle("SALE ITEM");
        saleItemIF.setPreferredSize(new java.awt.Dimension(900, 700));
        try {
            saleItemIF.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        saleItemIF.setVisible(true);

        saleItem.setBackground(new java.awt.Color(51, 51, 51));
        saleItem.setPreferredSize(new java.awt.Dimension(1400, 700));
        saleItem.setRequestFocusEnabled(false);
        saleItem.setVerifyInputWhenFocusTarget(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRICE/UNIT");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DISCOUNT");

        cmbproduct.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cmbproduct.setPreferredSize(new java.awt.Dimension(100, 40));
        cmbproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbproductActionPerformed(evt);
            }
        });

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtPrice.setText("0");
        txtPrice.setPreferredSize(new java.awt.Dimension(100, 40));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTotal.setText("0");
        txtTotal.setPreferredSize(new java.awt.Dimension(100, 40));

        txtTax.setEditable(false);
        txtTax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTax.setText("0");
        txtTax.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL PRICE");

        jLlabel12.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLlabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLlabel12.setText("TAX");

        btnItemProceed.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnItemProceed.setText("PROCEED");
        btnItemProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemProceedActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PRODUCT ID");

        txtDiscount.setEditable(false);
        txtDiscount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDiscount.setText("0");
        txtDiscount.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("QUANTITY");

        txtAmount.setEditable(false);
        txtAmount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtAmount.setText("0");
        txtAmount.setPreferredSize(new java.awt.Dimension(100, 40));

        jLlabel13.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLlabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLlabel13.setText("FINAL AMOUNT");

        spinnerQuantity.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        spinnerQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        spinnerQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinnerQuantity.setFocusable(false);
        spinnerQuantity.setPreferredSize(new java.awt.Dimension(100, 40));
        spinnerQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerQuantityStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("FILL PRODUCT DETAILS HERE");

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        jLlabel14.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLlabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLlabel14.setText("DESCRIPTION");

        btnclr.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnclr.setText("CLEAR");
        btnclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout saleItemLayout = new javax.swing.GroupLayout(saleItem);
        saleItem.setLayout(saleItemLayout);
        saleItemLayout.setHorizontalGroup(
            saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saleItemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saleItemLayout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(saleItemLayout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cmbproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(saleItemLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(saleItemLayout.createSequentialGroup()
                            .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(saleItemLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLlabel13))
                                .addComponent(jLlabel12))
                            .addGap(18, 18, 18)
                            .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTax, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(saleItemLayout.createSequentialGroup()
                            .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel3))
                            .addGap(45, 45, 45)
                            .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addGroup(saleItemLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saleItemLayout.createSequentialGroup()
                        .addComponent(btnItemProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(saleItemLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLlabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(saleItemLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnclr, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        saleItemLayout.setVerticalGroup(
            saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saleItemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(saleItemLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(saleItemLayout.createSequentialGroup()
                        .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLlabel14))
                        .addGap(20, 20, 20)
                        .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLlabel12))
                        .addGap(20, 20, 20)
                        .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLlabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(saleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclr, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnItemProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spinnerQuantity.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout saleItemIFLayout = new javax.swing.GroupLayout(saleItemIF.getContentPane());
        saleItemIF.getContentPane().setLayout(saleItemIFLayout);
        saleItemIFLayout.setHorizontalGroup(
            saleItemIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saleItem, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
        );
        saleItemIFLayout.setVerticalGroup(
            saleItemIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saleItem, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        customerIF.setTitle("CUSTOMER");
        customerIF.setToolTipText("");
        customerIF.setNormalBounds(new java.awt.Rectangle(0, 0, 800, 700));
        try {
            customerIF.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        customerIF.setVisible(false);

        customerDetail.setBackground(new java.awt.Color(153, 51, 38));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CUSTOMER'S DATA");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FIRST NAME");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LAST NAME");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CONTACT NO.");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADDRESS");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("E-MAIL");

        txtmail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtmail.setPreferredSize(new java.awt.Dimension(100, 40));

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtaddress.setRows(5);
        jScrollPane3.setViewportView(txtaddress);

        txtcontact.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtcontact.setPreferredSize(new java.awt.Dimension(100, 40));

        txtlname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtlname.setPreferredSize(new java.awt.Dimension(100, 40));

        txtfname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtfname.setPreferredSize(new java.awt.Dimension(100, 40));

        txtcity.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        lblPassword6.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblPassword6.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword6.setText("CITY");

        lblPassword5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblPassword5.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword5.setText("STATE");

        txtstate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        txtcountry.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        lblPassword4.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblPassword4.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword4.setText("COUNTRY");

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(153, 28, 35));
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(200, 40));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnGenerateSale.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        btnGenerateSale.setForeground(new java.awt.Color(153, 28, 35));
        btnGenerateSale.setText("Generate Sale");
        btnGenerateSale.setPreferredSize(new java.awt.Dimension(200, 40));
        btnGenerateSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerDetailLayout = new javax.swing.GroupLayout(customerDetail);
        customerDetail.setLayout(customerDetailLayout);
        customerDetailLayout.setHorizontalGroup(
            customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customerDetailLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerDetailLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerDetailLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerDetailLayout.createSequentialGroup()
                            .addComponent(lblPassword6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerDetailLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerDetailLayout.createSequentialGroup()
                            .addComponent(lblPassword5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(customerDetailLayout.createSequentialGroup()
                            .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPassword4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(customerDetailLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(117, 117, 117)
                                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(customerDetailLayout.createSequentialGroup()
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(btnGenerateSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(customerDetailLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(226, 226, 226))
        );
        customerDetailLayout.setVerticalGroup(
            customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerDetailLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerDetailLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerDetailLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword6))
                .addGap(18, 18, 18)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword5))
                .addGap(18, 18, 18)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword4))
                .addGap(58, 58, 58)
                .addGroup(customerDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout customerIFLayout = new javax.swing.GroupLayout(customerIF.getContentPane());
        customerIF.getContentPane().setLayout(customerIFLayout);
        customerIFLayout.setHorizontalGroup(
            customerIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        customerIFLayout.setVerticalGroup(
            customerIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(saleItemIF, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(customerIF, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(customerIF, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(saleItemIF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnItemProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemProceedActionPerformed
        // TODO add your handling code here:
        saleItemIF.setVisible(false);
        customerIF.setVisible(true);
    }//GEN-LAST:event_btnItemProceedActionPerformed


    private void cmbproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbproductActionPerformed
        // TODO add your handling code here:
        if (cmbproduct.getSelectedItem() != null) {
            MyData m = (MyData) cmbproduct.getSelectedItem();
            fillDetails(m.code);
        }
    }//GEN-LAST:event_cmbproductActionPerformed


    private void spinnerQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerQuantityStateChanged
        // TODO add your handling code here:
        int q = (int) spinnerQuantity.getValue();
        calculate(q);
    }//GEN-LAST:event_spinnerQuantityStateChanged


    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    
    private void btnGenerateSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateSaleActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnGenerateSaleActionPerformed

    
    private void btnclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclrActionPerformed
        // TODO add your handling code here:
        cmbproduct.setSelectedItem(null);
        txtPrice.setText("0");
        spinnerQuantity.setValue(0);
        txtTotal.setText("0");
        txtDiscount.setText("0");
        txtTax.setText("0");
        txtAmount.setText("0");
        txtDesc.setText("");        
    }//GEN-LAST:event_btnclrActionPerformed

    
    void fillDetails(String product_id) {
        try {
            String sql = "select * from products p, categories c where p.product_id=? and p.category_id=c.category_id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtPrice.setText(rs.getString("price_per_unit"));
                txtDiscount.setText(rs.getString("discount"));
                txtTax.setText(rs.getString("tax_charge"));
                txtDesc.setText(rs.getString("description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }

    }

    
    void calculate(int quan) {
        Float pq = Float.parseFloat(txtPrice.getText()) * quan;
        txtTotal.setText((String.valueOf(pq)));

        Float pad = pq - ((Float.parseFloat(txtDiscount.getText()) * pq) / 100);
        Float pat = pad + ((Float.parseFloat(txtTax.getText()) * pad) / 100);

        txtAmount.setText(String.valueOf(pat));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGenerateSale;
    private javax.swing.JButton btnItemProceed;
    private javax.swing.JButton btnclr;
    private javax.swing.JComboBox cmbproduct;
    private javax.swing.JPanel customerDetail;
    private javax.swing.JInternalFrame customerIF;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLlabel12;
    private javax.swing.JLabel jLlabel13;
    private javax.swing.JLabel jLlabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPassword4;
    private javax.swing.JLabel lblPassword5;
    private javax.swing.JLabel lblPassword6;
    private javax.swing.JPanel saleItem;
    private javax.swing.JInternalFrame saleItemIF;
    private javax.swing.JSpinner spinnerQuantity;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTax;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txtcountry;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtstate;
    // End of variables declaration//GEN-END:variables
}


package restbooking;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

    public class booking extends javax.swing.JFrame {

//    private int index;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Date;
    private String Mobile;
    
    private static final String URL = "jdbc:mysql://localhost:3306/restaurantBookings?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";
    
    private Connection connection = null;

    public void clearTable()
    {
        ((DefaultTableModel)TableDate.getModel()).setNumRows(0);
    }
    private void loadBookings(Connection con) throws SQLException {
        javax.swing.table.DefaultTableModel aModel = new DefaultTableModel();
        clearTable();
        PreparedStatement stat = con.prepareStatement("SELECT BookingID, FirstName, LastName, Email, DateBooking, Mobile FROM Bookings");
        ResultSet rs = stat.executeQuery();
        String[] tableColumnsName = {"BookingID", "FirstName", "LastName", "Email", "DateBooking", "Mobile"}; 
        aModel = (javax.swing.table.DefaultTableModel) TableDate.getModel();  
        aModel.setColumnIdentifiers(tableColumnsName); // query
        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
        int colNo = rsmd.getColumnCount();
        while(rs.next()){
            Object[] objects = new Object[colNo];
            for(int i = 0; i < colNo; i++) {
                objects[i] = rs.getObject(i+1);
            }
            aModel.addRow(objects);
        }
        TableDate.setModel(aModel);
       
    }
    
    public booking() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in the screen
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelMobile = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMobile = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jButtonBook = new javax.swing.JButton();
        jLabelBirthday = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDate = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateChooser = new datechooser.beans.DateChooserCombo();
        jLabel1Booking = new javax.swing.JLabel();
        jButton1Close = new javax.swing.JButton();

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jLabelMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMobile.setForeground(new java.awt.Color(236, 240, 241));
        jLabelMobile.setText("Mobile: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("E-mail:");

        jTextFieldMobile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextFieldLastName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextFieldFirstName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        update.setBackground(new java.awt.Color(242, 38, 19));
        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("Update");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButtonBook.setBackground(new java.awt.Color(34, 167, 240));
        jButtonBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonBook.setText("Book");
        jButtonBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBookMouseClicked(evt);
            }
        });
        jButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBookActionPerformed(evt);
            }
        });

        jLabelBirthday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBirthday.setForeground(new java.awt.Color(236, 240, 241));
        jLabelBirthday.setText("Date:");

        TableDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Last Name", "Mobile", "Email", "Date"
            }
        ));
        try{
            Class.forName("com.mysql.jdbc.Driver");//Usando Driver Mysql
            Connection con= DriverManager.getConnection(URL, USERNAME, PASSWORD);//Conectando na base de Dados pois você ainda não tem conexão ativa nesse ponto do programa.
            loadBookings(con);// Carregando a lista a partir do banco de dados usando o método criado no item 1
            con.close();// fecha a conexão.
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        TableDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDateMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDate);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        delete.setBackground(new java.awt.Color(242, 38, 19));
        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Id:");

        jTextFieldId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelMobile)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBirthday)
                                    .addComponent(jLabel5)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(update)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonBook))
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {delete, jButtonBook, update});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldEmail, jTextFieldFirstName, jTextFieldId, jTextFieldLastName, jTextFieldMobile});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMobile)
                            .addComponent(jTextFieldMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabelBirthday))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(update)
                            .addComponent(jButtonBook))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))))
        );

        jLabel1Booking.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1Booking.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1Booking.setText("Booking");

        jButton1Close.setBackground(new java.awt.Color(248, 148, 6));
        jButton1Close.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1Close.setForeground(new java.awt.Color(255, 255, 255));
        jButton1Close.setText("X");
        jButton1Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1CloseMouseClicked(evt);
            }
        });
        jButton1Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1Close, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1Close))
                .addGap(13, 13, 13)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1CloseMouseClicked
              
        System.exit(0);
    }//GEN-LAST:event_jButton1CloseMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        
        
    }//GEN-LAST:event_updateMouseClicked

    private void jButtonBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBookMouseClicked
    
        
    }//GEN-LAST:event_jButtonBookMouseClicked

    private void jButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBookActionPerformed
        
        try{                                             
            
            String firstname=jTextFieldFirstName.getText();
            String lastname=jTextFieldLastName.getText();
            String email=jTextFieldEmail.getText();
            String mobile=jTextFieldMobile.getText();
            
            String date=((JTextField)jDateChooser.getDateEditor().getUiComponent()).getText();
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateNew = sdf1.parse(date);
            java.sql.Date sqlStartDate = new java.sql.Date(dateNew.getTime());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql="INSERT INTO Bookings (FirstName, LastName, Email, DateBooking, Mobile) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setDate(4, sqlStartDate);
            ps.setString(5, mobile);
            ps.executeUpdate();

            loadBookings(con);

            con.close();
            JOptionPane.showMessageDialog(this,"Data Inserted Successfully");
            //Limpeza dos campos de entrada
            jTextFieldFirstName.setText("");
            jTextFieldFirstName.setText("");
            jTextFieldLastName.setText("");
            jTextFieldEmail.setText("");
            jTextFieldMobile.setText("");
            ((JTextField)jDateChooser.getDateEditor().getUiComponent()).setText("");
           
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }catch(ParseException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonBookActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         
        try{                                             
            
            String firstname=jTextFieldFirstName.getText();
            String lastname=jTextFieldLastName.getText();
            String email=jTextFieldEmail.getText();
            String mobile=jTextFieldMobile.getText();
            String id=jTextFieldId.getText(); 
            java.sql.Date sqlStartDate = null;
            try{
                String date=((JTextField)jDateChooser.getDateEditor().getUiComponent()).getText();            
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date dateNew = sdf1.parse(date);
                sqlStartDate = new java.sql.Date(dateNew.getTime());
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "error");
            }
            

            Class.forName("com.mysql.jdbc.Driver");//Usando Driver Mysql
            Connection con= DriverManager.getConnection(URL, USERNAME, PASSWORD);//Conectando na base de Dados pois você ainda não tem conexão ativa nesse ponto do programa.
            String sql="UPDATE restaurantbookings.bookings SET FirstName = '"+firstname+"', LastName = '"+lastname+"' , Email = '"+email+"' , DateBooking = '"+sqlStartDate+"', Mobile = '"+mobile+"' WHERE BookingID = "+id+"";
            
           
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.executeUpdate(sql);
            
            
            clearTable();
            loadBookings(con);

            con.close();
            JOptionPane.showMessageDialog(this,"Data Updated Successfully");
            
           
        }catch(Exception ex){
           JOptionPane.showMessageDialog(this, "error");
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1CloseActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton1CloseActionPerformed

    private void jDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserMouseClicked
            
        JOptionPane.showMessageDialog(null, jDateChooser.getDate());
        
    }//GEN-LAST:event_jDateChooserMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
         try{                                             
            String id=jTextFieldId.getText(); 
            
            Class.forName("com.mysql.jdbc.Driver");//Usando Driver Mysql
            Connection con= DriverManager.getConnection(URL, USERNAME, PASSWORD);//Conectando na base de Dados pois você ainda não tem conexão ativa nesse ponto do programa.

              
            PreparedStatement deleteEntry = con.prepareStatement("DELETE FROM Bookings WHERE BookingID = ?");
            
            deleteEntry.setInt(1, Integer.parseInt(id));

            deleteEntry.executeUpdate(); // insert the entry
            clearTable();
            loadBookings(con);

            con.close();
            JOptionPane.showMessageDialog(this,"Data Deleted Successfully");

        }catch(Exception ex){
           JOptionPane.showMessageDialog(this,"Error");
        }
        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(this, "dasdas");
        try{                                             
            
            String id=jTextFieldId.getText();
            Class.forName("com.mysql.jdbc.Driver");//Usando Driver Mysql
            Connection con= DriverManager.getConnection(URL, USERNAME, PASSWORD);//Conectando na base de Dados pois você ainda não tem conexão ativa nesse ponto do programa.
            PreparedStatement stat = con.prepareStatement("SELECT BookingID, FirstName, LastName, Mobile, Email, DateBooking FROM restaurantbookings.bookings WHERE BookingID = ?");
            //PreparedStatement stat = con.prepareStatement("SELECT FirstName, LastName, Mobile, Email, DateBooking FROM restaurantbookings.bookings");
            //String sql="SELECT FirstName, LastName, Mobile, Email, DateBooking FROM restaurantbookings.bookings WHERE BookingID = ?";
            stat.setString(1, id);
            ResultSet rs = stat.executeQuery();
            String[] tableColumnsName = {"BookingID", "FirstName", "LastName", "Email", "DateBooking", "Mobile"}; 
            
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int colNo = rsmd.getColumnCount();
           String dateResult;
            while(rs.next()){
             
            
           jTextFieldFirstName.setText(rs.getObject(2).toString()); 
             jTextFieldId.setText(rs.getObject(1).toString()); 
             jTextFieldLastName.setText(rs.getObject(3).toString()); 
             jTextFieldMobile.setText(rs.getObject(4).toString()); 
             jTextFieldEmail.setText(rs.getObject(5).toString()); 
             
           try{
            String dateValue = rs.getString(6); // Your column Name
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
            jDateChooser.setDate(date);
           }
           catch(Exception ex){
               
            JOptionPane.showMessageDialog(this, "erro");
           }


            
            }
 
            con.close();
 
           
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(this, "erro");
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDateMouseClicked
        
       DefaultTableModel model = (DefaultTableModel)TableDate.getModel();

        // get the selected row index
       int selectedRowIndex = TableDate.getSelectedRow();
       
        // set the selected row data into jtextfields
       jTextFieldId.setText(model.getValueAt(selectedRowIndex, 0).toString());
       jTextFieldFirstName.setText(model.getValueAt(selectedRowIndex, 1).toString());
       jTextFieldLastName.setText(model.getValueAt(selectedRowIndex, 2).toString());
       jTextFieldMobile.setText(model.getValueAt(selectedRowIndex, 5).toString());
       jTextFieldEmail.setText(model.getValueAt(selectedRowIndex, 3).toString());
       try{
            String dateValue = model.getValueAt(selectedRowIndex, 4).toString(); // Your column Name
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
            jDateChooser.setDate(date);
           }
           catch(Exception ex){
               
            JOptionPane.showMessageDialog(this, "erro");
           }
    }//GEN-LAST:event_TableDateMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDate;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Close;
    private javax.swing.JButton jButtonBook;
    private datechooser.beans.DateChooserCombo jDateChooser;
    private javax.swing.JLabel jLabel1Booking;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelBirthday;
    private javax.swing.JLabel jLabelMobile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldMobile;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}

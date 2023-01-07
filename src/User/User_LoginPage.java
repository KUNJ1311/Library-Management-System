/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kunj
 */
public class User_LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form User_SignupPage
     */
    public User_LoginPage() {
        initComponents();
    }

    //validation method 
    public boolean validateLogin() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();

        if (name.equals("")) {
            ImageIcon icon = new ImageIcon(User_LoginPage.class.getResource("/test/error.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:red\">Please Enter Username</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE, icon);
            return false;
        }
        if (pwd.equals("")) {
            ImageIcon icon = new ImageIcon(User_LoginPage.class.getResource("/test/error.png"));
            JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:red\">Please Enter Password</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE, icon);
            return false;
        }
        return true;
    }

    //verify all details
    public void Login() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();

        try {
            Connection con = User_DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from users where name = ? and password = ?");

            pst.setString(1, name);
            pst.setString(2, pwd);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ImageIcon icon = new ImageIcon(User_LoginPage.class.getResource("/test/checked.png"));
                JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:green\">Successfully Login</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE, icon);
                //new User_HomePage(txt_username).setVisible(true);
                User_HomePage home = new User_HomePage();
                User_HomePage.txt_user_profile.setText(User_LoginPage.txt_username.getText());
                home.setVisible(true);
                this.dispose();
            } else {
                ImageIcon icon = new ImageIcon(User_LoginPage.class.getResource("/test/error.png"));
                JOptionPane.showMessageDialog(this, "<html><b style=\"font-family:Book Antiqua;font-size:14px;font-family:Book Antiqua;font-size:14px;color:red\">Incorrect Username Or Password!!!</b></html>", "Message", JOptionPane.INFORMATION_MESSAGE, icon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jLabel7 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        checkbox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1390, 730));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(224, 224, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Imprint MT Shadow", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/exit.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 50));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel6.setText("Login To Your Account");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 440, 40));

        txt_username.setBackground(new java.awt.Color(224, 224, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txt_username.setToolTipText("Enter User ID....");
        txt_username.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_username.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 350, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/member.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 50, 50));

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel9.setText("Username:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 120, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/password.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 50, 50));

        jLabel13.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel13.setText("Password:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 30));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonRectangle1.setText("Login");
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 130, -1));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle2.setText("Signup");
        rSMaterialButtonRectangle2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 130, -1));

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel7.setText("Login Page");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 230, 40));

        txt_password.setBackground(new java.awt.Color(224, 224, 255));
        txt_password.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        txt_password.setToolTipText("Enter Password....");
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txt_password.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 350, 40));

        checkbox.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        checkbox.setText("View/Hide Password");
        checkbox.setToolTipText("");
        checkbox.setActionCommand("");
        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActionPerformed(evt);
            }
        });
        jPanel2.add(checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 510, 730));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 155));
        jLabel1.setText("Library Management System");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 580, 40));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 155));
        jLabel3.setText("Welcome To");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 240, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-3.png.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 780, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 730));

        setSize(new java.awt.Dimension(1400, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        User_SignupPage UserSignup = new User_SignupPage();
        UserSignup.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        if (validateLogin()) {
            Login();

        }
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActionPerformed
        // TODO add your handling code here:
        if (checkbox.isSelected()) {
            txt_password.setEchoChar((char) 0);

        } else {
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_checkboxActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost

    }//GEN-LAST:event_txt_usernameFocusLost

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
            java.util.logging.Logger.getLogger(User_LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private javax.swing.JPasswordField txt_password;
    public static app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}

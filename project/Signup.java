
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;



public class Signup extends javax.swing.JFrame {
    Connection con;
    Statement st;
    ResultSet rs;
    ResultSetMetaData rd;
    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String pass = "";
    
    public void conn(){
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from users");
            rd  = rs.getMetaData();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    
    
    public Signup() {
        initComponents();
        conn();
        
        jButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    rs.moveToInsertRow();
                    rs.updateString("user_name",jTextField1.getText());
                    rs.updateInt("pass",Integer.parseInt(password.getText()));
                    rs.insertRow();
                    JOptionPane.showMessageDialog(null, "Account created successfully");
                    Login myf = new Login();
                    myf.setVisible(true);
                    myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                    }
                    
                catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        
        
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login myf = new Login();
                myf.setVisible(true);
                myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        
                 if(Login.theme == 1){
            getContentPane().setBackground(new Color(248,250,252));
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JTextField || comp instanceof JButton){
                comp.setBackground(new Color(217, 234, 253));
                comp.setForeground(new Color(0,0,0));
            }
            
            if(comp instanceof JLabel){
                comp.setForeground(new Color(0,0,0));
            }
            
              if(comp instanceof JScrollPane jScrollPane ){
                Component view = jScrollPane.getViewport().getView();
                if(view instanceof JTextArea textArea){
                    textArea.setBackground(new Color(217, 234, 253));
                    textArea.setForeground(new Color(0,0,0));          
                }
                 if(view instanceof JTable table){
                    table.setBackground(new Color(217, 234, 253));
                    table.setForeground(new Color(0,0,0));           
                }
                
            } 
        }
        }else if(Login.theme == 2){
             getContentPane().setBackground(new Color(34,40,49));
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JTextField || comp instanceof JButton){
                comp.setBackground(new Color(57, 62, 70));
                comp.setForeground(new Color(238, 238, 238));
            }
            
            if(comp instanceof JLabel){
                comp.setForeground(new Color(238, 238, 238));
            }
            
            if(comp instanceof JScrollPane jScrollPane ){
                Component view = jScrollPane.getViewport().getView();
                if(view instanceof JTextArea textArea){
                    textArea.setBackground(new Color(57, 62, 70));
                    textArea.setForeground(new Color(238, 238, 238));            
                }
                 if(view instanceof JTable table){
                    table.setBackground(new Color(57, 62, 70));
                    table.setForeground(new Color(238, 238, 238));            
                }
            }

                
        }
        }else if(Login.theme == 3){
            getContentPane().setBackground(new Color(163, 92, 122));
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JTextField || comp instanceof JButton){
                comp.setBackground(new Color(200 , 144 , 167));
                comp.setForeground(new Color(33,33,33));
            }
            
            if(comp instanceof JLabel){
                comp.setForeground(new Color(251 ,245 ,229));
            }
            
            if(comp instanceof JScrollPane jScrollPane ){
                Component view = jScrollPane.getViewport().getView();
                if(view instanceof JTextArea textArea){
                    textArea.setBackground(new Color(200 , 144 , 167));
                    textArea.setForeground(new Color(33,33,33));          
                }
                 if(view instanceof JTable table){
                    table.setBackground(new Color(200 , 144 , 167));
                    table.setForeground(new Color(33,33,33));          
                }
            }
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        passBox = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Nova Cond Light", 1, 48)); // NOI18N
        jLabel1.setText("Sign Up");

        jLabel2.setFont(new java.awt.Font("Arial Nova Cond", 0, 18)); // NOI18N
        jLabel2.setText("Enter Username");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Nova Cond", 0, 18)); // NOI18N
        jLabel4.setText("Enter Password");

        password.setFont(new java.awt.Font("Arial Nova Cond", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial Nova Cond", 0, 14)); // NOI18N
        jButton1.setText("Create Account");

        passBox.setFont(new java.awt.Font("Arial Nova Cond", 0, 12)); // NOI18N
        passBox.setText("Show Password");
        passBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passBoxActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Nova Cond", 0, 14)); // NOI18N
        jButton2.setText("log in ");

        jLabel6.setFont(new java.awt.Font("Arial Nova Cond", 0, 16)); // NOI18N
        jLabel6.setText("Already have an account?");

        jMenu6.setMnemonic('T');
        jMenu6.setText("Themes");

        jMenuItem12.setText("Light");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuItem13.setText("Dark");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuItem14.setText("Colorful");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(272, 272, 272))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2)
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(passBox)
                        .addGap(296, 296, 296))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(288, 288, 288))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel6))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void passBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passBoxActionPerformed
          if (evt.getSource() == passBox && passBox.getText().equals("Show Password")) {
                password.setEchoChar((char) 0);
                passBox.setText("Hide Password");
            } else {
                password.setEchoChar('*');
                passBox.setText("Show Password");
            }
    }//GEN-LAST:event_passBoxActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Login.theme = 1;
        getContentPane().setBackground(new Color(248,250,252));
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JTextField || comp instanceof JButton){
                comp.setBackground(new Color(217, 234, 253));
                comp.setForeground(new Color(0,0,0));
            }

            if(comp instanceof JLabel || comp instanceof JCheckBox){
                comp.setForeground(new Color(0,0,0));
            }

            if(comp instanceof JScrollPane jScrollPane ){
                Component view = jScrollPane.getViewport().getView();
                if(view instanceof JTextArea textArea){
                    textArea.setBackground(new Color(217, 234, 253));
                    textArea.setForeground(new Color(0,0,0));
                }
                if(view instanceof JTable table){
                    table.setBackground(new Color(217, 234, 253));
                    table.setForeground(new Color(0,0,0));
                }

            }
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        Login.theme = 2;
        getContentPane().setBackground(new Color(34,40,49));
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JTextField || comp instanceof JButton){
                comp.setBackground(new Color(57, 62, 70));
                comp.setForeground(new Color(238, 238, 238));
            }

            if(comp instanceof JLabel || comp instanceof JCheckBox){
                comp.setForeground(new Color(238, 238, 238));
            }

            if(comp instanceof JScrollPane jScrollPane ){
                Component view = jScrollPane.getViewport().getView();
                if(view instanceof JTextArea textArea){
                    textArea.setBackground(new Color(57, 62, 70));
                    textArea.setForeground(new Color(238, 238, 238));
                }
                if(view instanceof JTable table){
                    table.setBackground(new Color(57, 62, 70));
                    table.setForeground(new Color(238, 238, 238));
                }
            }

        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        Login.theme = 3;
        getContentPane().setBackground(new Color(163, 92, 122));
        for(Component comp : getContentPane().getComponents()){
            if(comp instanceof JTextField || comp instanceof JButton){
                comp.setBackground(new Color(200 , 144 , 167));
                comp.setForeground(new Color(33,33,33));
            }

            if(comp instanceof JLabel || comp instanceof JCheckBox){
                comp.setForeground(new Color(251 ,245 ,229));
            }

            if(comp instanceof JScrollPane jScrollPane ){
                Component view = jScrollPane.getViewport().getView();
                if(view instanceof JTextArea textArea){
                    textArea.setBackground(new Color(200 , 144 , 167));
                    textArea.setForeground(new Color(33,33,33));
                }
                if(view instanceof JTable table){
                    table.setBackground(new Color(200 , 144 , 167));
                    table.setForeground(new Color(33,33,33));
                }
            }
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JCheckBox passBox;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}

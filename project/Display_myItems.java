
package project;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class Display_myItems extends javax.swing.JFrame {
    Connection con;
    Statement st;
    Statement st1;
    Statement st2;
    ResultSet rs;
    ResultSetMetaData rd;
    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String pass = "";

    public void conn(){
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            rs = st.executeQuery("select * from items");
//            rd  = rs.getMetaData();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }  

    
    public Display_myItems() {
        initComponents();
        conn();
        
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("SELECT item_title, item_description FROM borrow WHERE user_id ="+Login.userId);
            rd = rs.getMetaData();

            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            jTable1.setModel(model);
            jScrollPane4.setColumnHeaderView(null);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
        }
        
        // jTable2: Rent items
        try {
            st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st1.executeQuery("SELECT item_title,item_price, item_description FROM rent WHERE user_id ="+Login.userId);
            rd = rs.getMetaData();

            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            jTable2.setModel(model);
            jScrollPane5.setColumnHeaderView(null);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
        }

        // jTable3: Lost items
        try {
            st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st2.executeQuery("SELECT item_title,prize,item_description FROM lost WHERE user_id ="+Login.userId);
            rd = rs.getMetaData();

            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            jTable3.setModel(model);
            jScrollPane1.setColumnHeaderView(null);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
        }
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Nova Cond", 0, 36)); // NOI18N
        jLabel1.setText("Posted Items");

        jLabel2.setFont(new java.awt.Font("Arial Nova Cond Light", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/borrow.png"))); // NOI18N
        jLabel2.setText("borrowed");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                " Title", "  Prize", "Description"
            }
        ));
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Arial Nova Cond Light", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/rent.png"))); // NOI18N
        jLabel3.setText("Rented");

        jLabel4.setFont(new java.awt.Font("Arial Nova Cond Light", 0, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/lost-items 32px.png"))); // NOI18N
        jLabel4.setText("Lost");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                " Title", "  Description"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                " Title", "  Price", "Description"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable2);

        jMenu1.setMnemonic('M');
        jMenu1.setText("Main");

        jMenuItem10.setText("Home Page");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Log Out");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu7.setMnemonic('E');
        jMenu7.setText("Edit");

        jMenuItem15.setText("Update Account Info");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuBar1.add(jMenu7);

        jMenu4.setMnemonic('D');
        jMenu4.setText("Display");

        jMenuItem6.setText("My Items");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenu5.setText("Other's Items");

        jMenuItem7.setText("Borrowed");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Rented");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("Lost");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenu4.add(jMenu5);

        jMenuBar1.add(jMenu4);

        jMenu2.setMnemonic('I');
        jMenu2.setText("Item Managment ");

        jMenu3.setText("Add New Item");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Borrowed");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Rented");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Lost");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(8, 8, 8)))
                        .addGap(302, 302, 302))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(94, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(76, 76, 76)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(274, 274, 274)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Home myf = new Home();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to Log out of Your Account?",
            "Exit Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            Login myf = new Login();
            myf.setVisible(true);
            myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose(); // Closes the current JFrame
        }

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        UpdateInfo myf = new UpdateInfo();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Display_myItems myf = new Display_myItems();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        others_borrow myf = new others_borrow();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        others_rent myf  = new others_rent();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        others_lost myf = new others_lost();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AddBorrow myf = new AddBorrow();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AddRent myf = new AddRent();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        AddLost myf = new AddLost();
        myf.setVisible(true);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Login.theme = 1;
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
            java.util.logging.Logger.getLogger(Display_myItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display_myItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display_myItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display_myItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display_myItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}

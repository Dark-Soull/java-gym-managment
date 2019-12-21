package com.nitesh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class login {
        JFrame f = new JFrame("Gym Admin login");
         membership m=new membership();
          admin ad=new admin();
        JTextField t = new JTextField();
        JButton b = new JButton("login");
        JPasswordField p = new JPasswordField();
        JLabel l = new JLabel("Username");
        JLabel l1 = new JLabel("Password");
        JComboBox<String> c = new JComboBox<String>();
        public void launch ()
        {
            f.setSize(400, 500);
            t.setBounds(150, 130, 100, 20);
            p.setBounds(150, 160, 100, 20);
            b.setBounds(150, 220, 80, 20);
            l.setBounds(75, 130, 100, 20);
            l1.setBounds(75, 160, 100, 20);
            c.setBounds(150, 190, 100, 20);
            c.addItem("Member");
            c.addItem("Admin");
            f.add(l);
            f.add(l1);
            f.add(t);
            f.add(p);
            f.add(b);
            f.add(c);
            f.setResizable(false);
            f.setLayout(null);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            b.setActionCommand("click");
            b.addActionListener(new Onclick());
       }
        private class Onclick implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String usr = t.getText();
                String pass = p.getText();
                String role = c.getSelectedItem().toString();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");

                    PreparedStatement st = connection.prepareStatement("Select usr, pass,role from login where usr=? and pass=? and role=?");

                    st.setString(1, usr);
                    st.setString(2, pass);
                    st.setString(3,role);
                    ResultSet rs = st.executeQuery();
                        if (rs.next()) {
                            if(role.equals("Admin")) {
                                ad.show();
                              f.setVisible(false);
                            }
                            else{
                                m.value(usr);
                                m.bound();
                                f.setVisible(false);
                            }
                        }
                         else {
                                JOptionPane.showMessageDialog(b, "Wrong Username & Password & Role");
                              }
                      } catch(SQLException | ClassNotFoundException sqlException){
                        sqlException.printStackTrace();
                    }

            }
        }
    }



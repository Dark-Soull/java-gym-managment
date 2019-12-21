package com.nitesh;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class admin {
    private JFrame f = new JFrame("Admin Panel");

    private JPanel p = new JPanel();

    private JLabel la = new JLabel("Welcome Admin");

    private URL url = admin.class.getResource("dashboard_admin.html");
    private URL url1 = admin.class.getResource("equipment.html");

    //table
    String[] ColumnName = {"Member Names", "username","Membership Type","Joining Date", "End Date", "Detail"};
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();


    JComboBox<String> jb = new JComboBox<String>();
    JComboBox<String> jb1 = new JComboBox<String>();
    JComboBox<String> jb2 = new JComboBox<String>();
    JComboBox<String> jb3 = new JComboBox<String>();

    private JTabbedPane tab = new JTabbedPane();
    private JEditorPane ep = new JEditorPane();
    private JEditorPane ep1 = new JEditorPane();
    private JEditorPane ep2 = new JEditorPane();
    private JEditorPane ep3 = new JEditorPane();
    private JEditorPane ep4 = new JEditorPane();


    private JScrollPane s = new JScrollPane(ep1);
    private JScrollPane s1 = new JScrollPane(table);
    private JScrollPane s2 = new JScrollPane(ep2);
    private JScrollPane s3 = new JScrollPane(ep3);
    private JScrollPane s4 = new JScrollPane(ep4);

    //Add member
    //titles
    private JLabel la1 = new JLabel("Personal Information:-");
    private JLabel la2 = new JLabel("Body Information:-");
    private JLabel la3 = new JLabel("Membership Type:-");
    private JLabel la4 = new JLabel("Admin Area (Only For Admin):-");

    //personal info
    private JLabel l1 = new JLabel("Full Name:-");
    private JLabel l2 = new JLabel("Age:-");
    private JLabel l3 = new JLabel("Date Of Birth:-");
    private JLabel l4 = new JLabel("Permanent Address:-");
    private JLabel l5 = new JLabel("Temporary Address:-");
    private JLabel l6 = new JLabel("Contact No:-");
    private JLabel l7 = new JLabel("Email:-");
    private JLabel l8 = new JLabel("Gender:-");

    //body info
    private JLabel l9 = new JLabel("Height (Ft):-");
    private JLabel l10 = new JLabel("Weight (Kg):-");
    private JLabel l11 = new JLabel("Chest Size (In):-");
    private JLabel l12 = new JLabel("Belly Size (In):-");

    //membership info
    private JLabel l13 = new JLabel("Joining Date:-");
    private JLabel l22 = new JLabel("Membership Type:-");
    private JLabel l14 = new JLabel("End Date:-");
    private JLabel l15 = new JLabel("Total Amount:-");
    private JLabel l16 = new JLabel("Total Paid:-");
    private JLabel l17 = new JLabel("Due Amount:-");
    private JLabel l23 = new JLabel("Payment Method:-");

    //admin area
    private JLabel l18 = new JLabel("Username:-");
    private JLabel l19 = new JLabel("Password:-");
    private JLabel l20 = new JLabel("Role:-");
    private JLabel l21 = new JLabel("Staff Name:-");

    //all text fields
    private JTextField t1 = new JTextField();
    private JTextField t2 = new JTextField();
    private JTextField t3 = new JTextField();
    private JTextField t4 = new JTextField();
    private JTextField t5 = new JTextField();
    private JTextField t6 = new JTextField();
    private JTextField t7 = new JTextField();
    private JTextField t8 = new JTextField();
    private JTextField t9 = new JTextField();
    private JTextField t10 = new JTextField();
    private JTextField t11 = new JTextField();
    private JTextField t12 = new JTextField();
    private JTextField t13 = new JTextField();
    private JTextField t14 = new JTextField();
    private JTextField t15 = new JTextField();
    private JTextField t16 = new JTextField();
    private JTextField t17 = new JTextField();
    private JTextField t18 = new JTextField();
    private JTextField t19 = new JTextField();
    private JTextField t20 = new JTextField();

    //button on add member
    private JButton b = new JButton("Submit");
    private JButton b1 = new JButton("Change password");
    private JButton b2 = new JButton("LogOut");

    //change pass
    private JLabel lab = new JLabel("Current Password:-");
    private JLabel lab1 = new JLabel("New Password:-");
    private JLabel lb2 = new JLabel("Re-Enter Password:-");
    private JTextField jt = new JTextField();
    private JTextField jt1 = new JTextField();
    private JTextField jt2 = new JTextField();


    public void show() {
        f.setSize(1000, 900);
        f.setLocationRelativeTo(null);
        f.add(p);
        f.add(tab);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel of admin
        p.setLayout(null);
        p.setBounds(5, 5, 990, 90);
        p.setBackground(Color.BLUE);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
        p.add(la);

        b2.setBounds(880, 35, 100, 40);
        b2.setFont(new Font("TimesRoman", Font.BOLD, 16));
        b2.setBackground(Color.RED);
        b2.addActionListener(new admin.click1());
        b2.setActionCommand("click3");
        p.add(b2);

        la.setFont(new Font("TimesRoman", Font.BOLD, 60));
        la.setBounds(200, 5, 800, 90);
        la.setForeground(Color.WHITE);

        //tab of admin
        tab.setBounds(8, 95, 985, 765);
        tab.setBackground(Color.YELLOW);

        //dashboard
        tab.addTab("Dashboard", s);
        ep1.setEditable(false);
        try {
            ep1.setPage(url);
        } catch (IOException e) {
            ep1.setContentType("text/html");
            ep1.setText("<html>Page not found.</html>");
        }


        //member
        tab.addTab("Members", s1);
        ep.setEditable(false);
        ep.setBackground(Color.pink);
        table.setModel(model);
        table.setBounds(5, 5, 500, 500);
        table.setFillsViewportHeight(true);
        model.setColumnIdentifiers(ColumnName);
        String query = "SELECT name,username,membership,j_date,e_date FROM add_member;";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String col2 = rs.getString("name");
                String col3 = rs.getString("username");
                String col4=rs.getString("membership");
                String col5 = rs.getString("j_date");
                String col6 = rs.getString("e_date");

                model.addRow(new Object[]{ col2, col3, col4, col5,col6, "Detail"});
            }
        } catch (Exception ex) {
        }
        table.getColumn("Detail").setCellRenderer(new ClientsTableButtonRenderer());
        table.getColumn("Detail").setCellEditor(new ClientsTableRenderer(new JCheckBox()));


        //personal info
        tab.addTab("Add Member", s2);
        la1.setBounds(10, 3, 200, 30);
        la1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep2.add(la1);
        l1.setBounds(25, 43, 100, 20);
        t1.setBounds(110, 43, 300, 22);
        ep2.add(t1);
        ep2.add(l1);
        l2.setBounds(450, 43, 100, 20);
        t2.setBounds(492, 43, 50, 22);
        ep2.add(l2);
        ep2.add(t2);
        l8.setBounds(600, 43, 100, 20);
        jb.addItem("Male");
        jb.addItem("Female");
        jb.setBounds(665, 43, 100, 22);
        ep2.add(l8);
        ep2.add(jb);
        l3.setBounds(25, 90, 100, 20);
        t3.setBounds(130, 90, 150, 22);
        ep2.add(t3);
        ep2.add(l3);
        l6.setBounds(320, 90, 100, 20);
        t4.setBounds(412, 90, 150, 22);
        ep2.add(t4);
        ep2.add(l6);
        l7.setBounds(600, 90, 100, 20);
        t5.setBounds(655, 90, 250, 22);
        ep2.add(t5);
        ep2.add(l7);
        l5.setBounds(25, 137, 200, 20);
        t6.setBounds(175, 137, 200, 22);
        ep2.add(t6);
        ep2.add(l5);
        l4.setBounds(420, 137, 200, 20);
        t7.setBounds(575, 137, 250, 22);
        ep2.add(t7);
        ep2.add(l4);

        //body info
        la2.setBounds(10, 180, 200, 30);
        la2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep2.add(la2);
        l9.setBounds(25, 220, 200, 20);
        t8.setBounds(115, 220, 80, 25);
        ep2.add(t8);
        ep2.add(l9);
        l10.setBounds(300, 220, 200, 20);
        t9.setBounds(400, 220, 80, 25);
        ep2.add(t9);
        ep2.add(l10);
        l11.setBounds(550, 220, 200, 20);
        t10.setBounds(670, 220, 80, 25);
        ep2.add(t10);
        ep2.add(l11);
        l12.setBounds(25, 270, 200, 20);
        t11.setBounds(135, 270, 80, 25);
        ep2.add(t11);
        ep2.add(l12);

        //membership
        la3.setBounds(10, 320, 200, 20);
        la3.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep2.add(la3);
        l13.setBounds(25, 360, 200, 20);
        t12.setBounds(125, 360, 200, 22);
        ep2.add(t12);
        ep2.add(l13);
        l22.setBounds(350, 360, 200, 20);
        jb1.addItem("One Month");
        jb1.addItem("Three Month");
        jb1.addItem("Six Month");
        jb1.addItem("One Year");
        jb1.setBounds(488, 360, 150, 22);
        ep2.add(jb1);
        ep2.add(l22);
        l14.setBounds(660, 360, 150, 20);
        t13.setBounds(740, 360, 200, 22);
        ep2.add(t13);
        ep2.add(l14);
        l15.setBounds(25, 410, 150, 20);
        t14.setBounds(130, 410, 100, 22);
        ep2.add(t14);
        ep2.add(l15);
        l16.setBounds(270, 410, 100, 20);
        t15.setBounds(355, 410, 100, 22);
        ep2.add(t15);
        ep2.add(l16);
        l17.setBounds(500, 410, 100, 20);
        t16.setBounds(600, 410, 100, 22);
        ep2.add(t16);
        ep2.add(l17);
        l23.setBounds(25, 460, 150, 20);
        jb2.addItem("Cash");
        jb2.addItem("Cheque");
        jb2.addItem("Online");
        jb2.addItem("Card");
        jb2.setBounds(160, 460, 100, 22);
        ep2.add(jb2);
        ep2.add(l23);

        //admin area
        la4.setBounds(10, 510, 300, 20);
        la4.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep2.add(la4);
        l18.setBounds(25, 560, 100, 20);
        t17.setBounds(110, 560, 100, 22);
        ep2.add(t17);
        ep2.add(l18);
        l19.setBounds(300, 560, 100, 20);
        t18.setBounds(380, 560, 150, 22);
        ep2.add(t18);
        ep2.add(l19);
        l20.setBounds(600, 560, 100, 20);
        jb3.addItem("Member");
        jb3.addItem("Admin");
        jb3.setBounds(650, 560, 100, 22);
        ep2.add(jb3);
        ep2.add(l20);
        l21.setBounds(25, 610, 100, 20);
        t19.setBounds(120, 610, 250, 22);
        ep2.add(t19);
        ep2.add(l21);

        //button on add member
        b.setBounds(400, 680, 120, 25);
        b.setActionCommand("click1");
        b.addActionListener(new click());
        ep2.add(b);


        //equipments
        tab.addTab("Equipment", s3);
        ep3.setEditable(false);
        try {
            ep3.setPage(url1);
        } catch (IOException e) {
            ep3.setContentType("text/html");
            ep3.setText("<html>Page not found.</html>");
        }
//change password page
        tab.addTab("Change Password", s4);
        b1.addActionListener(new click1());
        b1.setActionCommand("click2");
        lab.setBounds(120, 150, 200, 30);
        lab.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep4.add(lab);
        lab1.setBounds(145, 220, 150, 30);
        lab1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep4.add(lab1);
        lb2.setBounds(115, 290, 300, 30);
        lb2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        ep4.add(lb2);
        jt.setBounds(300, 150, 300, 30);
        ep4.add(jt);
        jt1.setBounds(300, 220, 300, 30);
        ep4.add(jt1);
        jt2.setBounds(300, 290, 300, 30);
        ep4.add(jt2);
        b1.setBounds(300, 360, 300, 30);
        ep4.add(b1);


        ep4.setEditable(false);
        ep4.setBackground(Color.pink);
        ep1.setBackground(Color.pink);
        ep3.setBackground(Color.pink);
    }


    private class click1 implements ActionListener {
        public void actionPerformed(ActionEvent ea) {
            login log = new login();
            //change pass
            String old_pass = jt.getText();
            String new_pass = jt1.getText();
            String re_pass = jt2.getText();
            String query2 = "UPDATE `login` SET `pass`='" + new_pass + "' WHERE `pass`='" + old_pass + "';";
            String query3 = "UPDATE `add_member` SET `pass`='" + new_pass + "' WHERE `pass`='" + old_pass + "';";
            Statement st1 = null;
            if (ea.getActionCommand().equals("click2")) {
                if (new_pass.equals(re_pass)) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");

                        st1 = con1.createStatement();
                        int res = st1.executeUpdate(query2);
                        int res1 = st1.executeUpdate(query3);
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Password Updated!");
                            log.launch();
                            f.setVisible(false);
                        }

                    } catch (SQLException | ClassNotFoundException sqlException) {
                        sqlException.printStackTrace();

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password didn't match!");

                }
            } else if (ea.getActionCommand().equals("click3")) {
                log.launch();
                f.setVisible(false);
            }
        }
    }


    private class click implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //personal info
            String name = t1.getText();
            String age = t2.getText();
            String gender = jb.getSelectedItem().toString();
            String dob = t3.getText();
            String contact = t4.getText();
            String email = t5.getText();
            String t_address = t6.getText();
            String p_address = t7.getText();

            //body info
            String height = t8.getText();
            String weight = t9.getText();
            String chest = t10.getText();
            String belly = t11.getText();

            //membership info
            String j_date = t12.getText();
            String membership = jb1.getSelectedItem().toString();
            String e_date = t13.getText();
            String total = t14.getText();
            String paid = t15.getText();
            String due1 = t16.getText();
            String p_method = jb2.getSelectedItem().toString();

            //admin area
            String username = t17.getText();
            String pass = t18.getText();
            String role = jb3.getSelectedItem().toString();
            String staff = t19.getText();

            String query1 = "INSERT INTO login values('" + username + "','" + pass + "','" + role + "');";
            String query2="INSERT INTO "+username+" values('1','"+height+"','"+weight+"','"+chest+"','"+belly+"');";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");


                PreparedStatement st1 = con.prepareStatement("CREATE TABLE  "+username+" (month varchar(20),height varchar(20),weight varchar(10),chest varchar(10),belly varchar(10))");
                st1.execute();
                PreparedStatement st4 = con.prepareStatement(query2);
                st4.execute();
                PreparedStatement st2 = con.prepareStatement("INSERT INTO `add_member`(`name`, `age`, `gender`, `dob`, `contact`, `email`, `t_address`, `p_address`, `height`, `weight`, `chest`, `belly`, `j_date`, `membership`, `e_date`, `total`, `paid`, `due`, `p_method`, `username`, `pass`, `role`, `staff`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st2.setString(1,name);
                st2.setString(2,age);
                st2.setString(3,gender);
                st2.setString(4,dob);
                st2.setString(5,contact);
                st2.setString(6,email);
                st2.setString(7,t_address);
                st2.setString(8,p_address);
                st2.setString(9,height);
                st2.setString(10,weight);
                st2.setString(11,chest);
                st2.setString(12,belly);
                st2.setString(13,j_date);
                st2.setString(14,membership);
                st2.setString(15,e_date);
                st2.setString(16,total);
                st2.setString(17,paid);
                st2.setString(18,due1);
                st2.setString(19,p_method);
                st2.setString(20,username);
                st2.setString(21,pass);
                st2.setString(22,role);
                st2.setString(23,staff);
                st2.execute();
                PreparedStatement st3 = con.prepareStatement(query1);
                st3.execute();
                JOptionPane.showMessageDialog(b, "SUBMITTED");

            } catch (SQLException | ClassNotFoundException sqlException) {
                sqlException.printStackTrace();
            }
        }


    }


    private class ClientsTableRenderer extends DefaultCellEditor {
        private member_info mem = new member_info();
        private JButton button;
        private String label;
        private boolean clicked;
        private int row, col;
        private JTable table;

        public ClientsTableRenderer(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;
            this.col = column;

            button.setForeground(Color.black);
            button.setBackground(UIManager.getColor("Button.background"));
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            clicked = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (clicked) {
                String a = (String) table.getValueAt(row, 1);
                String b=(String) table.getValueAt(row,0);
                mem.info(a,b);
                f.setVisible(false);

            }
            clicked = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}


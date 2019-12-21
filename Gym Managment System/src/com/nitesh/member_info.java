package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class member_info {
    private admin ad=new admin();
    String usrid = new String();
    String name = new String();
    private JFrame f = new JFrame();
    private progress_admin pad=new progress_admin();

    //panels
    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();

    //lables
    private JLabel la = new JLabel();

    //buttons
    private JButton b1 = new JButton("Back");
    private JButton b2 = new JButton("Update");
    private JButton b3 = new JButton("Delete");
    private JButton b4 = new JButton("Progress");

    //lable personal info
    private JLabel la1 = new JLabel("Personal Information:-");
    private JLabel l1 = new JLabel("Age:-");
    private JLabel l2 = new JLabel("Gender:-");
    private JLabel l3 = new JLabel("Date Of Birth:-");
    private JLabel l4 = new JLabel("Contact No:-");
    private JLabel l5 = new JLabel("Temporary Address:-");
    private JLabel l6 = new JLabel("Permanent Address:-");

    //textfiels od personal info
    private JTextField t1 = new JTextField();
    private JComboBox<String> jb = new JComboBox<String>();
    private JTextField t3 = new JTextField();
    private JTextField t4 = new JTextField();
    private JTextField t5 = new JTextField();
    private JTextField t6 = new JTextField();

    //lables of body info
    private JLabel la2 = new JLabel("Body Information:-");
    private JLabel l7 = new JLabel("Height (Ft);-");
    private JLabel l8 = new JLabel("Weight (Kg):-");
    private JLabel l9 = new JLabel("Chest Size (In):-");
    private JLabel l10 = new JLabel("Belly Size (In):-");
    //textfield of body
    private JTextField t7 = new JTextField();
    private JTextField t8 = new JTextField();
    private JTextField t9 = new JTextField();
    private JTextField t10 = new JTextField();

    //lable membership type
    private JLabel la3 = new JLabel("Payments:-");
    private JLabel l11 = new JLabel("Total Amount:-");
    private JLabel l12 = new JLabel("Total Paid:-");
    private JLabel l13 = new JLabel("Due Amount:-");
    private JLabel l14 = new JLabel("Payment Method:-");
    private JLabel l16 = new JLabel("Membership Type:-");
    private JComboBox<String> jb1 = new JComboBox<String>();
    private JComboBox<String> jb2 = new JComboBox<String>();
    //textfield of member
    private JTextField t11 = new JTextField();
    private JTextField t12 = new JTextField();
    //private JTextField t13=new JTextField();
    private JTextField t14 = new JTextField();

    //lable verified by
    private JLabel la4 = new JLabel("Verified By:-");
    private JLabel l15 = new JLabel("Staff Name:-");

    private JTextField t15 = new JTextField();


    public void info(String a, String b) {
        usrid = a;
        name = b;
        f.setSize(1000, 900);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel for header
        p.setLayout(null);
        p.setBounds(5, 5, 990, 150);
        p.setBackground(Color.BLUE);
        la.setText(b);
        la.setBounds(80, 50, 800, 70);
        la.setFont(new Font("TimesRoman", Font.BOLD, 60));
        la.setForeground(Color.WHITE);
        b1.setBounds(820, 60, 130, 40);
        b1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        b1.addActionListener(new click());
        p.add(b1);
        p.add(la);
        f.add(p);

        //panel for button
        p1.setLayout(null);
        p1.setBackground(Color.BLUE);
        p1.setBounds(795, 158, 200, 705);
        b2.setBounds(25, 300, 150, 40);
        b2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        b2.addActionListener(new click());
        b3.setBounds(25, 460, 150, 40);
        b3.setFont(new Font("TimesRoman", Font.BOLD, 20));
        b3.addActionListener(new click());
        b4.setBounds(25, 150, 150, 40);
        b4.setFont(new Font("TimesRoman", Font.BOLD, 20));
        b4.addActionListener(new click());
        p1.add(b4);
        p1.add(b3);
        p1.add(b2);
        f.add(p1);

        //panel for info
        p2.setLayout(null);
        p2.setBackground(Color.PINK);
        p2.setBounds(5, 158, 785, 705);
        f.add(p2);

        //personal info
        la1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        la1.setBounds(10, 3, 200, 30);
        l1.setBounds(25, 43, 100, 20);
        l2.setBounds(320, 43, 100, 20);
        l3.setBounds(25, 90, 100, 20);
        l4.setBounds(360, 90, 200, 20);
        l5.setBounds(25, 137, 200, 20);
        l6.setBounds(390, 137, 150, 20);
        t1.setBounds(70, 43, 100, 22);
        jb.addItem("Male");
        jb.addItem("Female");
        jb.setBounds(390, 43, 100, 22);
        t3.setBounds(130, 90, 150, 22);
        t4.setBounds(450, 90, 250, 22);
        t5.setBounds(175, 137, 200, 22);
        t6.setBounds(540, 137, 240, 22);
        p2.add(t1);
        p2.add(jb);
        p2.add(t3);
        p2.add(t4);
        p2.add(t5);
        p2.add(t6);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(l6);
        p2.add(la1);


//body info
        la2.setBounds(10, 180, 200, 30);
        la2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        l7.setBounds(25, 220, 200, 20);
        l8.setBounds(300, 220, 200, 20);
        l9.setBounds(550, 220, 200, 20);
        l10.setBounds(25, 270, 200, 20);
        t7.setBounds(115, 220, 80, 25);
        t8.setBounds(400, 220, 80, 25);
        t9.setBounds(670, 220, 80, 25);
        t10.setBounds(135, 270, 80, 25);
        p2.add(t7);
        p2.add(t8);
        p2.add(t9);
        p2.add(t10);
        p2.add(l7);
        p2.add(l8);
        p2.add(l9);
        p2.add(l10);
        p2.add(la2);


        //payments
        la3.setBounds(10, 320, 200, 20);
        la3.setFont(new Font("TimesRoman", Font.BOLD, 15));
        l11.setBounds(25, 360, 200, 20);
        t11.setBounds(135, 360, 200, 22);
        l12.setBounds(400, 360, 200, 20);
        t12.setBounds(485, 360, 150, 22);
        l13.setBounds(310, 410, 100, 20);
        jb2.addItem("Cash");
        jb2.addItem("Cheque");
        jb2.addItem("Online");
        jb2.addItem("Card");
        jb2.setBounds(160, 410, 100, 22);
        l14.setBounds(25, 410, 150, 20);
        t14.setBounds(415, 410, 100, 22);
        l16.setBounds(25, 460, 150, 20);
        jb1.addItem("One Month");
        jb1.addItem("Three Month");
        jb1.addItem("Six Month");
        jb1.addItem("One Year");
        jb1.setBounds(160, 460, 120, 22);
        p2.add(jb1);
        p2.add(t11);
        p2.add(t12);
        p2.add(jb2);
        p2.add(t14);
        p2.add(l11);
        p2.add(l12);
        p2.add(l13);
        p2.add(l14);
        p2.add(l16);
        p2.add(la3);


        //verified staff
        la4.setBounds(10, 510, 300, 20);
        la4.setFont(new Font("TimesRoman", Font.BOLD, 15));
        l15.setBounds(25, 560, 100, 20);
        t15.setBounds(120, 560, 150, 22);
        p2.add(t15);
        p2.add(l15);
        p2.add(la4);


        //display data on table
        String query = "SELECT age,gender,dob,contact,t_address,p_address,height,weight,chest,belly,total,paid,p_method,due,membership,staff FROM add_member;";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
            System.out.println("connection done");
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                t1.setText(rs.getString("age"));
                jb.setSelectedItem(rs.getString("gender"));
                t3.setText(rs.getString("dob"));
                t4.setText(rs.getString("contact"));
                t5.setText(rs.getString("t_address"));
                t6.setText(rs.getString("p_address"));
                t7.setText(rs.getString("height"));
                t8.setText(rs.getString("weight"));
                t9.setText(rs.getString("chest"));
                t10.setText(rs.getString("belly"));
                t11.setText(rs.getString("total"));
                t12.setText(rs.getString("paid"));
                jb2.setSelectedItem(rs.getString("p_method"));
                t14.setText(rs.getString("due"));
                jb1.setSelectedItem(rs.getString("membership"));
                t15.setText(rs.getString("staff"));

            }
        } catch (Exception ex) {
        }




    }


    private class click implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //personal info
            String age = t1.getText();
            String gender = jb.getSelectedItem().toString();
            String dob = t3.getText();
            String contact = t4.getText();
            String t_address = t5.getText();
            String p_address = t6.getText();

            //body info
            String height = t7.getText();
            String weight = t8.getText();
            String chest = t9.getText();
            String belly = t10.getText();

            //membership info
            String membership = jb1.getSelectedItem().toString();
            String total = t11.getText();
            String paid = t12.getText();
            String due1 = t14.getText();
            String p_method = jb2.getSelectedItem().toString();

            //admin area
            String staff = t15.getText();


if(e.getSource() == b2)
       {

String a=usrid;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
                PreparedStatement st = con.prepareStatement("UPDATE add_member set age=?,gender=?,dob=?,contact=?,t_address=?,p_address=?,height=?,weight=?,chest=?,belly=?,membership=?,total=?,paid=?,due=?,p_method=?,staff=? WHERE username=?");
                st.setString(1, age);
                st.setString(2, gender);
                st.setString(3, dob);
                st.setString(4, contact);
                st.setString(5, t_address);
                st.setString(6, p_address);
                st.setString(7, height);
                st.setString(8, weight);
                st.setString(9, chest);
                st.setString(10, belly);
                st.setString(11, membership);
                st.setString(12, total);
                st.setString(13, paid);
                st.setString(14, due1);
                st.setString(15, p_method);
                st.setString(16, staff);
                st.setString(17, a);
                st.execute();

                JOptionPane.showMessageDialog(b2, "Updated");

            } catch (SQLException | ClassNotFoundException sqlException) {
                sqlException.printStackTrace();
            }
        }

     else if(e.getSource() == b1)
            {

                ad.show();
                f.setVisible(false);

              }
     else if(e.getSource() == b3){
         String usr=usrid;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
        PreparedStatement st = con.prepareStatement("DELETE FROM add_member WHERE username ='"+usr+"'");
        st.execute();
        PreparedStatement st1 = con.prepareStatement("DELETE FROM login WHERE usr ='"+usr+"'");
        st1.execute();
        PreparedStatement st2 = con.prepareStatement("DROP TABLE "+usr+"");
        st2.execute();
        JOptionPane.showMessageDialog(b3, "Deleted");
        ad.show();
        f.setVisible(false);

    } catch (SQLException | ClassNotFoundException sqlException) {
        sqlException.printStackTrace();
    }
     }


     else if(e.getSource()==b4){

        pad.progress(usrid,name);
        f.setVisible(false);

     }
        }


    }

}
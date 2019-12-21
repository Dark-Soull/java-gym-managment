package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class membership {
           private JFrame fr=new JFrame("Member");
           private progress_member progress=new progress_member();

           private JPanel p = new JPanel();
           //panel button
           private JButton b2=new JButton("LogOut");
           private JButton b3=new JButton("Progress");

           private JTabbedPane tab = new JTabbedPane();
           private URL url= admin.class.getResource("dashboard_admin.html");
           private URL url1=admin.class.getResource("equipment.html");
           private JEditorPane ep = new JEditorPane();
           private JEditorPane ep1=new JEditorPane();
           private JEditorPane ep2=new JEditorPane();
           private JEditorPane ep3=new JEditorPane();
           private JScrollPane s = new JScrollPane(ep1);
           private  JScrollPane s1=new JScrollPane(ep);
           private  JScrollPane s2=new JScrollPane(ep2);
           private JScrollPane s3=new JScrollPane(ep3);

           //panel for member info
           private JPanel p1=new JPanel();
           private JPanel p2=new JPanel();
           private JPanel p3=new JPanel();

           private JLabel la1=new JLabel();
           private JLabel la=new JLabel("welcome");
           private JLabel l1= new JLabel("Member Name:-");
           private JLabel l2 = new JLabel("Address:-");
           private JLabel l3= new JLabel("Age:-");
           private JLabel l4= new JLabel("Contact No:-");
           private JLabel l5 = new JLabel("Email:-");

           private JTextField t1 = new JTextField();
           private JTextField t2= new JTextField();
           private JTextField t3 = new JTextField();
           private JTextField t4 = new JTextField();
           private JTextField t5 = new JTextField();

           //lable for membership
           private JLabel l6=new JLabel("Membership Type:-");
           private JLabel l7=new JLabel("Joined Date:-");
           private JLabel l8=new JLabel("End Date:-");
           private JLabel l9=new JLabel("Total Amount:-");
           private JLabel l10=new JLabel("Paid Amount:-");
           private JLabel l11=new JLabel("Due Amount:-");
           private JLabel l12=new JLabel("Payment Method:-");
    private JTextField t6 = new JTextField();
    private JTextField t7 = new JTextField();
    private JTextField t8 = new JTextField();
    private JTextField t9 = new JTextField();
    private JTextField t10 = new JTextField();
    private JTextField t11= new JTextField();
    private JTextField t12= new JTextField();

           //lable for body info
           private JLabel l13=new JLabel("Height:-");
    private JLabel l14=new JLabel("Weight:-");
    private JLabel l15=new JLabel("Chest:-");
    private JLabel l16=new JLabel("Belly:-");
    private JTextField t13 = new JTextField();
    private JTextField t14 = new JTextField();
    private JTextField t15= new JTextField();
    private JTextField t16 = new JTextField();


           String a,b;
//change pass
    private JLabel lab = new JLabel("Current Password:-");
    private JLabel lab1 = new JLabel("New Password:-");
    private JLabel lb2 = new JLabel("Re-Enter Password:-");
    private JTextField jt = new JTextField();
    private JTextField jt1 = new JTextField();
    private JTextField jt2 = new JTextField();
    private JButton b1=new JButton("Change Password");

    public void value(String usr){
        a=usr;
    }

           public  void bound(){
               fr.setSize(1020,610);
               fr.add(tab);
               fr.add(p);
               fr.setLayout(null);
               fr.setVisible(true);
               fr.setResizable(false);
               fr.setLocationRelativeTo(null);
               fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//header panel
               p.setSize(1010,100);
               p.setLayout(null);
               p.setLocation(5,5);
               p.setBackground(Color.BLUE);

            String usrid=a;
               String query = "SELECT name FROM add_member WHERE username="+usrid+";";
               Connection con = null;
               Statement st = null;
               ResultSet rs = null;
               try {
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
                   st = con.createStatement();
                   rs = st.executeQuery("SELECT name FROM add_member WHERE username= '"+usrid+"' ");
                   while (rs.next()) {
                       b=rs.getString("name");
                       la1.setText(b);
                   }
               }
            catch (Exception ex) {
    }
//header lable and panel
           la1.setFont(new Font("TimesRoman",Font.BOLD,60));
           la1.setForeground(Color.WHITE);
           la1.setBounds(350,20,800,60);
           p.add(la1);
           la.setFont(new Font("TimesRoman", Font.BOLD, 60));
               la.setForeground(Color.WHITE);
               la.setBounds(30,20,500,60);
              p.add(la);
               //logout button
               b2.setBounds(880, 30, 100, 40);
               b2.setFont(new Font("TimesRoman", Font.BOLD, 16));
               b2.setBackground(Color.RED);
               b2.addActionListener(new click());
               b2.setActionCommand("click1");
               p.add(b2);
               //progress button
               b3.setBounds(740, 30, 130, 40);
               b3.setFont(new Font("TimesRoman", Font.BOLD, 16));
               b3.setBackground(Color.GREEN);
               b3.addActionListener(new click());
               b3.setActionCommand("click3");
               p.add(b3);


//tab
               tab.setBounds(8,90,1008,480);


               //dashboard
               tab.addTab("Dashboard",s);
               ep1.setEditable(false);
               try {
                   ep1.setPage(url);
               } catch (IOException e) {
                   ep1.setContentType("text/html");
                   ep1.setText("<html>Page not found.</html>");
               }



//member & membership
               tab.addTab("Member And Membership",s1);
               ep.setEditable(false);
               p1.setLayout(null);
               p1.setBounds(0,0,500,250);
               ep.add(p1);
               l1.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l1.setForeground(Color.BLACK);
               l1.setBounds(20,30,150,25);
               t1.setBounds(170,30,270,25);
               t1.setEditable(false);
               l2.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l2.setForeground(Color.BLACK);
               l2.setBounds(20,70,150,25);
               t2.setBounds(110,70,270,25);
               t2.setEditable(false);
               l3.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l3.setForeground(Color.BLACK);
               l3.setBounds(20,110,150,25);
               t3.setBounds(80,110,270,25);
               t3.setEditable(false);
               l4.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l4.setForeground(Color.BLACK);
               l4.setBounds(20,150,150,25);
               t4.setBounds(130,150,270,25);
               t4.setEditable(false);
               l5.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l5.setForeground(Color.BLACK);
               l5.setBounds(20,190,150,25);
               t5.setBounds(100,190,270,25);
               t5.setEditable(false);
               p1.add(l1);
               p1.add(t1);
               p1.add(l2);
               p1.add(t2);
               p1.add(l3);
               p1.add(t3);
               p1.add(l4);
               p1.add(t4);
               p1.add(l5);
               p1.add(t5);
               p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Member Info"));


               //membership panel
               p2.setLayout(null);
               p2.setBounds(500,0,500,450);
               p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Membership Info"));
              l6.setBounds(20,30,200,20);
              l6.setForeground(Color.BLACK);
              l6.setFont(new Font("TimesRoman", Font.BOLD, 15));
              t6.setBounds(190,30,270,25);
              t6.setEditable(false);
              l7.setFont(new Font("TimesRoman", Font.BOLD, 15));
              l7.setForeground(Color.BLACK);
              l7.setBounds(20,70,200,20);
              t7.setBounds(140,70,270,25);
              t7.setEditable(false);
              l8.setFont(new Font("TimesRoman", Font.BOLD, 15));
              l8.setForeground(Color.BLACK);
              l8.setBounds(20,120,200,20);
              t8.setBounds(120,120,270,25);
              t8.setEditable(false);
              l9.setFont(new Font("TimesRoman", Font.BOLD, 15));
              l9.setForeground(Color.BLACK);
              l9.setBounds(20,180,200,20);
              t9.setBounds(155,180,275,25);
              t9.setEditable(false);
              l10.setFont(new Font("TimesRoman", Font.BOLD, 15));
              l10.setForeground(Color.BLACK);
              l10.setBounds(20,240,200,20);
              t10.setBounds(145,240,275,25);
              t10.setEditable(false);
              l11.setFont(new Font("TimesRoman", Font.BOLD, 15));
              l11.setForeground(Color.BLACK);
              l11.setBounds(20,310,200,20);
              t11.setBounds(145,310,275,25);
              t11.setEditable(false);
              l12.setFont(new Font("TimesRoman", Font.BOLD, 15));
              l12.setForeground(Color.BLACK);
              l12.setBounds(20,380,200,20);
              t12.setBounds(180,380,275,25);
              t12.setEditable(false);
              p2.add(t6);
               p2.add(t7);
               p2.add(t8);
               p2.add(t9);
               p2.add(t10);
               p2.add(t11);
               p2.add(t12);
              p2.add(l6);
               p2.add(l7);
               p2.add(l8);
               p2.add(l9);
               p2.add(l10);
               p2.add(l11);
               p2.add(l12);
               ep.add(p2);

               //body info panel
               p3.setLayout(null);
               p3.setBounds(0,250,500,200);
               p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Body Info"));
               ep.add(p3);
               l13.setBounds(20,30,200,20);
               t13.setBounds(100,30,275,25);
               t13.setEditable(false);
               l13.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l13.setForeground(Color.BLACK);
               l14.setBounds(20,70,200,20);
               t14.setBounds(100,70,275,25);
               t14.setEditable(false);
               l14.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l14.setForeground(Color.BLACK);
               l15.setBounds(20,110,200,20);
               t15.setBounds(90,110,275,25);
               t15.setEditable(false);
               l15.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l15.setForeground(Color.BLACK);
               l16.setBounds(20,150,200,20);
               t16.setBounds(90,150,275,25);
               t16.setEditable(false);
               l16.setFont(new Font("TimesRoman", Font.BOLD, 15));
               l16.setForeground(Color.BLACK);
               p3.add(t13);
               p3.add(t14);
               p3.add(t15);
               p3.add(t16);
               p3.add(l13);
               p3.add(l14);
               p3.add(l15);
               p3.add(l16);

               // data getting
               String aa=a;
               String query1 = "SELECT name,t_address,age,contact,email,membership,j_date,e_date,total,paid,due,p_method,height,weight,chest,belly FROM add_member WHERE username= '"+aa+"' ";
               Connection con1 = null;
               Statement st1 = null;
               ResultSet rs1 = null;
               try {
                   Class.forName("com.mysql.jdbc.Driver");
                   con1 = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
                   System.out.println("connection done");
                   st1 = con1.createStatement();
                   rs1 = st1.executeQuery(query1);
                   System.out.println("connection done");
                   while (rs1.next()) {
                       t1.setText(rs1.getString("name"));
                       t2.setText(rs1.getString("t_address"));
                       t3.setText(rs1.getString("age"));
                       t4.setText(rs1.getString("contact"));
                       t5.setText(rs1.getString("email"));
                       t6.setText(rs1.getString("membership"));
                       t7.setText(rs1.getString("j_date"));
                       t8.setText(rs1.getString("e_date"));
                       t9.setText(rs1.getString("total"));
                       t10.setText(rs1.getString("paid"));
                       t11.setText(rs1.getString("due"));
                       t12.setText(rs1.getString("p_method"));
                       t13.setText(rs1.getString("height"));
                       t14.setText(rs1.getString("weight"));
                       t15.setText(rs1.getString("chest"));
                       t16.setText(rs1.getString("belly"));

                   }
               } catch (Exception ex) {
               }


               //progress
               tab.addTab("Equipments",s2);
               ep2.setEditable(false);
               try {
                   ep2.setPage(url1);
               } catch (IOException e) {
                   ep2.setContentType("text/html");
                   ep2.setText("<html>Page not found.</html>");
               }

               //change password
               tab.addTab("Change Password", s3);
               lab.setBounds(120, 100, 200, 30);
               lab.setFont(new Font("TimesRoman", Font.BOLD, 15));
               ep3.add(lab);
               lab1.setBounds(145, 170, 150, 30);
               lab1.setFont(new Font("TimesRoman", Font.BOLD, 15));
               ep3.add(lab1);
               lb2.setBounds(115, 240, 300, 30);
               lb2.setFont(new Font("TimesRoman", Font.BOLD, 15));
               ep3.add(lb2);
               jt.setBounds(300, 100, 300, 30);
               ep3.add(jt);
               jt1.setBounds(300, 170, 300, 30);
               ep3.add(jt1);
               jt2.setBounds(300, 240, 300, 30);
               ep3.add(jt2);
               b1.setBounds(300, 300, 300, 30);
               ep3.add(b1);
               b1.addActionListener(new click());
               b1.setActionCommand("click2");
               ep3.setEditable(false);





           }



    private class click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            login log = new login();
            String usrid=a;
            //change pass
            String old_pass = jt.getText();
            String new_pass = jt1.getText();
            String re_pass = jt2.getText();
            String query2 = "UPDATE `login` SET `pass`='" + new_pass + "' WHERE `pass`='" + old_pass + "';";
            String query3 = "UPDATE `add_member` SET `pass`='" + new_pass + "' WHERE `pass`='" + old_pass + "';";
            Statement st1 = null;
            if (e.getActionCommand().equals("click2")) {
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
                            fr.setVisible(false);
                        }

                    } catch (SQLException | ClassNotFoundException sqlException) {
                        sqlException.printStackTrace();
                    }

                }
            }
            else if (e.getActionCommand().equals("click1")) {
                log.launch();
                fr.setVisible(false);
            }

            else if (e.getActionCommand().equals("click3")) {
                progress.value(usrid);
                progress.progress();
                fr.setVisible(false);
            }

        }
    }

}

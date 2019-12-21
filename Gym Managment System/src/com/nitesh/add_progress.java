package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class add_progress {
    private JFrame f=new JFrame("Add Progress");
    private JPanel p=new JPanel();
    private JPanel p1=new JPanel();
    private JLabel la=new JLabel();
    private JLabel l1=new JLabel("Month:-");
    private  JLabel l2=new JLabel("Height:-");
    private  JLabel l3=new JLabel("Weight:-");
    private  JLabel l4=new JLabel("Chest:-");
    private  JLabel l5=new JLabel("Belly:-");
    private JTextField t1=new JTextField();
    private JTextField t2=new JTextField();
    private JTextField t3=new JTextField();
    private JTextField t4=new JTextField();
    private JTextField t5=new JTextField();
    private JButton b1=new JButton("Submit");
    String usrid;
    String usrname;

    public void add(String a,String b)
    {
        usrid=a;
        usrname=b;
        f.setSize(500,600);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //panel
        p.setLayout(null);
        p.setBackground(Color.BLUE);
        p.setBounds(5,5,490,100);
        la.setText(b);
        la.setForeground(Color.WHITE);
        la.setFont(new Font("TimesRoman",Font.BOLD,40));
        la.setBounds(20,20,300,60);
        p.add(la);
        f.add(p);


        //panel 2
        p1.setLayout(null);
        p1.setBounds(5,110,490,450);
        p1.setBackground(Color.PINK);
        f.add(p1);

        l1.setBounds(40,40,100,25);
        l1.setFont(new Font("TimesRoman",Font.BOLD,20));
        t1.setBounds(140,40,200,25);
        p1.add(t1);
        p1.add(l1);

        l2.setBounds(40,100,100,25);
        l2.setFont(new Font("TimesRoman",Font.BOLD,20));
        t2.setBounds(140,100,200,25);
        p1.add(t2);
        p1.add(l2);

        l3.setBounds(40,160,100,25);
        l3.setFont(new Font("TimesRoman",Font.BOLD,20));
        t3.setBounds(140,160,200,25);
        p1.add(t3);
        p1.add(l3);

        l4.setBounds(40,220,100,25);
        l4.setFont(new Font("TimesRoman",Font.BOLD,20));
        t4.setBounds(140,220,200,25);
        p1.add(t4);
        p1.add(l4);

        l5.setBounds(40,280,100,25);
        l5.setFont(new Font("TimesRoman",Font.BOLD,20));
        t5.setBounds(140,280,200,25);
        p1.add(t5);
        p1.add(l5);


        b1.setBounds(140,340,200,25);
        b1.setFont(new Font("TimesRoman",Font.BOLD,20));
        p1.add(b1);
        b1.addActionListener(new click());

    }

    private class click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==b1) {

                String usr=usrid;
                String month=t1.getText();
                String height=t2.getText();
                String weight=t3.getText();
                String chest=t4.getText();
                String belly=t5.getText();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
                    PreparedStatement st = con.prepareStatement("INSERT into "+usr+" values('"+month+"','"+height+"','"+weight+"','"+chest+"','"+belly+"')");
                     st.execute();
                    JOptionPane.showMessageDialog(b1, "SUBMITTED");
                    f.setVisible(false);

                } catch (Exception ex) {
                }

            }

        }
        }

}

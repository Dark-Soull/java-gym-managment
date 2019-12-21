package com.nitesh;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class progress_member {
    membership member;
    private JFrame f=new JFrame("Progress");
    private  JPanel p=new JPanel();
    private JLabel la=new JLabel();
    private JButton b1=new JButton("Back");

    private JPanel ep=new JPanel();
    JTable table = new JTable();
    private JScrollPane s=new JScrollPane(table);
    DefaultTableModel model = new DefaultTableModel();
    String[] ColumnName ={"Month","Height (Ft)","Weight (Kg)","Chest (In)","Belly (In)"};
    String usrid;

    public void value(String a){usrid=a;}

    public void progress(){
        f.setSize(700,600);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //panel
        p.setBounds(5,5,690,100);
        p.setLayout(null);
        p.setBackground(Color.BLUE);
        la.setForeground(Color.WHITE);
        la.setFont(new Font("TimesRoman",Font.BOLD,60));
        la.setText(usrid);
        la.setBounds(50,20,300,50);
        b1.setBounds(550, 30, 100, 40);
        b1.setBackground(Color.RED);
        b1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        b1.addActionListener(new click());
        p.add(b1);
        p.add(la);
        f.add(p);
        //table
        table.setModel(model);
        table.setBounds(5, 200, 500, 500);
        table.setFillsViewportHeight(true);
        model.setColumnIdentifiers(ColumnName);
        s.setBounds(0,0,690,453);
        ep.setBackground(Color.PINK);
        ep.setLayout(null);
        ep.setBounds(5,110,690,453);
        ep.add(s);
        f.add(ep);
        String usr=usrid;

        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/gym1", "dark", "soul");
            PreparedStatement st = con.prepareStatement("SELECT * FROM "+usr+"");
            rs = st.executeQuery();

            while (rs.next()) {
                String col1=rs.getString("month");
                String col2 = rs.getString("height");
                String col3 = rs.getString("weight");
                String col4 = rs.getString("chest");
                String col5=rs.getString("belly");

                model.addRow(new Object[]{ col1,col2, col3, col4,col5});
            }
        } catch (Exception ex) {
        }
    }

    private class click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == b1)
            {
                //String aaa=usrid;
                member=new membership();
                member.value(usrid);
               member.bound();
                f.setVisible(false);

            }

        }
    }

}

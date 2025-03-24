package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class CalculateBill extends JFrame implements ActionListener {
    JLabel Name1,Address;
    JTextField unitsConsumed;
    Choice location,type,code,billType,metno,month;
    JButton next,cancel;
    String meternumber;
    CalculateBill(){
        this.meternumber = meternumber;
        // Frame Creation
        setSize(700,500);
        setLocation(400,150);

        // Panel Creation
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(174,216,230));
        add(p);

        // Heading New Customer
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(180,10,300,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);


        // Meter Number Auto generated
        JLabel MeterNo = new JLabel("Meter Number");
        MeterNo.setBounds(100,80,130,30);
        p.add(MeterNo);
        metno = new Choice();

        // to make the connection with the database
        try {
            Conn c = new Conn();
            // inorder to access the particular column from the database
            ResultSet rs =c.statement.executeQuery("select *from customer");
            while (rs.next()){
                metno.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        metno.setBounds(240,80,200,30);
        p.add(metno);


        // Name
        JLabel Name = new JLabel("Name");
        Name.setBounds(100,120,130,30);
        p.add(Name);
        // TextField
        Name1 = new JLabel();
        Name1.setBounds(245,120,130,30);
        p.add(Name1);

        // Meter Type Label
        JLabel MeterType = new JLabel("Address");
        MeterType.setBounds(100,160,130,30);
        p.add(MeterType);

        Address = new JLabel();
        Address.setBounds(245,160,200,30);
        p.add(Address);

        // for button use addEventListener and for choice use addItemListener
        metno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    ResultSet rs1 = c.statement.executeQuery("select * from customer where meter_no = '"+metno.getSelectedItem()+"'");
                    while (rs1.next()){
                        Name1.setText(rs1.getString("name"));
                        Address.setText(rs1.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //
        JLabel UnitsConsumed = new JLabel("Units Consumed");
        UnitsConsumed.setBounds(100,200,130,30);
        p.add(UnitsConsumed);
        unitsConsumed = new JTextField();
        unitsConsumed.setBounds(243,200,200,30);
        p.add(unitsConsumed);

        // Bill Type Label
        JLabel Month = new JLabel("Month");
        Month.setBounds(100,240,130,30);
        p.add(Month);
        month = new Choice();
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        month.setBounds(240,240,200,30);
        p.add(month);



        // Creating Button
        next = new JButton("Submit");
        next.setBounds(220,350,100,25);
//        next.setBackground(new Color(0, 0, 0));
//        next.setForeground(new Color(255, 255, 255));
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(340,350,100,25);
//        next.setBackground(new Color(0, 0, 0));
//        next.setForeground(new Color(255, 255, 255));
        cancel.addActionListener(this);
        p.add(cancel);


        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
    public static void main(String[] args) {
        new CalculateBill();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next){
            String meter = metno.getSelectedItem();
            String units = unitsConsumed.getText();
            String Month = month.getSelectedItem();

            int totalBill = 0;

            int unit_consumed = Integer.parseInt(units);
            String query1 = ("select * from tax");



            try{
                Conn c = new Conn();

                ResultSet rs = c.statement.executeQuery(query1);
                while (rs.next()){
                    totalBill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(rs.getString("meter_rent"));
                    totalBill += Integer.parseInt(rs.getString("service_charge"));
                    totalBill += Integer.parseInt(rs.getString("service_tax"));
                    totalBill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalBill += Integer.parseInt(rs.getString("fixed_tax"));

                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            String query2 = "insert into Bill values('"+meter+"','"+Month+"','"+units+"','"+totalBill+"','Not Paid')";

            try {
                Conn c = new Conn();
                c.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
}



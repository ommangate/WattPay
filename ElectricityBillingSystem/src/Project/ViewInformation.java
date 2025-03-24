package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {

    JButton cancel;
    String meter;
    ViewInformation(String meter){
        this.meter = meter;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("View customer Information");
        heading.setBounds(300,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(70,80,100,20);
        add(name);

        JLabel nameText = new JLabel("");
        nameText.setBounds(250,80,100,20);
        add(nameText);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(70,140,100,20);
        add(meterNumber);

        JLabel meterNumberText = new JLabel("");
        meterNumberText.setBounds(250,140,100,20);
        add(meterNumberText);

        JLabel address = new JLabel("Address");
        address.setBounds(70,200,100,20);
        add(address);

        JLabel addressText = new JLabel("");
        addressText.setBounds(250,200,100,20);
        add(addressText);

        JLabel city = new JLabel("City");
        city.setBounds(70,260,100,20);
        add(city);

        JLabel cityText = new JLabel("");
        cityText.setBounds(250,260,100,20);
        add(cityText);

        JLabel state = new JLabel("State");
        state.setBounds(500,80,100,20);
        add(state);

        JLabel stateText = new JLabel("");
        stateText.setBounds(670,80,100,20);
        add(stateText);

        JLabel email = new JLabel("Email");
        email.setBounds(500,140,100,20);
        add(email);

        JLabel emailText = new JLabel("");
        emailText.setBounds(670,140,100,20);
        add(emailText);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(500,200,100,20);
        add(phone);

        JLabel phoneText = new JLabel("");
        phoneText.setBounds(670,200,100,20);
        add(phoneText);

        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next()){
                nameText.setText(rs.getString("name"));
                meterNumberText.setText(rs.getString("meter_no"));
                addressText.setText(rs.getString("address"));
                cityText.setText(rs.getString("city"));
                stateText.setText(rs.getString("state"));
                emailText.setText(rs.getString("email"));
                phoneText.setText(rs.getString("phone"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setBounds(350,350,100,25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,350,600,300);
        add(image);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewInformation("");
    }

}

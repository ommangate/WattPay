package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField CustomerText,AddressText,CityText,StateText,emailText,PhoneNumberText;
    JButton next,cancel;
    JLabel Meter;
    NewCustomer(){
        // Frame Creation
        setSize(700,500);
        setLocation(400,200);

        // Panel Creation
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(174,216,230));
        add(p);

        // Heading New Customer
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        // Customer Name Label
        JLabel CustomerName = new JLabel("Customer Name");
        CustomerName.setBounds(100,80,130,20);
        p.add(CustomerName);
        // Customer Name TextField
        CustomerText = new JTextField();
        CustomerText.setBounds(240,80,200,20);
        p.add(CustomerText);


        // Meter Number Auto generated
        JLabel MeterNo = new JLabel("Meter Number");
        MeterNo.setBounds(100,120,130,20);
        p.add(MeterNo);
        Meter = new JLabel("");
        Meter.setBounds(242,120,150,20);
        p.add(Meter);

        Random ran = new Random(); // for generating random number
        long number = ran.nextLong()%1000000; // to get 6-digit number do % 1000000
        Meter.setText(""+Math.abs(number)); // Math.abs() for making number positive

        // Address Label
        JLabel Address = new JLabel("Address");
        Address.setBounds(100,160,130,20);
        p.add(Address);
        // Customer Name TextField
        AddressText = new JTextField();
        AddressText.setBounds(240,160,200,20);
        p.add(AddressText);

        // City Label
        JLabel City = new JLabel("City");
        City.setBounds(100,200,130,20);
        p.add(City);
        // Customer Name TextField
        CityText = new JTextField();
        CityText.setBounds(240,200,200,20);
        p.add(CityText);

        // State Label
        JLabel State = new JLabel("State");
        State.setBounds(100,240,130,20);
        p.add(State);
        // Customer Name TextField
        StateText = new JTextField();
        StateText.setBounds(240,240,200,20);
        p.add(StateText);

        // email Label
        JLabel email = new JLabel("email");
        email.setBounds(100,280,130,20);
        p.add(email);
        // Customer Name TextField
        emailText = new JTextField();
        emailText.setBounds(240,280,200,20);
        p.add(emailText);

        // Phone Number Label
        JLabel PhoneNumber = new JLabel("Phone Number");
        PhoneNumber.setBounds(100,320,130,20);
        p.add(PhoneNumber);
        // Customer Name TextField
        PhoneNumberText = new JTextField();
        PhoneNumberText.setBounds(240,320,200,20);
        p.add(PhoneNumberText);


        // Creating Button
        next = new JButton("Next");
        next.setBounds(120,390,100,25);
//        next.setBackground(new Color(0, 0, 0));
//        next.setForeground(new Color(255, 255, 255));
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
    public static void main(String[] args) {
        new NewCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next){
            String name = CustomerText.getText();
            String meter = Meter.getText();
            String address = AddressText.getText();
            String city = CityText.getText();
            String state = StateText.getText();
            String Email = emailText.getText();
            String phoneNo = PhoneNumberText.getText();

            String query1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+Email+"','"+phoneNo+"')";

            String query2 = "insert into login(meter_no,name) values('"+meter+"','"+name+"')";

            try{
                Conn c = new Conn();

                c.statement.executeUpdate(query1);
                c.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);

                new MeterInfo(meter);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
}

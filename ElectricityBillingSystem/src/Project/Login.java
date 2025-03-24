package Project;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,cancel,SignUn;
    JTextField userNameField,passField;
    Choice LoginIn;
    Login(){
        super("Login Page"); // Used to give heading to the page, and it must be the first statement in the constructor

        // changing the color of the frame
        getContentPane().setBackground(Color.WHITE); // getContentPane() - > gives the access of the entire frame

        // By default swing layout
        setLayout(null); // to stop the default layout placed by swing
        // now wee need to use setBound everywhere to avoid error

        // USERNAME
        // To write anything on the frame we use JLabel class
        JLabel userName = new JLabel("Username : ");
        userName.setBounds(300,20,100,20);// works when setLayout is null
        add(userName); // adding to the frame
        // JTextField is used to make text field/Area
        userNameField = new JTextField();
        userNameField.setBounds(400,20,150,20);
        add(userNameField);

        // PASSWORD
        JLabel password = new JLabel("Password : ");
        password.setBounds(300,60,100,20);// works when setLayout is null
        add(password); // adding to the frame
        // JTextField is used to make text field/Area
        passField = new JTextField();
        passField.setBounds(400,60,150,20);
        add(passField);

        // LOGIN AS
        JLabel loginAs = new JLabel("Longing In As : ");
        loginAs.setBounds(300,100,100,40);// works when setLayout is null
        add(loginAs); // adding to the frame

        // To make the drop-down option
        LoginIn = new Choice();
        LoginIn.add("Admin");
        LoginIn.add("Customer");
        LoginIn.setBounds(400,100,150,40);
        add(LoginIn);

        // To make the buttons
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        login = new JButton("Login",i3);
        login.setBounds(330,170,100,20);
        login.addActionListener(this);
        add(login);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        cancel = new JButton("Cancel",i6);
        cancel.setBounds(450,170,100,20);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i8 = i7.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        SignUn = new JButton("Signup",i9);
        SignUn.setBounds(390,200,100,20);
        SignUn.addActionListener(this);
        add(SignUn);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i11 = i10.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        JLabel image = new JLabel( new ImageIcon(i11));
        image.setBounds(0,0,250,250);
        add(image);


        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }

    @Override // after onclick of the button things inside this method would be executed
    public void actionPerformed(ActionEvent ae) { // ActionEvent - gives the information about which button is clicked
        if(ae.getSource()==login){
            String username = userNameField.getText();
            String pass = passField.getText();
            String user = LoginIn.getSelectedItem();

            try {
                Conn c= new Conn();
                String query = "select * from login where username ='"+username+"'and password = '"+pass+"' and user = '"+user+"' ";

                ResultSet resultSet = c.statement.executeQuery(query); // DDL command i.e select
                if(resultSet.next()){
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);
                    new Project1(user,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    // making the text field empty in case of invalid login
                    userNameField.setText("");
                    passField.setText("");
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }else if(ae.getSource()==SignUn){
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}

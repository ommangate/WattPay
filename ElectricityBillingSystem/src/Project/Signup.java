package Project;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {
    JButton back,create;
    Choice ch;
    JTextField meterText,uname1,nameText,passText;
    Signup(){

        // instead of using setSize and setLocation we can use setBounds to create the Frame
        setBounds(400,200,700,400);

        // Background-Color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Panel
        JPanel panel = new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(Color.blue,2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));// for changing the text color
        add(panel);

        // create account
        JLabel createacc = new JLabel("Create Account As");
        createacc.setBounds(100,50,140,20);
        createacc.setForeground(Color.gray);
        createacc.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(createacc);
        ch =new Choice();
        ch.add("Admin");
        ch.add("Customer");
        ch.setBounds(260,50,140,25);
        panel.add(ch);




        // meter number
        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(100,90,140,20);
        meternum.setForeground(Color.gray);
        meternum.setFont(new Font("Tahoma",Font.BOLD,14));
        meternum.setVisible(false);
        panel.add(meternum);
        meterText = new JTextField();
        meterText.setBounds(260,90,140,20);
        meterText.setVisible(false);
        panel.add(meterText);


        // Username
        JLabel username = new JLabel("Username");
        username.setBounds(100,130,140,20);
        username.setForeground(Color.gray);
        username.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(username);
        uname1 = new JTextField();
        uname1.setBounds(260,130,140,20);
        panel.add(uname1);

        // name
        JLabel name = new JLabel("Name");
        name.setBounds(100,170,140,20);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.gray);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(260,170,140,20);
        panel.add(nameText);

        // to add the focus - like as soon as we change the cursor from one text field to another the name is
        // automatically gets print
        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.statement.executeQuery("select * from login where meter_no = '"+meterText.getText()+"'");
                    while(rs.next()){
                        nameText.setText(rs.getString("name"));
                    }
                }
                catch (Exception ef){
                    ef.printStackTrace();
                }
            }
        });

        // password
        JLabel pass = new JLabel("Password");
        pass.setBounds(100,210,140,20);
        pass.setFont(new Font("Tahoma",Font.BOLD,14));
        pass.setForeground(Color.gray);
        panel.add(pass);
        passText = new JTextField();
        passText.setBounds(260,210,140,20);
        panel.add(passText);


        // adding additional functionality
        ch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = ch.getSelectedItem();
                if(user.equals("Customer")){
                    meternum.setVisible(true);
                    meterText.setVisible(true);
                    nameText.setEditable(false);
                    nameText.setText("");
                }
                else{
                    meternum.setVisible(false);
                    meterText.setVisible(false);
                    nameText.setEditable(true);

                }
            }
        });


        // Buttons -

        // create
        create = new JButton("Create");
//        create.setBackground(Color.BLACK);
//        create.setForeground(Color.white);
        create.setBounds(140,260,120,20);
        create.addActionListener(this);
        panel.add(create);

        // Back
        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.white);
        back.setBounds(280,260,120,20);
        back.addActionListener(this);
        panel.add(back);

        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410,30,250,250);
        panel.add(image);


        setVisible(true); // always write it downward other-wise things would not be visible
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {

            // to get the values stored in the global variable
            String aType = ch.getSelectedItem();
            String username = uname1.getText();
            String name = nameText.getText();
            String password = passText.getText();
            String meterNo = meterText.getText();

            try {
                Conn c = new Conn();

                // Ensure the connection is established and statement is not null
                if (c.conn != null && c.statement != null) {
                    PreparedStatement pst = null;

                    if (aType.equals("Admin")) {
                        // Prepare insert query
                        String query = "INSERT INTO login (meter_no, username, name, password, user) VALUES (?, ?, ?, ?, ?)";
                        pst = c.conn.prepareStatement(query);
                        pst.setString(1, meterNo);
                        pst.setString(2, username);
                        pst.setString(3, name);
                        pst.setString(4, password);
                        pst.setString(5, aType);
                    } else {
                        // Prepare update query
                        String query = "UPDATE login SET username = ?, password = ?, user = ? WHERE meter_no = ?";
                        pst = c.conn.prepareStatement(query);
                        pst.setString(1, username);
                        pst.setString(2, password);
                        pst.setString(3, aType);
                        pst.setString(4, meterNo);
                    }

                    // Execute the query
                    if (pst != null) {
                        pst.executeUpdate();

                        // Show success message
                        JOptionPane.showMessageDialog(null, "Account Created/Updated Successfully");

                        setVisible(false);
                        new Login();
                    }
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }

}

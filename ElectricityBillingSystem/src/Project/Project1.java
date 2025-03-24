package Project;

import javax.management.JMX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project1 extends JFrame implements ActionListener {
    String user1, meter1;
    Project1(String user1,String meter1){
        this.user1 = user1;
        this.meter1 = meter1;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // for full screen

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1450,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // for creating menu bar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);


//        for adding elements in the menu
        JMenu master = new JMenu("Master");



        // for adding options in the elements present in the menu (master)

        // New Customer
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.white);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1)); // for setting the image directly
        newcustomer.addActionListener(this);
        // for shortcut key
        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);

        // Customer Details
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.white);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2)); // for setting the image directly
        customerdetails.addActionListener(this);
        // for shortcut key
        customerdetails.setMnemonic('M');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerdetails);

        // deposite Details
        JMenuItem depositedetails = new JMenuItem("Deposite Details");
        depositedetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositedetails.setBackground(Color.white);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositedetails.setIcon(new ImageIcon(image3)); // for setting the image directly
        depositedetails.addActionListener(this);

        // for shortcut key
        depositedetails.setMnemonic('N');
        depositedetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositedetails);

        // Calculate Bills
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.white);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4)); // for setting the image directly
        calculatebill.addActionListener(this);
        // for shortcut key
        calculatebill.setMnemonic('C');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(calculatebill);



        JMenu info = new JMenu("Information");


        // Update Information
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinformation.setBackground(Color.white);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5)); // for setting the image directly
        // for shortcut key
        updateinformation.setMnemonic('U');
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updateinformation);

        // View Information
        JMenuItem ViewInformation = new JMenuItem("View Information");
        ViewInformation.setFont(new Font("monospaced",Font.PLAIN,12));
        ViewInformation.setBackground(Color.white);
        ImageIcon icon6= new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ViewInformation.setIcon(new ImageIcon(image6)); // for setting the image directly
        // for shortcut key
        ViewInformation.setMnemonic('V');
        ViewInformation.addActionListener(this);
        ViewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(ViewInformation);


        // User
        JMenu user = new JMenu("User");


        // pay Bill
        JMenuItem PayBill = new JMenuItem("Pay Bill");
        PayBill.setFont(new Font("monospaced",Font.PLAIN,12));
        PayBill.setBackground(Color.white);
        ImageIcon icon7= new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7= icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        PayBill.setIcon(new ImageIcon(image7)); // for setting the image directly
        // for shortcut key
        PayBill.setMnemonic('P');
        PayBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(PayBill);


        //  Bill Details
        JMenuItem BillDetails = new JMenuItem("BillDetails");
        BillDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        BillDetails.setBackground(Color.white);
        ImageIcon icon8= new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8= icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        BillDetails.setIcon(new ImageIcon(image8)); // for setting the image directly
        // for shortcut key
        BillDetails.setMnemonic('B');
        BillDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(BillDetails);



        // Report
        JMenu report = new JMenu("Report");

        // Generate Bill
        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced",Font.PLAIN,12));
        generateBill.setBackground(Color.white);
        ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9= icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(image9)); // for setting the image directly
        // for shortcut key
        generateBill.setMnemonic('G');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);




        // Utility
        JMenu Utility = new JMenu("Utility");


        // pay Bill
        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        Notepad.setBackground(Color.white);
        ImageIcon icon10= new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10= icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        Notepad.setIcon(new ImageIcon(image10)); // for setting the image directly
        // for shortcut key
        Notepad.setMnemonic('F');
        Notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        Utility.add(Notepad);

        // Calculator
        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        Calculator.setBackground(Color.white);
        ImageIcon icon11= new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11= icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        Calculator.setIcon(new ImageIcon(image11)); // for setting the image directly
        // for shortcut key
        Calculator.setMnemonic('T');
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        Utility.add(Calculator);



        // Exit
        JMenu Exit = new JMenu("Exit");

        // pay Bill
        JMenuItem exit = new JMenuItem("exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.white);
        ImageIcon icon12= new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12= icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12)); // for setting the image directly
        // for shortcut key
        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        Exit.add(exit);


        if(user1.equals("Admin")){
            mb.add(master);
            mb.add(Exit);
            mb.add(Utility);
        }
        else{
            mb.add(user);
            mb.add(info);
            mb.add(report);
            mb.add(Utility);
            mb.add(Exit);
        }



        setLayout((new FlowLayout()));
        setVisible(true);

    }


    public static void main(String[] args) {
        new Project1("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }
        else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }
        else if(msg.equals("Deposite Details")){
            new DepositeDetails();
        }
        else if(msg.equals("Calculate Bill")){
            new CalculateBill();
        }
        else if(msg.equals("View Information")){
            new ViewInformation(meter1);
        }
    }
}

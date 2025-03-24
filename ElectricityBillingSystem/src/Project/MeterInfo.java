package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {
    JLabel Meter;
    Choice location,type,code,billType;
    JButton next;
    String meternumber;
    MeterInfo(String meternumber){
        this.meternumber = meternumber;
        // Frame Creation
        setSize(700,500);
        setLocation(400,200);

        // Panel Creation
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(174,216,230));
        add(p);

        // Heading New Customer
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);


        // Meter Number Auto generated
        JLabel MeterNo = new JLabel("Meter Number");
        MeterNo.setBounds(100,80,130,30);
        p.add(MeterNo);
        Meter = new JLabel(meternumber);
        Meter.setBounds(240,80,200,30);
        p.add(Meter);


        // Meter Location Label
        JLabel Location = new JLabel("Meter Location");
        Location.setBounds(100,120,130,30);
        p.add(Location);
        // TextField
        location = new Choice();
        location.add("Outside");
        location.add("Inside");
        location.setBounds(242,120,200,30);
        p.add(location);

        // Meter Type Label
        JLabel MeterType = new JLabel("Meter Type");
        MeterType.setBounds(100,160,130,30);
        p.add(MeterType);
        type = new Choice();
        type.add("Electric Meter");
        type.add("Solar Meter");
        type.add("Smart Meter");
        type.setBounds(240,160,200,30);
        p.add(type);

        // ˇ
        JLabel PhaseCode = new JLabel("Phase Code");
        PhaseCode.setBounds(100,200,130,30);
        p.add(PhaseCode);
        code = new Choice();
        code.add("011");
        code.add("022");
        code.add("033");
        code.add("044");
        code.add("055");
        code.add("066");
        code.add("077");
        code.add("088");
        code.add("099");
        code.setBounds(240,200,200,30);
        p.add(code);

        // Bill Type Label
        JLabel BillType = new JLabel("Bill Type");
        BillType.setBounds(100,240,130,30);
        p.add(BillType);
        billType = new Choice();
        billType.add("Normal");
        billType.add("Industrial");;
        billType.setBounds(240,240,200,30);
        p.add(billType);

        // Phone Number Label
        JLabel Day = new JLabel("Days");
        Day.setBounds(100,280,130,30);
        p.add(Day);
        // Customer Name TextField
        JLabel Days1 = new JLabel("30 Days");
        Days1.setBounds(245,280,100,30);
        p.add(Days1);

        JLabel Note = new JLabel("Note");
        Note.setBounds(100,320,130,30);
        p.add(Note);

        JLabel Note1 = new JLabel("By Default Bill is Calculated for 30 days only");
        Note1.setBounds(245,320,300,30);
        p.add(Note1);


        // Creating Button
        next = new JButton("Submit");
        next.setBounds(220,390,100,25);
//        next.setBackground(new Color(0, 0, 0));
//        next.setForeground(new Color(255, 255, 255));
        next.addActionListener(this);
        p.add(next);


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
        new MeterInfo("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next){
            String meter = meternumber;
            String location1 = location.getSelectedItem();
            String type1 = type.getSelectedItem();
            String code1 = code.getSelectedItem();
            String billT = billType.getSelectedItem();
            String days = "30";

            String query1 = "insert into meter_info values('"+meter+"','"+location1+"','"+type1+"','"+code1+"','"+billT+"','"+days+"')";



            try{
                Conn c = new Conn();

                c.statement.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");

                setVisible(false);

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



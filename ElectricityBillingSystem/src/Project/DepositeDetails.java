package Project;

import net.proteanit.sql.DbUtils;// rs2xml.jar

import javax.swing.*;//extends JFrame
import java.awt.*;// for colors
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;// for resultSet

public class DepositeDetails extends JFrame implements ActionListener {
    Choice met_no,month;
    JTable table;// for table
    JButton search,print,Cancel;
    DepositeDetails(){
        super("Deposit Details");// frame title

        setSize(800,700);
        setLocation(400,100);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Search By Meter Number
        JLabel meter_no = new JLabel("Search By Meter Number");
        meter_no.setBounds(20,40,170,30);
        add(meter_no);
        met_no = new Choice();
        met_no.setBounds(200,40,150,30);
        add(met_no);

        // to show previously inserted choice
        try{
            Conn c = new Conn();
            String query = "select * from customer";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()){
                met_no.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Search By Month
        JLabel Month = new JLabel("Search By Month");
        Month.setBounds(450,40,130,30);
        add(Month);
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
        month.setBounds(590,40,150,30);
        add(month);

        table = new JTable(); // Creating table
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from Bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // for scroll bar
        JScrollPane sp = new JScrollPane(table);// scroll bar for table
        sp.setBounds(0,100,700,600);
        add(sp);


        // buttons

        // search
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        // print
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        // Cancel
        Cancel = new JButton("Cancel");
        Cancel.setBounds(220,70,80,20);
        Cancel.addActionListener(this);
        add(Cancel);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query = "select * from Bill where meter_no = '"+met_no.getSelectedItem()+"' and month = '"+month.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==Cancel){
            setVisible(false);
            new Project1("","");
        }

        else{
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DepositeDetails();
    }

}

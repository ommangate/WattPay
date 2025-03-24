package Project;

import net.proteanit.sql.DbUtils;// rs2xml.jar

import javax.swing.*;//extends JFrame
import java.awt.*;// for colors
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;// for resultSet

public class CustomerDetails extends JFrame implements ActionListener {
    Choice met_no,month;
    JTable table;// for table
    JButton search,print,Cancel;
    CustomerDetails(){
        super("Customer Details");// frame title

        setSize(1200,650);
        setLocation(200,150);

        table = new JTable(); // Creating table
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // for scroll bar
        JScrollPane sp = new JScrollPane(table);// scroll bar for table
        add(sp);


        // buttons

        // print
        print = new JButton("Print");
        print.addActionListener(this);
        add(print,"South"); // we can also add the location

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    public static void main(String[] args) {
        new CustomerDetails();
    }
}

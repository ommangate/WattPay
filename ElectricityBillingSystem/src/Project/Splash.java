package Project;

import javax.swing.*; // javax -> means extended package of java for swing
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Splash(){


            // for setting the image on the frame
            // Note - we need to set the image before setting the visibility of frame as true (Order matter)
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
            Image i2 = i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3); // We cannot pass instances of the "Image" class in JLabel directly
            add(image); // adding image on the frame

            // By default, visibility of frame is hidden make it true for visibility
            setVisible(true);


            // for getting the splash effect so dynamic allocation of the size
        for (int i = 2; i <= 575; i+=2) {
            try {
                // Delay for smoother animation
                Thread.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Length and width of frame
            setSize(i,i);

            // By default, the location of frame is top left corner, change it to desired location
            setLocation(700-i/2, 400-i/2);
        }

            Thread t = new Thread(this); // this -> current class reference
            t.start(); // internally calls run() method
            setVisible(true);
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash(); // class ka object -> When we make the object of the class constructor is called
                     //  automatically
    }

}

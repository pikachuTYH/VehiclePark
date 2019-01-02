import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Exit extends JFrame implements ActionListener {
    JButton CarBtn, MotorBtn;


    JFrame OFrame = new JFrame("Exit - Car Parking System");
    Everything ev;

    public Exit(Everything e)
    {
        ev = e;
        OFrame.setResizable(false);
        OFrame.setSize(900,500);

        OFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OFrame.setLocationRelativeTo(null);
        OFrame.setLayout(null);

        CarBtn = new JButton("Car");
        MotorBtn = new JButton("Motor");

        CarBtn.setBounds(200, 100, 200, 200);
        MotorBtn.setBounds(500, 100, 200, 200);


        OFrame.add(CarBtn);
        OFrame.add(MotorBtn);


        CarBtn.addActionListener(this);
        MotorBtn.addActionListener(this);


        OFrame.setVisible(true);



    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == CarBtn){
            OFrame.dispose();
            new CarE(ev);
        }
        else if(e.getSource() == MotorBtn){
            OFrame.dispose();
            new MotorE(ev);
        }


    }
}
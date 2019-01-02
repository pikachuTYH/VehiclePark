import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminOption extends JFrame implements ActionListener {
    JButton HistoryrBtn, DisplaycarBtn,DisplaymotorBtn, LogoutBtn;


    JFrame OFrame = new JFrame("Admin Menu - Car Parking System");
    Everything ev;

    public AdminOption(Everything e)
    {
        ev = e;
        OFrame.setResizable(false);
        OFrame.setSize(900,500);

        OFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OFrame.setLocationRelativeTo(null);
        OFrame.setLayout(null);

        HistoryrBtn = new JButton("History");
        DisplaycarBtn = new JButton("Current Car");
        DisplaymotorBtn = new JButton("Current Motor");
        LogoutBtn = new JButton("Logout");

        HistoryrBtn.setBounds(300, 100, 200, 70);
        DisplaycarBtn.setBounds(300, 220, 200, 70);
        DisplaymotorBtn.setBounds(300,340,200,70);
        LogoutBtn.setBounds(700, 400, 100, 55);

        OFrame.add(HistoryrBtn);
        OFrame.add(DisplaycarBtn);
        OFrame.add(DisplaymotorBtn);
        OFrame.add(LogoutBtn);

        HistoryrBtn.addActionListener(this);
        DisplaycarBtn.addActionListener(this);
        DisplaymotorBtn.addActionListener(this);
        LogoutBtn.addActionListener(this);

        OFrame.setVisible(true);



    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == HistoryrBtn){
            OFrame.dispose();
            new DisplayAll(ev);
        }
        else if(e.getSource() == DisplaycarBtn){
            OFrame.dispose();
            new DisplayCar(ev);
        }
        else if(e.getSource() == DisplaymotorBtn){
            OFrame.dispose();
            new DisplayMotor(ev);
        }
        else if (e.getSource() == LogoutBtn){
            OFrame.dispose();
            new OptionPage(ev);
        }

    }
}

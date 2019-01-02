
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OptionPage extends JFrame implements ActionListener {
    JButton EnterBtn, ExitBtn, LoginBtn;


    JFrame OFrame = new JFrame("Main Menu - Car Parking System");
    Everything ev;

    public OptionPage(Everything e)
    {
        ev = e;
        OFrame.setResizable(false);
        OFrame.setSize(900,500);

        OFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OFrame.setLocationRelativeTo(null);
        OFrame.setLayout(null);

        EnterBtn = new JButton("Enter");
        ExitBtn = new JButton("Exit");
        LoginBtn = new JButton("Admin");

        EnterBtn.setBounds(200, 100, 200, 200);
        ExitBtn.setBounds(500, 100, 200, 200);
        LoginBtn.setBounds(700, 400, 100, 55);

        OFrame.add(EnterBtn);
        OFrame.add(ExitBtn);
        OFrame.add(LoginBtn);

        EnterBtn.addActionListener(this);
        ExitBtn.addActionListener(this);
        LoginBtn.addActionListener(this);

        OFrame.setVisible(true);



    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == EnterBtn){
            OFrame.dispose();
            new Enter(ev);
        }
        else if(e.getSource() == ExitBtn){
            OFrame.dispose();
            new Exit(ev);
        }
        else if (e.getSource() == LoginBtn){
            OFrame.dispose();
           new Login(ev);
        }

    }
}

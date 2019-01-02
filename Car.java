import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Car extends JFrame implements ActionListener{
    JLabel carplate;
    JFrame MBP = new JFrame("Enter Car - Car Parking System");
    JButton ProceedBtn, CancelBtn;
    JTextField carplatetf;
    Everything ev;

    protected Car(Everything e){
        ev = e;
        MBP.setResizable(false);
        MBP.setSize(900,500);

        MBP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MBP.setLocationRelativeTo(null);
        MBP.setLayout(null);

        carplate = new JLabel("Enter Car Plate : ");


        carplatetf = new JTextField(7);



        ProceedBtn = new JButton("Proceed");
        CancelBtn = new JButton("Cancel");

        carplate.setBounds(100, 50, 100, 25);


        carplatetf.setBounds(200, 50, 400, 25);


        ProceedBtn.setBounds(360, 430, 100, 25);
        CancelBtn.setBounds(660, 430, 100, 25);


        MBP.add(carplate);
        MBP.add(carplatetf);
        MBP.add(ProceedBtn);
        MBP.add(CancelBtn);

        ProceedBtn.addActionListener(this);
        CancelBtn.addActionListener(this);

        MBP.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ProceedBtn){
            //Everything ev = new Everything();
            int resultbtn = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirm Car Plate?"+"\n"+carplatetf.getText(), "Confirm", resultbtn);
            if (result == JOptionPane.YES_OPTION){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                ev.saveCar(carplatetf.getText(),dtf.format(now));
                JOptionPane.showMessageDialog(null, "Car Plate Confirmed!");
                MBP.dispose();
                new OptionPage(ev);
            }
            else if (result == JOptionPane.NO_OPTION){
                MBP.dispose();
                new Enter(ev);
            }

        }
        else if (e.getSource() == CancelBtn){
            MBP.dispose();
            new OptionPage(ev);
        }
    }



}

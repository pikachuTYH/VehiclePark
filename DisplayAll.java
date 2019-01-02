import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class DisplayAll extends JFrame implements ActionListener {

    JFrame DP = new JFrame("Display All - University Venue Management System");
    JButton ProceedBtn;
    JTextField textField;
    JTextArea textArea;
    Everything ev;

    protected DisplayAll(Everything e) {
        ev = e;
        DP.setResizable(false);
        DP.setSize(900, 500);

        DP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DP.setLocationRelativeTo(null);
        DP.setLayout(null);

        textArea = new JTextArea(20,10);
        textArea.setBounds(100,100,700,300);
        textArea.setEditable(false);


        ProceedBtn = new JButton("OK");

        ProceedBtn.setBounds(660, 430, 100, 25);
        DP.add(ProceedBtn);
        DP.add(textArea);

        ProceedBtn.addActionListener(this);
        DP.setVisible(true);
        String text ="ABC";
        try{
            //Everything ev = new Everything();
            text = ev.displayhistory();
        }catch(FileNotFoundException a){
            JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        textArea.append(text);
    }
    public void actionPerformed(ActionEvent e){


        if (e.getSource() == ProceedBtn){
            DP.dispose();
            new AdminOption(ev);

        }




    }

}
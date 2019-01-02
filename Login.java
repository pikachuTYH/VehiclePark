
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login extends Run implements ActionListener{

    JFrame jfx;
    JLabel login, usernid, userpassword;
    static JTextField usernametf, userpwdtf;
    JButton loginBtn, returnBtn;
    static String username;
    Everything ev;
    /*
        public Login(Everything e){
            ev = e;
        }
    */
    public Login(Everything e){
        ev = e;
        jfx = new JFrame("Admin Login - Car Parking System");
        jfx.setResizable(false);
        jfx.setSize(900,500);
        //jfx.setVisible(true);
        jfx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfx.setLocationRelativeTo(null);
        jfx.setLayout(null);

        login = new JLabel("Login");
        usernid = new JLabel("Username");
        userpassword = new JLabel("Password");

        usernametf = new JTextField(10);
        userpwdtf = new JTextField(10);

        loginBtn = new JButton("Login");
        returnBtn = new JButton("Return");

        usernid.setBounds(100, 20, 100, 25);
        userpassword.setBounds(100, 50, 100, 25);

        usernametf.setBounds(200, 20, 400, 25);
        userpwdtf.setBounds(200, 50, 400, 25);

        loginBtn.setBounds(360, 400, 100, 25);
        returnBtn.setBounds(700, 400, 100, 25);

        jfx.add(login);
        jfx.add(usernid);
        jfx.add(userpassword);
        jfx.add(usernametf);
        jfx.add(userpwdtf);
        jfx.add(loginBtn);
        jfx.add(returnBtn);

        loginBtn.addActionListener(this);
        returnBtn.addActionListener(this);

        jfx.setVisible(true);


    }
    public static String getUsername(){
        return usernametf.getText();
    }

    public static String getPwd(){
        return userpwdtf.getText();
    }





    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginBtn)
        {
            try{
                //Everything ev = new Everything();
                if(ev.login(usernametf.getText(), userpwdtf.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Login Success", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    jfx.dispose();
                    new AdminOption(ev);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password", "Login Failed",JOptionPane.ERROR_MESSAGE);
                }

            }catch(Exception error)
            {
                JOptionPane.showMessageDialog(null, "Error", "Login Failure", JOptionPane.ERROR_MESSAGE);
            }

        }
        if(e.getSource() == returnBtn){

            jfx.dispose();
            new OptionPage(ev);
        }
    }




}
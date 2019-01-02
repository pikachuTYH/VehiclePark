import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class Everything {
    private String carplate;
    private String CurrentTime;
    private String motorplate;
    private String UserName;
    private String Pwd;


    public Everything()
    {


    }

    public boolean login(String un, String pass) throws FileNotFoundException
    {
        this.UserName = un;
        this.Pwd = pass;
        File x = new File("userinfo.txt");
        try{
            Scanner read = new Scanner(x);
            read.useDelimiter(" ");
            do{
                String un2 = read.next();
                String pass2 = read.next();

                if((UserName.equals(un2)) && (Pwd.equals(pass2))){

                    read.close();
                    return true;
                }
                read.nextLine();
            }while(read.hasNext()==true);

        }catch(FileNotFoundException err){
            throw err;
        }
        return false;

    }

    public void saveCar(String cp,String now)
    {
        carplate = cp;
        CurrentTime = now;
        File m = new File("carenter.txt");
        String charset = "UTF-8";

        try{

            if(m.exists()){

                String info = carplate + " "+ CurrentTime+" ";
                FileWriter FW = new FileWriter(m.getAbsoluteFile(), true);
                BufferedWriter BW = new BufferedWriter(FW);
                BW.append(info);
                BW.newLine();
                BW.close();
                FW.close();
                System.out.println("Done");
                JOptionPane.showMessageDialog(null, "You May Enter", "Enter", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                System.out.println("Failed");
            }
        }catch(IOException e)
        {
            System.out.println("Whatever");
        }
    }

    public void saveMotor(String mp,String now)
    {
        motorplate = mp;
        CurrentTime = now;
        File m = new File("motorenter.txt");


        try{

            if(m.exists()){
                String info = motorplate + " "+ CurrentTime+" ";
                FileWriter FW = new FileWriter(m.getAbsoluteFile(), true);
                BufferedWriter BW = new BufferedWriter(FW);
                BW.append(info);
                BW.newLine();
                BW.close();
                FW.close();
                System.out.println("Done");
                JOptionPane.showMessageDialog(null, "You May Enter", "Enter", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                System.out.println("Failed");
            }
        }catch(IOException e)
        {
            System.out.println("Whatever");
        }
    }

    public void carexit(String cp,String now) throws FileNotFoundException, IOException {
        try {

            File f = new File("carenter.txt");
            File temp = new File("temp.txt");
            File history = new File("history.txt");

            String charset = "UTF-8";

            carplate = cp;
            FileWriter FW = new FileWriter(temp.getAbsoluteFile(), true);
            BufferedWriter BW = new BufferedWriter(FW);
            BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(f), charset));
            FileWriter FWH = new FileWriter(history.getAbsoluteFile(), true);
            BufferedWriter BWH = new BufferedWriter(FWH);

            Scanner scn = new Scanner(f);
            String  text = "", date, time, car = "";
            String  info ="",dateh,timeh;

            do{
                    if (carplate.equals(car=scn.next()))
                {
                    dateh = scn.next();
                    timeh = scn.next();
                    scn.nextLine();
                    info =car+" "+dateh+" "+timeh+" "+ now+" ";
                    BWH.append(info);
                    BWH.newLine();
                }
                else {
                    date = scn.next();
                    time = scn.next();
                    text = car +" "+ date + " "+time+" " ;
                    BW.append(text);
                    BW.newLine();
                    scn.nextLine();}
            }while(scn.hasNextLine()==true);

            BR.close();
            BW.close();
            FW.close();
            BWH.close();
            scn.close();
            f.delete();
            temp.renameTo(f);

        }catch(IOException IOE){
            JOptionPane.showMessageDialog(null, "Not Found", "Error Occured", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void motorexit(String cp,String now) throws FileNotFoundException, IOException {
        try {

            File f = new File("motorenter.txt");
            File temp = new File("temp.txt");
            File history = new File("history.txt");

            String charset = "UTF-8";

            carplate = cp;
            FileWriter FW = new FileWriter(temp.getAbsoluteFile(), true);
            BufferedWriter BW = new BufferedWriter(FW);
            BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(f), charset));
            FileWriter FWH = new FileWriter(history.getAbsoluteFile(), true);
            BufferedWriter BWH = new BufferedWriter(FWH);

            Scanner scn = new Scanner(f);
            String  text = "", date, time, car = "";
            String  info ="",dateh,timeh;

            //String line = "";
            do{
                if (carplate.equals(car=scn.next()))
                {
                    dateh = scn.next();
                    timeh = scn.next();
                    scn.nextLine();
                    info =car+" "+dateh+" "+timeh+" "+now+" ";
                    BWH.append(info);
                    BWH.newLine();
                }
                else {
                    date = scn.next();
                    time = scn.next();
                    text = car +" "+ date + " "+time +" ";
                    BW.append(text);
                    BW.newLine();
                    scn.nextLine();}
            }while(scn.hasNextLine()==true);

            BR.close();
            BW.close();
            FW.close();
            BWH.close();
            scn.close();
            f.delete();
            temp.renameTo(f);

        }catch(IOException IOE){
            JOptionPane.showMessageDialog(null, "Not Found", "Error Occured", JOptionPane.ERROR_MESSAGE);
        }

    }
    public String displayhistory() throws FileNotFoundException
    {
        String info, text = "No  Plate Number           Enter Date          Enter Time          Exit Date            Exit Time  \n", plate , enterdate, entertime, exitdate, exittime;
        int count = 0;
        boolean infoexists = false;

        try{
            FileReader a = new FileReader("history.txt");
            Scanner sc = new Scanner(a);
            sc.useDelimiter(" ");
            do{
                    count++;
                    plate = sc.next();
                    enterdate = sc.next();
                    entertime = sc.next();
                    exitdate = sc.next();
                    exittime = sc.next();
                    sc.nextLine();
                    text = text+count+"         "+ plate +"                 "+ enterdate +"           "+entertime +"           "+ exitdate +"        "+ exittime +"\n";

                    //System.out.println(dt + " " + st + " " + et);



            }while(sc.hasNextLine()==true);
            a.close();
            sc.close();
            return text;

        }catch(IOException e){
            System.out.println("File does not exist");
        }
        if(!infoexists)
            JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.ERROR_MESSAGE);
        //else
        //new DisplayBookingPage();
        return text;

    }

    public String displaycar() throws FileNotFoundException
    {
        String info, text = "No  Plate Number           Enter Date          Enter Time  \n", plate , enterdate, entertime;
        int count = 0;
        boolean infoexists = false;

        try{
            FileReader a = new FileReader("carenter.txt");
            Scanner sc = new Scanner(a);
            sc.useDelimiter(" ");
            do{
                count= count + 1;
                plate = sc.next();
                enterdate = sc.next();
                entertime = sc.next();

                sc.nextLine();
                text = text+ count+ "         " + plate +"                "+ enterdate +"           "+entertime +"        "+"\n";

                //System.out.println(dt + " " + st + " " + et);



            }while(sc.hasNextLine()==true);
            a.close();
            sc.close();
            return text;

        }catch(IOException e){
            System.out.println("File does not exist");
        }
        if(!infoexists)
            JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.ERROR_MESSAGE);
        //else
        //new DisplayBookingPage();
        return text;

    }
    public String displaymotor() throws FileNotFoundException
    {
        String info, text = "No  Plate Number           Enter Date          Enter Time  \n", plate , enterdate, entertime;
        int count = 0;
        boolean infoexists = false;

        try{
            FileReader a = new FileReader("motorenter.txt");
            Scanner sc = new Scanner(a);
            sc.useDelimiter(" ");
            do{
                count++;
                plate = sc.next();
                enterdate = sc.next();
                entertime = sc.next();

                sc.nextLine();
                text = text+ count+ "         " + plate +"                "+ enterdate +"           "+entertime +"        "+"\n";

                //System.out.println(dt + " " + st + " " + et);



            }while(sc.hasNextLine()==true);
            a.close();
            sc.close();
            return text;

        }catch(IOException e){
            System.out.println("File does not exist");
        }
        if(!infoexists)
            JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.ERROR_MESSAGE);
        //else
        //new DisplayBookingPage();
        return text;

    }




}

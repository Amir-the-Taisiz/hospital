import java.io.*;
import java.util.Scanner;

public class Nurse {
    Scanner get = new Scanner(System.in);
    public boolean sehatSangi(String code , String pass){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nurse.txt"));
            String line;
            while ((line = reader.readLine())!= null){
                if (code.equals(line)){
                    line= reader.readLine();
                    if (pass.equals(line)){
                        reader.close();
                        return true;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
     return false;
    }
    public void changePass(String code ,String oldpass){
        File fileToBeModified = new File("nurse.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null){
                oldContent = oldContent + line + System.lineSeparator();
                line=reader.readLine();
            }
            System.out.println("please Enter your new password :");
            String newPass = get.next();
            String newContent = oldContent.replaceAll(oldpass,newPass);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            }catch (IOException e ){
                e.printStackTrace();
            }
        }
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("nurse.txt"));
            String line2;
            while ((line2 = reader1.readLine())!= null){

                System.out.println(line2);
            }
            reader1.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

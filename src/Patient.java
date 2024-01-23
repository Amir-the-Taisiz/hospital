import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Patient {
    Scanner get = new Scanner(System.in);

    public boolean sehatSangi(String Pcode){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("patient.txt"));
            String line;
            while ((line = reader.readLine())!= null){
                if (Pcode.equals(line)){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    public void changeDrugs(String patientCode){
        ArrayList<String> patientInfo = new ArrayList<>();
        File fileToBeModified = new File("patient.txt");
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line ;
            while ((line=reader.readLine()) != null){
               patientInfo.add(line);
            }
            boolean rast = true;
            while (rast){
                System.out.println("1 : add a drug    ");
                System.out.println("2 : delete a grud ");
                System.out.println("3 : edit a drug   ");
                int choice = get.nextInt();
                if (choice==1){

                    System.out.println("Enter the name of the drug ");
                    String DName = get.next();

                    for (int i=0 ; i<patientInfo.size() ; i++  ){
                        if (patientCode.equals(patientInfo.get(i))){
                            System.out.println(patientInfo.get(i));
                            patientInfo.add((i+6),DName);
                            System.out.println(patientInfo.get(i+6));
                        }
                    }
                }
                if (choice==2){
                    System.out.println("choose a drug you want to delete");
                    for (int i=0 ; i<patientInfo.size() ; i++){
                        if (patientCode.equals(patientInfo.get(i))){
                            String x="/";
                            System.out.println("Drugs");
                            for (int j=i+5 ; !patientInfo.get(j).equals(x) ; j++){
                                System.out.println( j+" : "+patientInfo.get(j));
                            }

                            int hzf = get.nextInt();
                            patientInfo.remove(hzf);
                        }
                    }
                }
                if (choice==3){
                    System.out.println("choose a drug you want to edit");
                    for (int i=0 ; i<patientInfo.size() ; i++){
                        if (patientCode.equals(patientInfo.get(i))){
                            String x="/";
                            System.out.println("Drugs");
                            for (int j=i+5 ; !patientInfo.get(j).equals(x) ; j++){
                                System.out.println( j +" : "+patientInfo.get(j));
                            }
                            int edit = get.nextInt();
                            System.out.println("enter the name of the new drug you want to replace ");

                            String Ndrug=get.next();

                            patientInfo.set(edit,Ndrug);
                        }
                    }
                }
                System.out.println("Do you want to make any change in patients drugs ?");
                String awnser;
                awnser = get.next();
                if (awnser.equals("no")){
                    rast=false;
                }
            }

            writer = new FileWriter(fileToBeModified);
            for (int i=0 ; i<patientInfo.size() ; i++){
                writer.write(patientInfo.get(i));
                writer.write("\n");
            }
            //writer.write(String.valueOf(patientInfo));
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
    }
}

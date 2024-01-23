import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class Paziresh extends Patient {
    Scanner get = new Scanner(System.in);

    public void addPatient(){
        File fileToBeModified = new File("patient.txt");
        BufferedReader reader = null;
        FileWriter writer = null;
        ArrayList<String> newPatient = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line ;
            while ((line=reader.readLine()) != null){
                newPatient.add(line);
            }
            System.out.println("Enter new patient's code :");
            String code = get.next();
            newPatient.add(code);

            System.out.println("Enter new patient's First name :");
            String Fname = get.next();
            newPatient.add(Fname);

            System.out.println("Enter new patient's Last name");
            String Lname = get.next();
            newPatient.add(Lname);

            System.out.println("Enter new patient's doctor name :");
            String doctor = get.next();
            newPatient.add(doctor);

            System.out.println("Enter date of the registration like Day/Month/Year :");
            String date = get.next();
            newPatient.add(date);

            newPatient.add("drugs");
            newPatient.add("/");


            writer = new FileWriter(fileToBeModified);
            for (int i=0 ; i<newPatient.size() ; i++){
                writer.write(newPatient.get(i));
                writer.write("\n");
            }

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
    public void deletFile(){
        boolean edame = true;
        while (edame){
            System.out.println("Enter the patient's code that you want to delete his/her File");
            String code1 = get.next();
            File fileToBeModified = new File("patient.txt");
            if (sehatSangi(code1)){
                BufferedReader reader = null;
                FileWriter writer = null;
                try {
                    reader = new BufferedReader(new FileReader(fileToBeModified));
                    ArrayList<String> delete = new ArrayList<>();
                    String line;
                    while ((line = reader.readLine())!= null){
                        delete.add(line);
                    }
                    for (int i=0 ; i<delete.size() ; i++ ){
                        if (code1.equals(delete.get(i))){
                            String x = "/";
                            while (!delete.get(i).equals(x)){
                                delete.remove(i);
                            }
                            delete.remove(i);
                        }
                    }
                    for (int i= 0 ; i<delete.size() ; i++){
                        System.out.println(delete.get(i));
                    }
                    writer = new FileWriter(fileToBeModified);
                    for (int i=0 ; i<delete.size() ; i++){
                        writer.write(delete.get(i));
                        writer.write("\n");
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        reader.close();
                        writer.close();
                    }catch (IOException e ){
                        e.printStackTrace();
                    }
                }
                edame=false;
            }
            else {
                System.out.println("this patient code is not correct : please enter 1 if you want to repeat this operation ");
                int reppeat = get.nextInt();
                if (reppeat==1){
                    edame=false;
                }
            }
        }
    }
    public void showSpecialFile(){
        boolean edame = true;
        while (edame){
            System.out.println("Enter the patient's code that you want to see his/her File");
            String code = get.next();
            if (sehatSangi(code)){
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("patient.txt"));
                    ArrayList<String> file = new ArrayList<>();
                    String line;
                    while ((line = reader.readLine())!= null){
                        file.add(line);
                    }
                    for (int i=0 ; i<file.size() ; i++ ){
                        if (code.equals(file.get(i))){
                            String x = "/";
                            for (int j=i ; !file.get(j).equals(x) ; j++){
                                System.out.println(file.get(j));
                            }
                        }
                    }

                    reader.close();
                }catch (Exception e){
                    System.out.println("There is no such a file");
                }
                edame=false;
            }
            else {
                System.out.println("this patient code is not correct : please enter 1 if you want to repeat this operation ");
                int reppeat = get.nextInt();
                if (reppeat==1){
                    edame=false;
                }
            }
        }


    }
    public void showFile(){
        FileWriter  writer = null;
        ArrayList<ArrayList<String>> Pinfo = new ArrayList<>();
        File fileToBeModified = new File("patient.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null){
                ArrayList<String> p1 = new ArrayList<>();
                String x="/";
                while (!line.equals(x)){
                    p1.add(line);
                    line=reader.readLine();
                }
                line = reader.readLine();
                Pinfo.add(p1);
            }
            reader.close();
            ArrayList<String> max = new ArrayList();
            for (int i=0 ; i<Pinfo.size() ; i++){
                max.add( Pinfo.get(i).get(0));
            }
            Collections.sort(max);
            ArrayList<ArrayList<String>> sorted = new ArrayList<>();
            for (int i=0 ; i<max.size() ; i++ ){
                for (int j=0 ; j<Pinfo.size() ; j++){
                    if (max.get(i).equals(Pinfo.get(j).get(0))){
                        sorted.add(Pinfo.get(j));
                    }
                }
            }
            writer = new FileWriter(fileToBeModified);
            System.out.println(sorted);
            for (int i=0  ; i<sorted.size() ; i++){
                for (int j=0 ; j<sorted.get(i).size() ; j++){
                    writer.write(sorted.get(i).get(j));
                    writer.write("\n");
                }
                writer.write("/");
                writer.write("\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println("There is no such a file");
            e.printStackTrace();
        }
    }
}

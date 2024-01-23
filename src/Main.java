import java.util.Scanner;

public class Main {

    static Scanner get = new Scanner(System.in);

    public static void main(String[] args) {
        boolean edame = true;
        while (edame){
            System.out.println("Welcome to Ebn e Sina hospital  ,enter one of the bellow choices  :");
            System.out.println("1 : Nurse");
            System.out.println("2 : Receptionist ");
            int entekhab = get.nextInt();
            if(entekhab==1){
                var nurse = new Nurse();
                int entekhab1;
                String Fcode = null;
                String externalCode = null;

                try {
                    for (int i=0 ;i<3 ; i++){
                        System.out.println("please enter nurse's code and password ");
                        String code = get.next();
                        String pass = get.next();
                        externalCode= code;
                        if (nurse.sehatSangi(code,pass)==true){
                            Fcode=code;
                            break;
                        }
                        if (i==2){
                            throw new Exception();
                        }
                        System.out.println("You have "+(2-i)+" chance");
                    }
                }catch (Exception e){
                    System.out.println("You do not have permission to access the application.");
                    throw new RuntimeException(e);
                }
                System.out.println("1 : update patient's file");
                System.out.println("2 : change the password ");
                entekhab1 = get.nextInt();
                if (entekhab1==1){
                    System.out.println("please enter patient's code :");
                    String Pcode = get.next();
                    var p = new Patient();
                    if (p.sehatSangi(Pcode)==true){
                        p.changeDrugs(Pcode);
                    }

                }
                if (entekhab1==2){
                    System.out.println("please enter your password :");
                    String pass = get.next();
                    System.out.println(externalCode);
                    if (nurse.sehatSangi(externalCode,pass)==true){
                        nurse.changePass(Fcode,pass);
                    }
                }
            }
            if (entekhab==2){
                System.out.println("1 : adding new patient ");
                System.out.println("2 : deleting a patient ");
                System.out.println("3 : searching for patient's File ");
                System.out.println("4 : showing the patients file ");

                int entekhab3 = get.nextInt();

                var paziresh = new Paziresh();

                if (entekhab3==1){
                    paziresh.addPatient();
                }
                if (entekhab3==2){
                    paziresh.deletFile();
                }
                if (entekhab3==3){
                    paziresh.showSpecialFile();
                }
                if (entekhab3==4){
                    paziresh.showFile();
                }


            }
            System.out.println("Do you want to continue the program ?");
            System.out.println();
            String javab = get.next();
            if (javab.equals("no")){
                edame=false;
            }
        }

    }
}
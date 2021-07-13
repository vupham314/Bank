import java.util.*;

public class ManageMain {
    static Scanner scn = new Scanner(System.in);
    static ClaSSS object = new ClaSSS();

    public static void menu (){
        System.out.println("""
                1: add student
                2: show all
                3: sort by ID
                4: search by ID
                5: delete by ID
                6: exit
                """);
        System.out.print("enter your choice ");
        int choice = Integer.parseInt(scn.nextLine());

        switch(choice){
            case 1 -> {object.addStudent(object.inputStudent());}
            case 2 -> {object.showAll();}
            case 3 -> {
                object.sortByID();
                object.showAll();
            }
            case 4 -> {
                System.out.println(object.searchByID());
            }
            case 5 -> {object.deleteStudentByID();}
            case 6 -> {return;}
        }
        menu(); // goi lai
    }

    public static void main(String[] args) {
        menu();
    }
}

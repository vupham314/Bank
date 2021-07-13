import java.util.*;

public class ClaSSS {
    Scanner scn = new Scanner(System.in);
    ArrayList<Student> studentList = new ArrayList<Student>();


    public Student inputStudent (){
        System.out.print("enter ID ");
        int ID = Integer.parseInt(scn.nextLine());

        System.out.print("enter name ");
        String name = scn.nextLine();

        System.out.print("enter mark ");
        double mark = Double.parseDouble(scn.nextLine());

        return new Student(ID, name, mark);
    }


    public void deleteStudentByID (){
        int index = this.searchByID();
        if (index == -1){
            System.out.println(" error");
            return;
        }
        studentList.remove(index);
    }


    public void addStudent (int ID, String name, double mark){
        Student student = new Student(ID, name, mark);
        studentList.add(student);
    }


    public void addStudent(){
        System.out.println("nhap so hoc sinh");
        int size = Integer.parseInt(scn.nextLine());

        for(int i = 0; i < size; i++){
            Student ele = this.inputStudent();
            studentList.add(ele);
        }

    }


    private static void swap(Student argA, Student argB) {
        Student current = argA;
        argA = argB;
        argB = current;
    }


    public int searchByID (){
        System.out.println("enter an ID");
        int ID = Integer.parseInt(scn.nextLine());

        for(Student student : studentList){
            if (student.getID() == ID){
                return studentList.indexOf(student);
            }
        }
        return -1;
    }


    public void showAll (){
        for(Student student : studentList){
            System.out.println(student); // have got toString
        }
    }
//studentList.get(j).getID() < studentList.get(j-1).getID()
    public void sortByName (){
        Student current;
        for (int i = 0; i < studentList.size(); i++){
            for (int j = studentList.size() - 1; j > i; j--){
                if(studentList.get(j).getName().compareTo(studentList.get(j-1).getName()) < 0 ){
//                    swap(studentList.get(j), studentList.get(j - 1));
                    current = studentList.get(j);
                    studentList.set(j, studentList.get(j - 1));
                    studentList.set(j - 1, current);
                }
        }

        }
    }


    public void sortByID (){
        int pos;
        Student current;

        for (int i = 0; i < studentList.size(); i++){
            for (int j = studentList.size() - 1; j > i; j--){
                if(studentList.get(j).getID() < studentList.get(j-1).getID()){
//                    swap(studentList.get(j), studentList.get(j - 1));
                    current = studentList.get(j);
                    studentList.set(j, studentList.get(j - 1));
                    studentList.set(j - 1, current);
                }
            }
        }
    }


}

public class Student {
    private int ID;
    private String name;
    private double mark;

    static int a = 10;

    Student (){
        //overloading
    }

    Student (int ID, String name, double mark){
        this.ID = ID;
        this.name = name;
        this.mark = mark;
    }

    public static int getID() {
        a = 11;
        return a; }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String toString(){
        return String.format("%3d |%10s |%2.2f", this.ID, this.name, this.mark);
    }
}

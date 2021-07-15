package geograp;
import java.util.*;

public class Main {
    private static double areaMax = 0;
    private static String typeGeo;
    Scanner scn = new Scanner(System.in);
    private static ArrayList<Geograp> geograpArrayListArea = new ArrayList<Geograp>();

    // tim max min
    void menu(){
        System.out.println("__________________________");
        System.out.println("""
                1: tính diện hình tròn
                2: tính diện hình vuông
                3: tính diện hình chữ nhật
                4: tìm diện tích lớn nhất
                5: thoát
                """);

        System.out.print("nhập lựa chọn ");
        switch(Integer.parseInt(scn.nextLine())){
            case 1 -> {
                System.out.print("nhập bán kính ");
                System.out.println("diện tích hình tròn là "
                        + calculateArea(Float.parseFloat(scn.nextLine())));
            }
            case 2 -> {
                System.out.print("nhập cạnh hình vuông ");
                System.out.println("diện tích hình vuông là "
                        + calculateArea(Double.parseDouble(scn.nextLine())));
            }
            case 3 -> {
                System.out.print("nhập chiều rộng ");
                double x = Double.parseDouble(scn.nextLine());
                System.out.print("nhập chiều dài ");
                double y = Double.parseDouble(scn.nextLine());
                System.out.println("diện tích hình chữ nhật là "
                        + calculateArea(x, y));
            }
            case 4 -> {
                System.out.println("diện tích lớn nhất trong các hình vừa rồi là " + typeGeo + " " + maxArea());
            }
            case 5 -> {
                return;
            }
        }
        this.menu();
    }


    private static double returnAndCheckMaxArea(Geograp object){ // một hàm lộn xộn và phức tạp
        if(object.getArea() > areaMax){                          // thêm các diện tích vào mảng và trả về diện tích
            typeGeo = object.getTypeGeo();                       // dùng để tìm diện tích lớn nhất giữa các hình
            areaMax = object.getArea();
        }
        geograpArrayListArea.add(object);
        return object.getArea();
    }

    double calculateArea(double x){ //hình vuông
        Geograp geo = new Geograp(x);
        return returnAndCheckMaxArea(geo);
    }

    double calculateArea(double x, double y){ // hình chữ nhật
        Geograp geo = new Geograp(x,y);
        return returnAndCheckMaxArea(geo);
    }

    double calculateArea(float x){ // hình tròn
        Geograp geo = new Geograp(x);
        return returnAndCheckMaxArea(geo);
    }

    double maxArea(){
        return areaMax;
    }

    // _____________________________________
    public static void main(String[] args) {
        Main program = new Main();
        program.menu();
    }
}

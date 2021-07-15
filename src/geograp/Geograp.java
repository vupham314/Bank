package geograp;

public class Geograp {
    private double x;
    private double y;
    private double area;
    private double circumference;
    private String typeGeo;

    // overding: nạp chồng
    Geograp (double x){ //hinh vuong
        this.x = x;
        this.area = Math.pow(this.x, 2);
        this.circumference = this.x*4;
        this.typeGeo = "hình vuông";
    }

    Geograp (double x, double y){ //hinh chu nhat
        this.x = x;
        this.y = y;
        this.area = this.x*this.y;
        this.circumference = (this.x + this.y)*2;
        this.typeGeo = "hình chữ nhật";
    }

    Geograp (float x){ // hình tròn
        this.x = x;
        this.area = Math.pow(this.x, 2)*Math.PI;
        this.circumference = 2*Math.PI*this.x; // tra ve double
        this.typeGeo = "hình tròn";
    }

    // --------------------get and set----------------------
    public double getArea() {
        return area;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getTypeGeo() { return typeGeo; }

    public void setTypeGeo(String typeGeo) { this.typeGeo = typeGeo; }
}

package Shapes;

public class Box {
    int leng;
    int breadth;
    int height;

    public Box(int l, int b, int h){
        this.leng = l;
        this.breadth = b;
        this.height = h;
    }

//    public void setLeng(int leng) {
//        this.leng = leng; //'this.len' refers to the object's field
//    }
//
//    public int getLeng(){
//        return leng; //returns the object's field value
//    }
//
//    public void setBredth(int breadth){
//        this.breadth = breadth;
//    }
//
//    public int getBredth(){
//        return breadth;
//    }
//
//    public void setHeight(int height){
//        this.height = height;
//    }
//
//    public int getHeight(){
//        return height;
//    }

    public int boxVolume(){
        return leng * breadth * height;
    }

    public static void printLine(){
        System.out.println("*--------------------------------------------------------------------------------------------*");
    }

    public boolean isEqual(Box b2){
        if(leng == b2.leng && breadth == b2.breadth && height == b2.height){
            return true;
        }
        return false;
    }
    public Box doubleBox(){
        Box temp = new Box(2 * leng, 2 * breadth, 2 * height);
//        temp.leng = 2 * this.leng;
//        temp.breadth = 2 * this.breadth;
//        temp.height = 2 * this.height;
        return temp;
    }
}

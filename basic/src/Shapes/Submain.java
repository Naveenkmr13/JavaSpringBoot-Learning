package Shapes;

public class Submain{
    public static void main(String[] args){
        Box blackbox = new Box(1,2,3);  //instance method
//        blackbox.setLeng(10);
//        blackbox.setBredth(5);
//        blackbox.setHeight(8);
//        System.out.println(blackbox.getLeng());
//        System.out.println(blackbox.getBredth());
//        System.out.println(blackbox.getHeight());
        Box b2 = new Box(1,1,3);

        Box.printLine();

//        System.out.println(Box.boxVolume(10,2,3)); //static method
        System.out.println("volume is "+blackbox.boxVolume());


        Box.printLine();
        System.out.println("So the 2 object is : "+blackbox.isEqual(b2));
        Box.printLine();

        Box b3 = b2.doubleBox();
        System.out.println("volume is "+b3.boxVolume());
    }
}

// instance method means to create object for a class then only we can able to access
// static method means with out creating an object we can use class name.method name
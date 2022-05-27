import java.util.*;
public class Test {
    public static void main(String[] args) {
        Object[] x = new Object[10];
        x[0] = "banane";
        System.out.println(x[0]);
    }
}

class A{
    int x;
}

class B extends A{
    int y;
    B(int x) {this.x = x; this.y = 0;}
}
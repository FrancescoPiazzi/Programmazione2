public class Test {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        J j = b;
        if (a.equals(b))
            System.out.println(j.m(1) + b.m("scritto"));
        else System.out.println(j.m(3));
    }
}
interface I {
    int m(int z);
}
interface J extends I {}

class A implements I {
    int x = 10;
    public int m(int z) { return x + z; }
    public boolean equals(Object o) {
        A obj = (A) o;
        return x == obj.x;
    }
}
class B extends A implements J {
    public int m(String s) { return s.length(); }
}
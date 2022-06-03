import java.util.*;
public class Test {
    public static void main(String[] args) {
        A[] a = new A[4];
        for (int i = 0; i < a.length; i++) {
            if (i%2 != 0) a[i]= new A(i);
            else a[i]= new B(i);
        }
        List<A> l = new ArrayList<>(Arrays.asList(a));
        for(A e: l) System.out.print(e.x /*e.m(5)*/ + " ");
    }
}
class A {
    int x;
    A(int x) { this.x = x + 1; System.out.println("-> " + this.x);}
    public int m(int z) { return x + z; }
}
class B extends A {
    B(int x) { super(x); this.x = x + 2; System.out.println("--> " + this.x);}
}
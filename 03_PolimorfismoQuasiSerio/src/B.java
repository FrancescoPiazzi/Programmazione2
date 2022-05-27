public class B extends A{
    void f(A a){
        System.out.println("1");
    }
    void f(B a){
        System.out.println("2");
    }
}

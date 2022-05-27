public class Main {
    public static  void main(){
        A a = new A();
        A ab = new B();
        B b = new B();

        // facile: 0
        a.f(a);
        // tipo statico di ab è A, 1 viene scartato dal compilatore, rimane 0
        a.f(ab);
        // non esiste un overload, ma B is-a A, quindi viene chiamato come se B fosse A, quindi: 0
        a.f(b);
        System.out.println();

        ab.f(a);
        ab.f(ab);
        ab.f(b);
        System.out.println();

        // facile: 1
        b.f(a);
        b.f(ab);
        // facile: 2
        b.f(b);
    }
}

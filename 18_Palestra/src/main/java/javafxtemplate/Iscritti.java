package javafxtemplate;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Iscritti extends ArrayList<Iscritto> {
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Consumer<Iscritto> consumer = o -> {
            String str = o.toString() + " | totale: " + o.prezzoFinale() + "\n";
            s.append(str);
        };
        this.forEach(consumer);
        return s.toString();
    }

    void sortByName(){
        this.sort(new CompareByName());
    }
    void sortByAge(){
        this.sort(new CompareByAge());
    }
}

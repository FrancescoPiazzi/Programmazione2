package calcolatrice;

import java.util.HashMap;
import java.util.Vector;

// ((5-2) + (3 * (2-1) ))
// ( => comincio il buffer, ne faccio il push quando arriva ')'

class CalcolatriceModel {
    final Vector<Character> numbers;
    final Vector<Character> operators;
    final HashMap<Character, Double> constants;
    final Vector<Character> symbols;

    String expression;
    private int state;  // 0: nuovo calcolo 1: inserito qualcosa, aspetto altro 2: pronto per eval

    CalcolatriceModel(){
        expression = "";

        numbers = new Vector<>();
        operators = new Vector<>();
        constants = new HashMap<>();
        symbols = new Vector<>();

        for(char i='0'; i<='9'; i++)
            numbers.add(i);

        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('%');

        constants.put('p', 3.141592653);
        constants.put('e', 2.718281828);

        symbols.addAll(numbers);
        symbols.addAll(operators);
        symbols.addAll(constants.keySet()); // aggiungo i omi delle costanti ai simboli

        state = 0;
    }

    int add(char c){
        // prova ad aggiungere c all'espressione
        // se ci riesce ritorna 0, altrimenti qualcosa > 0
        int valid = isValid(c);
        if (valid == 0) {
            if (state != 0) {
                expression += c;
            }
            else {
                expression = Character.toString(c);
                // TODO: fare questa parte bene controllando che venga inserito l'operatore e la seconda cosa
                state = 2;
            }
            System.out.println("Aggiunto " + c);
        }
        else
            System.out.println("Scartato " + c);

        return valid;
    }

    double evaluate(){
        double result = innerEvaluate(expression);
        expression = Double.toString(result);
        state = 0;
        return result;
    }

    int isValid(char c){
        // provo a inserire una cosa che non è tra i simboli previsti
        if(!isSymbol(c))
            return 1;
        // posso solo cominciare con un numero
        if(expression.equals(""))
            if (isNumber(c) || isConstant(c))
                return 0;
            else
                return 2;
        // l'ultima cosa inserita è un operazione e ne viene inserita un altra
        if(isOperator(getLast()) && isOperator(c))
            return 3;
        // provo a mischiare numeri e simboli
        if(isNumber(getLast()) && isConstant(c))
            return 4;
        // dopo una costante posso mettere solo un operazione
        if(isConstant(getLast()) && !isOperator(c))
            return 5;
        return 0;
    }

    double innerEvaluate(String s){
        System.out.println("Valuto " + s);
        double n1, n2;
        char op;
        
        StringBuilder n1str = new StringBuilder();
        StringBuilder n2str = new StringBuilder();
        
        int i=0;
        for(; !isOperator(s.charAt(i)); i++)
            n1str.append(s.charAt(i));
        n1 = getValue(n1str.toString());

        op = s.charAt(i);
        i++;

        for(; i<s.length(); i++)
            n2str.append(s.charAt(i));
        n2 = Double.parseDouble(String.valueOf(n2str));
        
        switch (op){
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            case '%':
                return n1 % n2;
            default:
                System.out.println("é successo qualcosa di molto brutto: passato un operatore non riconosciuto");
                return 0;
        }
    }

    private char getLast(){
        return expression.charAt(expression.length()-1);
    }
    
    private double getValue(String s){
        double n;
        if(s.length()==1 && isConstant(s.charAt(0)))
            n = constants.get(s.charAt(0));
        else
            n = Double.parseDouble(s);
        return n;
    }

    boolean isSymbol(char c){
        return symbols.contains(c);
    }

    boolean isNumber(char c){
        return numbers.contains(c);
    }

    boolean isConstant(char c){
        return constants.containsKey(c);
    }
    
    boolean isOperator(char c){
        return operators.contains(c);
    }
}

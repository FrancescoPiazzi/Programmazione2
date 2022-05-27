package main;


public class CalcolatriceScarsa {
    // private static final double pi = 3.1415926;
    // private static final double e = 2.71818;
    private final char baseOp = '_';
    private final char[] operators = {'+', '-', '*', '/'};

    private String n1, n2;
    private char op;
    private boolean error;
    private float lastResult;

    public CalcolatriceScarsa(){
        this.setReSet();
    }

    public boolean add(char c){
        if(this.isOperator(c))
            this.op = c;
        else {
            /* sì sto davvero convertendo un carattere a stringa per poi riconvertirlo a intero
            e sto anche rivalutando le mie scelte di vita */
            this.add(Integer.parseInt(Character.toString(c)));
        }
        return true;
    }

    public boolean add(int n){
        if(op == baseOp)
            n1 += Integer.toString(n);
        else
            n2 += Integer.toString(n);
        return true;
    }

    public float evaluate(){
        // controlla che l'operazione sia possibile
        error = !isEvaluationValid();
        if(!error) {
            // se non è stato inserito n1 considero l'ultimo risultato
            if (n1.equals(""))
                n1 = Float.toString(lastResult);
            innerEvaluate();
            setReSet();
            return lastResult;
        }
        else{
            setReSet();
            return 0;
        }
    }

    public boolean isEvaluationValid(){
        if(n2.equals(""))
            return false;
        if(op == baseOp)
            return false;
        if(op == '/' && Float.parseFloat(n2) == 0)
            return false;
        if(n1.equals("") && error)
            return false;
        return true;
    }

    private void innerEvaluate(){
        float n1 = Float.parseFloat(this.n1);
        float n2 = Float.parseFloat(this.n2);
        switch (op){
            case '+':
                lastResult = n1 + n2;
                break;
            case '-':
                lastResult = n1 - n2;
                break;
            case '*':
                lastResult = n1 * n2;
                break;
            case '/':
                lastResult = n1/n2;
                break;
        }
    }

    private boolean isOperator(char c){
        for(char op : operators){
            if(op == c){
                return true;
            }
        }
        return false;
    }

    private void setReSet(){
        // resetta tutte le variabili da resettare una volta finita un operazione
        this.n1 = "";
        this.n2 = "";
        this.op = this.baseOp;
    }

    public String getBuffer(){
        if(op == baseOp)
            return n1;
        else
            return n2;
    }

    public char[] getOperators(){
        return operators;
    }

    public boolean getError(){
        return error;
    }
}

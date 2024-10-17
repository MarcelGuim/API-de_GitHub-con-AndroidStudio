package dsa.example.tdd;

/**
 * Hello world!
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    public int add(int a, int b)
    {
     return a+b;
    }
    public int substract(int a, int b)
    {
        return a-b;
    }
    public int multiply(int a, int b)
    {
        return a*b;
    }
    public int divide(int a, int b)
    {
        if(b == 0)
            throw new IllegalArgumentException("No se puede dividir por 0");
        else
            return a/b;
    }
}

package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Test1> tests= new HashSet<>();

        Test1 un = new Test1("Marcel", 11111111);
        Test1 cinc = new Test1("Marcel", 55555555);
        Test1 dos = new Test1("Carles", 22222222);
        Test1 tres = new Test1("Joan", 33333333);
        Test1 quatre = new Test1("Miquel", 44444444);
        Test1 sis = new Test1("Miquel", 44444444);
        tests.add(cinc);
        tests.add(tres);
        tests.add(un);
        tests.add(quatre);
        tests.add(dos);
        for(Test1 test: tests)
        {
            System.out.println(test.getName() + test.getId());
        }

        List<Test1> tests1 = new ArrayList<>(tests);

        Collections.sort(tests1);
        System.out.println("\n ara venen els noms a la llista ordenats de major a menor: \n");
        for(Test1 test: tests1)
        {
            System.out.println(test.getName() + test.getId());
        }

        Stack<Test1> pila1 = new Stack<>();
        pila1.add(un);
        pila1.add(dos);
        pila1.add(quatre);
        pila1.add(tres);
        pila1.add(cinc);
        System.out.println("\n ara venen els noms a la pila:\n");

        for(Test1 test: pila1)
        {
            System.out.println(test.getName() + test.getId());
        }

        Test1 ultimo_elemento = pila1.pop();
        System.out.println("\n ara venen els noms a la pila post popr:\n");
        Test1 penultimo_elemento = pila1.pop();

        for(Test1 test: pila1)
        {
            System.out.println(test.getName() + test.getId());
        }
        int j = 12;
    }
}

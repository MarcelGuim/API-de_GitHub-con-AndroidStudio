package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test1 implements Comparable<Test1> {
    public static Set<Integer> ids= new HashSet<>();
    public String name;
    public int id;

    public Test1(String name, int id) {
        try{
            if(ids.contains(id))
            {
                throw new IllegalArgumentException( "Id repetido, pon otro usuario" );
            }
            else
            {
                this.name = name;
                this.id = id;
                ids.add(id);
            }
        }
        catch(IllegalArgumentException ex)
        {
            //System.out.println("error. Nombre repetido, pon otro usuario");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Test1 o) {
        return this.id - o.id;
    }

    @Override
    public int hashCode() {
        return Integer.toString(id).hashCode();
    }
}
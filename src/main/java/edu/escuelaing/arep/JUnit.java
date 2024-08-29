package edu.escuelaing.arep;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JUnit {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName(args[0]);
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null, null);
                }catch (InvocationTargetException | IllegalAccessException e){
                    System.err.println("Error invoking method: " + m.getName());
                    System.err.println( e.getCause().getMessage());
                }
            } ;
        }
    }
}

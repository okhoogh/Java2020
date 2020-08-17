package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class T03_ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
        Constructor<?>[] cons = c.getConstructors();
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }
        System.out.println("---------------");
        Constructor<?>[] decons = c.getDeclaredConstructors();
        for (Constructor<?> decon : decons) {
            System.out.println(decon);
        }

        Constructor<?> con = c.getDeclaredConstructor();
        Object obj = con.newInstance();
        System.out.println(obj);
    }
}

package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class T10_ReflectDemo6 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(10);
        array.add(20);
        System.out.println(array);

        Class<? extends ArrayList> c = array.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(array, "666");
        System.out.println(array);
    }
}

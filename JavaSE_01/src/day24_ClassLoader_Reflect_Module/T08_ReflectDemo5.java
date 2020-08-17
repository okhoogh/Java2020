package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class T08_ReflectDemo5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> c = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
//        Method[] methods = c.getMethods();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("------------");
        Method method1 = c.getMethod("method1");
//        System.out.println(method1);
        Constructor<?> con = c.getConstructor();
        Object obj = c.newInstance();
        method1.invoke(obj);
    }
}
